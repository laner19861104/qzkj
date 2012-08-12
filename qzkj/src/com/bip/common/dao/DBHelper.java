/************************************************************
 * 类名：DBHelper.java
 *
 * 类别：通用类
 * 功能：数据库直连类
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2011-5-20  CFIT-PM   赵胜运         初版
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
		System.out.println("IO读取出错，找不到dbconfig.properties!");
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
	 * 设置在数据库访问时，是否需要进行字符串编码转换的标记
	 * 
	 * @param newFlag 新的标记。为真表示需要转换，否则，不需要
	 */
	synchronized public static void setNeedEncoding(boolean newFlag) {
		NEED_DECODING = newFlag;
	}

	/*
	 * 根据是否需要进行数据库和应用之间数据的编码转换标记，把数据库字符串转换为 应用编码的字符串
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
	 * 根据是否需要进行数据库和应用之间数据的编码转换标记，把数据库字符串转换为 应用编码的字符串
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