package com.bip.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.bip.common.dao.ColVO;

public class SqlUtil {

	static public Map ObjectToMap(Object object) {
		if (object == null)
			return null;
		Class myclass = object.getClass();
		Map map = new HashMap();
		BeanInfo info;
		try {
			info = Introspector.getBeanInfo(myclass);

			PropertyDescriptor pd[] = info.getPropertyDescriptors();
			String name = null;
			for (int i = 0; i < pd.length; i++) {

				name = pd[i].getName();
				try {
					map.put(name, BeanUtils.getProperty(object, name));
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IntrospectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return map;

	}

	/**
	 * 把结果集生成DTO对象集
	 * 
	 * @param rs
	 * @param oBean
	 * @return
	 * @throws SQLException
	 */
	public Object getObjByMap(Map zbMap, Object oBean) {

		try {
			BeanUtils.populate(oBean, zbMap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return oBean;

	}

	public static String getUpdateSql(String tableName, Collection columns,
			String whereColumns[]) {
		StringBuffer sql1 = new StringBuffer("update  ").append(tableName)
				.append(" set ");
		int j = 0;
		int length = columns.size();

		Iterator itr = columns.iterator();
		String string = null;
		while (itr.hasNext()) {
			string = (String) itr.next();
			sql1.append(string).append("=").append("?");

			if (j != length - 1) {
				sql1.append(",");

			} else {
				sql1.append(" where ");
			}
			j++;
		}
		for (int i = 0; i < whereColumns.length; i++) {

			sql1.append(whereColumns[i]).append("=").append("?");

			if (i != whereColumns.length - 1) {
				sql1.append(" and ");

			}
		}

		return sql1.toString();
	}

	public static String getInsertSql(String tableName, Collection columns) {
		StringBuffer sql1 = new StringBuffer("insert into ").append(tableName)
				.append(" (");
		StringBuffer sql2 = new StringBuffer("  values ( ");
		int i = 0;
		String string = null;
		Iterator itr = columns.iterator();
		int length = columns.size() - 1;
		while (itr.hasNext()) {
			string = (String) itr.next();
			sql1.append(string);

			sql2.append("?");
			if (i != length) {
				sql1.append(",");
				sql2.append(",");
			} else {
				sql1.append(")");
				sql2.append(")");
			}
			i++;
		}
		return (sql1.append(sql2)).toString();

	}

	public static boolean pandTableName(String tableName, Connection con) {

		ResultSet rs = null;
		try {

			rs = con.getMetaData().getColumns(null, null, tableName, null);

			return rs.next();

		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}

		}

	}

	public static String getWhere(Map map, String tabtyname, List<ColVO> list) {
		Object value = null;

		StringBuilder where = new StringBuilder();
		boolean pand = false;
		for (ColVO colVO : list) {

			value = map.get(colVO.getName());
			if (value != null) {
				if (pand)
					where.append(" and ");
				else
					pand = true;
				if (colVO.isIsnumber())
					where.append(colVO.getName()).append("=").append(value);
				else
					where.append(colVO.getName()).append("='").append(value)
							.append("' ");
			}

		}
		return where.toString();

	}

	public static List getTableInfoColumns(Connection con, String tableName) {

		List columns = new ArrayList();
		ResultSet rs = null;
		try {

			DatabaseMetaData metaData = con.getMetaData();
			rs = metaData.getColumns(null, metaData.getUserName(), tableName.toUpperCase(), null);

			Map map = null;
			while (rs.next()) {

				map = new HashMap();
				map
						.put("columnName", rs.getString("COLUMN_NAME")
								.toLowerCase());
				// System.out.println("VVVVVVVVVVVVVV=="+rs.getString("TYPE_NAME").toLowerCase());
				map.put("isnumber", new Boolean(rs.getString("TYPE_NAME")
						.toLowerCase().indexOf("char") == -1));
				map.put("defVal", rs.getString("COLUMN_DEF"));
				columns.add(map);

			}

		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}

		}

		return columns;
	}

	public static List getTableColumns(Connection con, String tableName,
			int isPrimaryKey) {
		List columns = new ArrayList();
		ResultSet rs = null;
		try {
			DatabaseMetaData metaData = con.getMetaData();
			if (isPrimaryKey < 2)
				rs = metaData.getColumns(null, metaData.getUserName(),
						tableName, null);
			else if (isPrimaryKey == 2){
				System.out.println(metaData.getUserName()+"========111111111111");
				System.out.println(tableName.toUpperCase()+"========22222222222");
				rs = metaData.getPrimaryKeys(null, metaData.getUserName(),
						tableName.toUpperCase());
			}
			while (rs.next()) {
				if (isPrimaryKey == 1) {
					String isnull = rs.getString("IS_NULLABLE");

					if (isnull != null && isnull.equals("NO"))
//						System.out.println(rs.getString("COLUMN_NAME").toLowerCase()+"====");
						columns.add(rs.getString("COLUMN_NAME").toLowerCase());
				} else
					columns.add(rs.getString("COLUMN_NAME").toLowerCase());
			}

		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}

		}

		if (isPrimaryKey > 1 && columns.size() <= 0)
			return getTableColumns(con, tableName, isPrimaryKey - 1);

		return columns;
	}

	public static List<String> getSqlParameter2(String sql, char startStr,
			char endStr) {
		char[] sqlArray = sql.toCharArray();

		List<String> list = new ArrayList<String>();
		boolean pand = false;
		StringBuilder parameter = new StringBuilder(10);
		for (int i = 0; i < sqlArray.length; i++) {
			if (!pand && sqlArray[i] == startStr) {

				pand = true;
				// System.out.println(sqlArray[i]+""+sqlArray[i+1]+""+sqlArray[i+2]+""+sqlArray[i+3]+""+sqlArray[i+4]);
			} else if (sqlArray[i] == endStr) {
				list.add(parameter.toString());
				// System.out.println(list);
				parameter = new StringBuilder(10);
				pand = false;

			} else if (pand) {
				parameter.append(sqlArray[i]);
			}

		}

		return list;

	}
}
