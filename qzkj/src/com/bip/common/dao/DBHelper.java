/************************************************************
 * ������DBHelper.java
 *
 * ���ͨ����
 * ���ܣ����ݿ�ֱ����
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2011-5-20  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.common.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBHelper {
	private static final String OPTION_FILE_NAME = "dbconfig";
	private static String drivers;
	private static String url;
	private static String user;
	private static String password;

	public static String DATABASE_ENCODING = "GB2312";
	public static String APPLICATION_ENCODING = "GBK";
	public static boolean NEED_DECODING = true;
	static {
		try
		{
		drivers ="com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/cardb?useUnicode=true&amp;characterEncoding=GBK";
		user = "root";
		password = "root";
		}
		catch(Exception ex)
		{
		System.out.println("IO��ȡ�����Ҳ���dbconfig.properties!");
		}
	}

	public static Connection getConnection() throws SQLException {

		Connection conn = null;
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName(drivers).newInstance();
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn == null) {
			throw new SQLException("DBUtils: Cannot get connection.");
		}
		return conn;
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		closeRs(rs);
		closeSt(stmt);
		closeConn(conn);
	}

	public static void closeConn(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("DBUtils: Cannot close connection.");
		}
	}

	public static void closeSt(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("DBUtils: Cannot close statement.");
		}
	}

	public static void closeRs(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("DBUtils: Cannot close resultset.");
		}
	}

	/*
	 * ���������ݿ����ʱ���Ƿ���Ҫ�����ַ�������ת���ı��
	 * 
	 * @param newFlag �µı�ǡ�Ϊ���ʾ��Ҫת�������򣬲���Ҫ
	 */
	synchronized public static void setNeedEncoding(boolean newFlag) {
		NEED_DECODING = newFlag;
	}

	/*
	 * �����Ƿ���Ҫ�������ݿ��Ӧ��֮�����ݵı���ת����ǣ������ݿ��ַ���ת��Ϊ Ӧ�ñ�����ַ���
	 * 
	 * @param dbString
	 * 
	 * @return
	 */
	public static String db2app(String dbString) {
		if (NEED_DECODING && dbString != null) {
			try {
				return new String(dbString.getBytes(DATABASE_ENCODING),
						APPLICATION_ENCODING);
			} catch (java.io.UnsupportedEncodingException uee) {
				return dbString==null?"":dbString;
			}
		} else {
			return dbString==null?"":dbString;
		}
	}

	/*
	 * �����Ƿ���Ҫ�������ݿ��Ӧ��֮�����ݵı���ת����ǣ������ݿ��ַ���ת��Ϊ Ӧ�ñ�����ַ���
	 * 
	 * @param dbString
	 * 
	 * @return
	 */
	public static String app2db(String appString) {
		if (NEED_DECODING && appString != null) {
			if (!appString.equals("")) {
				try {
					return new String(appString.getBytes(APPLICATION_ENCODING),
							DATABASE_ENCODING);
				} catch (java.io.UnsupportedEncodingException uee) {
					return appString==null?"":appString;
				}
			} else
				return appString==null?"":appString;
		} else {
			return appString==null?"":appString;
		}
	}

	public static String app2Excel(String dbString) {

		try {
			return new String(dbString.getBytes("GBK"), "GB2312");
		} catch (java.io.UnsupportedEncodingException uee) {
			return dbString;
		}

	}
}