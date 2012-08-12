package com.bip.common.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.sql.Connection;

import com.bip.common.util.SqlUtil;

public class SQLBean {
	final static public int INSERT_SQL = 1;
	final static public int UPDATE_SQL = 2;
	private Hashtable columnsTableInfo = new Hashtable(50, 0.5f);

	protected SqlVO getQuerySqlVo(Collection columns, String tablename,
			String where, Connection db) {
		SqlVO vo = null;

		if (columns == null) {
			vo = (SqlVO) getTableInfo(tablename, db, null);

			if (where != null && !where.equals("")) {
				vo = (SqlVO) vo.clone();
				vo.setSql(vo.getSql()
						+ (where != null && !where.equals("") ? " where "
								+ where : ""));
			}

		} else {
			vo = new SqlVO();
			List list = new ArrayList();
			ColVO cvo = null;
			for (Iterator iterator = columns.iterator(); iterator.hasNext();) {
				String column = (String) iterator.next();
				cvo = new ColVO();
				cvo.setName(column);
				list.add(cvo);

			}
			vo.setCols(list);
			vo.setTablename(tablename);
			vo.setSql(getQuerySql(columns, tablename, where));
		}
		return vo;
	}

	private String getQuerySql(Collection columns, String tablename,
			String where) {
		String column;
		StringBuffer sql = new StringBuffer(100);
		sql.append("select ");
		for (Iterator iterator = columns.iterator(); iterator.hasNext();) {
			column = (String) iterator.next();
			sql.append(column).append(",");

		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(" from ").append(tablename);

		if (where != null && !where.equals(""))
			sql.append(" where ").append(where);

		return sql.toString();

	}

	public SqlVO getTableInfo(String tablename, Connection db, Map values) {
		SqlVO vo = getTableInfo(tablename, db);
		if (values == null)
			return vo;

		List list = vo.getCols();
		List rList = new ArrayList();
		List colname = new ArrayList();
		String key[] = new String[vo.getKeys().size()];
		SqlVO sqlVo = new SqlVO();
		int i = 0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			ColVO col = (ColVO) iterator.next();
			if (col.isKey()) {
				key[i] = col.getName();
				i++;
				rList.add(col);
				colname.add(col.getName());
			} else if (values.get(col.getName()) != null
					&& !values.get(col.getName()).toString().equals("")) {
				rList.add(col);
				colname.add(col.getName());
			}
			// System.out.println(col.getName());
		}
		List keys = new ArrayList();
		keys.addAll(vo.getKeys());
		sqlVo.setTablename(vo.getTablename());
		sqlVo.setCols(rList);
		sqlVo.setKeys(keys);

		// sqlVo.setInsertSql(SqlUtil.getInsertSql(tablename, colname));
		sqlVo.setUpdateSql(SqlUtil.getUpdateSql(tablename, colname, key));

		return sqlVo;

	}

	/**
	 * zyl专用 修改map中的所有值无论其值是否为空
	 * 
	 * @param tablename
	 * @param db
	 * @param values
	 * @return
	 */
	public SqlVO getTableInfoByMap(String tablename, Connection db, Map values) {
		SqlVO vo = getTableInfo(tablename, db);
		if (values == null)
			return vo;

		List list = vo.getCols();
		List rList = new ArrayList();
		List colname = new ArrayList();
		String key[] = new String[vo.getKeys().size()];
		SqlVO sqlVo = new SqlVO();
		int i = 0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			ColVO col = (ColVO) iterator.next();
			if (col.isKey()) {
				key[i] = col.getName();
				i++;
				rList.add(col);
				colname.add(col.getName());
			} else if (values.containsKey(col.getName())) {
				rList.add(col);
				colname.add(col.getName());
			}
			// System.out.println(col.getName());
		}
		List keys = new ArrayList();
		keys.addAll(vo.getKeys());
		sqlVo.setTablename(vo.getTablename());
		sqlVo.setCols(rList);
		sqlVo.setKeys(keys);

		// sqlVo.setInsertSql(SqlUtil.getInsertSql(tablename, colname));
		sqlVo.setUpdateSql(SqlUtil.getUpdateSql(tablename, colname, key));

		return sqlVo;

	}

	public SqlVO getTableInfo(String tablename, Connection db) {

		SqlVO vo = (SqlVO) columnsTableInfo.get(tablename);
		if (vo != null)
			return vo;

		vo = new SqlVO();
		List keyCols1 = SqlUtil.getTableColumns(db, tablename, 2);
		List columns1 = SqlUtil.getTableInfoColumns(db, tablename);
		System.out.println(keyCols1);
		System.out.println(columns1);
		List columnsStr = new ArrayList();
		System.out.println(columnsStr);
		List columns = new ArrayList();
		List keyCols = new ArrayList();
		ColVO col = null;
		for (Iterator iterator = columns1.iterator(); iterator.hasNext();) {
			Map column = (Map) iterator.next();
			col = new ColVO();
			col.setIsnumber(((Boolean) column.get("isnumber")).booleanValue());
			col.setName(column.get("columnName").toString());
			col.setDefVal((String) column.get("defVal"));
			columns.add(col);
			columnsStr.add(col.getName());
		}

		int i = 0;
		int j = 0;
		for (Iterator iterator = keyCols1.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			for (Iterator iterator2 = columns.iterator(); iterator2.hasNext();) {
				ColVO column = (ColVO) iterator2.next();

				if (key.equals(column.getName())) {
					column.setKey(true);
					keyCols.add(column);

					break;
				}
				j++;
			}
			i++;
		}

		String insertSql = SqlUtil.getInsertSql(tablename, columnsStr);
		// if(keyCols.size()==1)
		// insertSql=replaceSQLSequences(insertSql, j,
		// ("S"+tablename.substring(1)+".NEXTVAL").toUpperCase());
		//		

		String updateSql = SqlUtil.getUpdateSql(tablename, columnsStr,
				(String[]) keyCols1.toArray(new String[keyCols1.size()]));
		vo.setCols(columns);
		vo.setKeys(keyCols);

		vo.setInsertSql(insertSql);
		vo.setUpdateSql(updateSql);
		vo.setSql(getQuerySql(columnsStr, tablename, null));

		columnsTableInfo.put(tablename, vo);

		return vo;
	}

	public class SqlVO {

		private String updateSql = null;
		private String insertSql = null;
		private String sql = null;

		private List cols = null;
		private List keys = null;

		String tablename;

		public Object clone() {
			SqlVO vo = new SqlVO();

			vo.setInsertSql(this.insertSql);
			vo.setUpdateSql(this.updateSql);
			vo.setSql(this.sql);
			vo.setCols(this.cols);
			vo.setKeys(this.keys);
			vo.setTablename(this.tablename);
			return vo;

		}

		public List getKeys() {
			return keys;
		}

		public void setKeys(List keys) {
			this.keys = keys;
		}

		public List getCols() {
			return cols;
		}

		public void setCols(List cols) {
			this.cols = cols;
		}

		public String getSql() {
			return sql;
		}

		public void setSql(String sql) {
			this.sql = sql;
		}

		public String getUpdateSql() {
			return updateSql;
		}

		public void setUpdateSql(String updateSql) {
			this.updateSql = updateSql;
		}

		public String getInsertSql() {
			return insertSql;
		}

		public void setInsertSql(String insertSql) {
			this.insertSql = insertSql;
		}

		public String getTablename() {
			return tablename;
		}

		public void setTablename(String tablename) {
			this.tablename = tablename;
		}

	}
}
