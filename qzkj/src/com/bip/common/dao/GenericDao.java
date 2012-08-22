/************************************************************
 * 类名：GenericDao
 *
 * 类别：通用类
 * 功能：通用HibernateDaoImpl实现类
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2011-5-20  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.common.dao;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.bip.common.util.PaginationSupport;
import com.bip.common.util.QueryJson;
import com.bip.common.util.SqlUtil;
import com.bip.common.util.Tool;

@SuppressWarnings("unchecked")
public class GenericDao<T, ID extends Serializable> extends HibernateDaoSupport
		implements IGenericDao<T, ID> {
	@Autowired  
	   public void setSessionFactoryOverride(SessionFactory sessionFactory)   
	   {   
	 
	      super.setSessionFactory(sessionFactory);   
	  }  
	private Log logger = LogFactory.getLog(getClass());

	protected Class<T> entityClass;
	
	public GenericDao() {

	}

	protected Class getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
			logger.debug("T class = " + entityClass.getName());
		}
		return entityClass;
	}


	public void saveOrUpdate(T t) throws DataAccessException {
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	public T load(ID id) throws DataAccessException {
		T load = (T) getHibernateTemplate().load(getEntityClass(), id);
		return load;
	}

	public T get(ID id) throws DataAccessException {
		T load = (T) getHibernateTemplate().get(getEntityClass(), id);
		return load;
	}

	public boolean contains(T t) throws DataAccessException {
		return getHibernateTemplate().contains(t);
	}

	public void delete(T t, LockMode lockMode) throws DataAccessException {
		getHibernateTemplate().delete(t, lockMode);
	}

	public void delete(T t) throws DataAccessException {
		getHibernateTemplate().delete(t);
	}

	public void deleteAll(Collection<T> entities) throws DataAccessException {
		getHibernateTemplate().deleteAll(entities);
	}

	public List<T> find(String queryString, Object value)
			throws DataAccessException {
		List<T> find = (List<T>) getHibernateTemplate()
				.find(queryString, value);
		return find;
	}

	public List<T> find(String queryString, Object[] values)
			throws DataAccessException {
		List<T> find = (List<T>) getHibernateTemplate().find(queryString,
				values);
		return find;
	}

	public List<T> find(String queryString) throws DataAccessException {
		System.out.println("queryString is "+queryString);
		return (List<T>) getHibernateTemplate().find(queryString);
	}

	public void refresh(T t, LockMode lockMode) throws DataAccessException {
		getHibernateTemplate().refresh(t, lockMode);
	}

	public void refresh(T t) throws DataAccessException {
		getHibernateTemplate().refresh(t);
	}

	public Serializable save(T t) throws DataAccessException {
//		System.out.println("Begin Save to DB ......");
		Serializable s = this.getHibernateTemplate().save(t);
		return s;
	}

	public void saveOrUpdateAll(Collection<T> entities)
			throws DataAccessException {
		getHibernateTemplate().saveOrUpdateAll(entities);
	}

	public void update(T t, LockMode lockMode) throws DataAccessException {
		getHibernateTemplate().update(t, lockMode);
	}

	public void update(T t) throws DataAccessException {
//		System.out.println("Begin update to DB ......");
		getHibernateTemplate().update(t);
	}

	public List<T> list() throws DataAccessException {
		return getHibernateTemplate().loadAll(getEntityClass());

	}

	public List<T> findByNamedQuery(String queryName)
			throws DataAccessException {
		return getHibernateTemplate().findByNamedQuery(queryName);
	}

	public List<T> findByNamedQuery(String queryName, Object value)
			throws DataAccessException {
		return getHibernateTemplate().findByNamedQuery(queryName, value);
	}

	public List<T> findByNamedQuery(String queryName, Object[] values)
			throws DataAccessException {
		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	public PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria, final int pageSize,
			final int startIndex) {
		return (PaginationSupport) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Criteria criteria = detachedCriteria
								.getExecutableCriteria(session);
						int totalCount = ((Integer) criteria.setProjection(
								Projections.rowCount()).uniqueResult())
								.intValue();
						criteria.setProjection(null);
						List items = criteria.setFirstResult(startIndex)
								.setMaxResults(pageSize).list();
						PaginationSupport ps = new PaginationSupport(items,
								totalCount, pageSize, startIndex);
						return ps;
					}
				});
	}

	public PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex) {
		final int pageSize1 = pageSize;
		final int startIndex1 = startIndex;
		final String hql1 = hql;
		final String countHql1 = countHql;
		return (PaginationSupport) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						int totalCount = session.createQuery(countHql1).list()
								.size();
						Query query = session.createQuery(hql1);
						if (totalCount <= startIndex1) {

							query.setFirstResult(startIndex1 - pageSize1);
						} else {
							query.setFirstResult(startIndex1);
						}

						query.setMaxResults(pageSize1);
						List items = query.list();

						PaginationSupport ps;

						if (totalCount <= startIndex1) {
							ps = new PaginationSupport(items, totalCount,
									pageSize1, startIndex1 - pageSize1);
						} else {
							ps = new PaginationSupport(items, totalCount,
									pageSize1, startIndex1);
						}

						return ps;
					}
				});
	}

	/**
	 * 
	 * @param autho
	 *            : syl
	 * @param 批量删除
	 * @return
	 */

	public Boolean delete(String tablename, String where) {
		final StringBuffer sql = new StringBuffer("delete ").append("  from ")
				.append(tablename).append(" where ").append(where);
		System.out.println("delsql is " + sql);
		return (Boolean) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();

						Statement statement = null;
						try {
							statement = conn.createStatement();
							statement.executeUpdate(sql.toString());
							return new Boolean(true);
						} catch (SQLException e) {
							e.printStackTrace();
							return new Boolean(false);

						} finally {

							if (statement != null)
								statement.close();

						}

					}
				});
	}
	

	public Map getSysCodeSupportMap(final String lbbh) {
		// TODO Auto-generated method stub

		return (Map) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						String hql = "select bh,mc from sys_dmzd where lbbh='"
								+ lbbh + "' and startmark=0";
						Statement statement = null;
						ResultSet rs = null;
						Map map;
						try {
							statement = conn.createStatement();
							map = new HashMap();
							List listcode = new ArrayList();
							List listName = new ArrayList();
							rs = statement.executeQuery(hql);
							int i = 0;
							while (rs.next()) {
								listcode.add(rs.getString("bh"));
								listName.add(rs.getString("mc"));
							}
							map.put("listcode", listcode);
							map.put("listName", listName);
							return map;

						} finally {
							if (rs != null)
								rs.close();
							if (statement != null)
								statement.close();
						}
					}
				});

	}

	public List findByGroup(final String sql) {
		return (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						Statement statement = null;
						try {
							statement = conn.createStatement();
							return statement.executeQuery(sql);
						} catch (SQLException e) {
							e.printStackTrace();
							return null;
						} finally {
							if (statement != null)
								statement.close();
						}
					}
				});
	}

	
	public String getLsh(String tablename,String zdmc,String sjdm) {
		String aa="";
		String daytime=Tool.stringOfDate1();
		List list=find("select max("+zdmc+") FROM "+tablename+" where "+zdmc+" like '"+sjdm+daytime+"%'");	

		if(list.get(0)!=null&&list.size()!=0){
			String bb=list.get(0).toString();
			int cc=Integer.parseInt(bb.substring(bb.length()-4, bb.length()))+1;
			String dd=String.valueOf(cc);
			if(dd.length()==1){
				aa=sjdm+daytime+"000"+dd;
			}
		    if(dd.length()==2){
		    	aa=sjdm+daytime+"00"+dd;
		    }
		    if(dd.length()==3){
		    	aa=sjdm+daytime+"0"+dd;
		    }
		    if(dd.length()==4){
		    	aa=sjdm+daytime+dd;
		    }
		}else{
			aa=sjdm+daytime+"0001";
		}
		return aa;
	}
	
	
	
	public String getMbnrlsh(String tablename,String zdmc,String sjdm) {
		String aa="";
		List list;
		if(sjdm.equals("")){
			list=find("select max("+zdmc+") FROM "+tablename+" where cccode='' or cccode is null");
		}else{
			list=find("select max("+zdmc+") FROM "+tablename+" where "+zdmc+" like '"+sjdm+"%'");	
		}
		if(list.get(0)!=null&&list.size()!=0){
			String bb=list.get(0).toString();
			int cc=Integer.parseInt(bb.substring(bb.length()-4, bb.length()))+1;
			String dd=String.valueOf(cc);
			if(dd.length()==1){
				aa=sjdm+"000"+dd;
			}
		    if(dd.length()==2){
		    	aa=sjdm+"00"+dd;
		    }
		    if(dd.length()==3){
		    	aa=sjdm+"0"+dd;
		    }
		    if(dd.length()==4){
		    	aa=sjdm+dd;
		    }
		}else{
			aa=sjdm+"0001";
		}
		return aa;
	}
	
	
	private Hashtable columnsTableInfo = new Hashtable(50, 0.5f);
	
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
	
	public SqlVO getTableInfo(String tablename, Connection db) {

		SqlVO vo = (SqlVO) columnsTableInfo.get(tablename);
		if (vo != null)
			return vo;

		vo = new SqlVO();
		List keyCols1 = SqlUtil.getTableColumns(db, tablename, 2);
		List columns1 = SqlUtil.getTableInfoColumns(db, tablename);

		List columnsStr = new ArrayList();

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
	/**
	 * 批量添加数据库值
	 * 
	 * @param values
	 *            需要添加的值的List集合List中每个对象为Map类型, map的key为列名 注:列名必须小写
	 * @param tablename
	 *            需要修改的表名
	 * @return 是否成功添加
	 * @return
	 * @throws IllegalStateException
	 * @throws HibernateException
	 * @throws DataAccessResourceFailureException
	 * @throws Exception
	 */
	public List addBatchUUid(final List values, final String tablename) {
		return (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
//						System.out.println(session);
						if (values == null || values.size() <= 0)
							return null;
						SqlVO vo = getTableInfo(tablename, conn);
						PreparedStatement prpe = null;
//						System.out.println(vo.getInsertSql());
						prpe = conn.prepareStatement(vo.getInsertSql());
						int i = 1;
						int count1=0;
						for (Iterator iterator = values.iterator(); iterator
								.hasNext();) {
							i = 1;
							Map object = (Map) iterator.next();

							if (vo.getKeys().size() == 1) { // 判断是否只有一个主键
								ColVO key = (ColVO) vo.getKeys().get(0);
									// 通过序列生成
									object.put(key.getName(),UUID.randomUUID().toString());
							}

							addSetPrepareStatement(object, i, prpe, vo.getCols()); // 将数据放入预存的游标中
							prpe.addBatch();
							count1 ++;
							
							if(count1 >= 5000){  
			                    count1 = 0; 			                   
			                    prpe.executeBatch();  			                   
			                } 
						}
						prpe.executeBatch();

						prpe.close();
						conn.close();
						return values;
					}
				});

	}
	
	/**
	 * 将值放入PreparedStatement
	 * 
	 * @param values
	 *            值
	 * @param i
	 *            索引号
	 * @param prpe
	 *            PreparedStatement对象
	 * @param columns
	 *            列名集合
	 * @return i 索引号
	 * @throws SQLException
	 */
	public int addSetPrepareStatement(Map values, int i, PreparedStatement prpe,
			List columns) throws SQLException {
		ColVO col = null;
		Object value = null;
		try {

			for (int j = 0; j < columns.size(); j++) {
				col = (ColVO) columns.get(j);
				
				value = values.get(col.getName());
				
//				System.out.println("===name="+col.getName()+"===value="+value);
				if (value != null&&(!col.isIsnumber()||!value.toString().equals(""))) {
//					System.out.println("====value=="+value+"===="+col.getName()+"=="+value.toString());
//					System.out.println("value instanceof java.util.Date=="+(value instanceof java.util.Date));
//					System.out.println("value instanceof isDate=="+(Tool.isDate(value.toString())));
					if (col.isIsnumber()) {
						
						if (value instanceof java.util.Date)
							prpe.setDate(i, new java.sql.Date(((java.util.Date) value).getTime()));
						else if((value instanceof String) && Tool.isDate(value.toString())) {
							prpe.setDate(i,new java.sql.Date(new java.util.Date(value.toString()).getTime()));
						}else{
						    prpe.setBigDecimal(i, new BigDecimal(value.toString()).setScale(5, BigDecimal.ROUND_HALF_UP));
						}
					} else {

						prpe.setString(i, value.toString());

					}
				} else {
					
                    if(col.getDefVal()==null)
					prpe.setObject(i, null);
                    else{
                    	if(col.isIsnumber())
					   prpe.setBigDecimal(i, new BigDecimal(col.getDefVal()).setScale(5, BigDecimal.ROUND_HALF_UP));
                    	else
                       prpe.setString(i, col.getDefVal());
                    }
				}

				i++;
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();

			throw new SQLException(e.getMessage() + " col " + col.getName());

		}
		return i;
	}
	
	
	
	public List query(final String sql) {
		return (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();

						ResultSet rs = null;
						Statement statement = null;
						List list = new ArrayList();

						try {
							statement = conn.createStatement();
							rs = statement.executeQuery(sql);
							ResultSetMetaData rsmd = rs.getMetaData(); // 获得结果集的模型（列的相关信息）

										
							int columnCount = rsmd.getColumnCount(); // 获得一共有多少类
							Map vo = null;
							while (rs.next()) {
								vo = new HashMap();
								for (int i = 1; i <= columnCount; i++) {
									vo.put(rsmd.getColumnName(i).toLowerCase(),rs.getObject(i));

								}
								list.add(vo);
							}

						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if (rs != null)
								rs.close();
							if (statement != null)
								statement.close();
							if (conn != null)
								conn.close();
						}
						return list;

					}
				});

	}
	/**
	 * 方法描述：追加查询条件<br>
	 * 创立时间 ： 2012-04-24<br>
	 * 创建人： 朱江 <br>
	 * 
	 * @param sql将要拼加的sql
	 * @param conditions需要被追加的查询条件
	 * @param invokeClass执行方法的类
	 *            需注意前台js关于日期条件开始必须以"dateStart-"加上所对应字段,结束必须以"dateEnd-"加上所对应字段,
	 *            对于不支持模糊查询的处理则是 "status-"加所对应字段 对应in查询的处理则是"in-"加所对应字段
	 * @return 拼装的HQl语句
	 */
	public String appendSql(StringBuilder sql, List<String[]> conditions,
			Class invokeClass) {
		String orderby="";
		if (null != conditions && conditions.size() > 0) {
			for (String[] condition : conditions) {
				if (condition.length > 1) {
					String field = condition[0]; // 字段名
					String value = condition[1]; // 字段条件值
					if (StringUtils.isBlank(value)||StringUtils.isBlank(field)||field.equals("1")) {
						continue;
					}
					if (field.indexOf("-") != -1) {
						String[] s = field.split("-");
						if ("dateStart".equals(s[0])) {
							sql.append(" and p.").append(s[1]).append(
									">='").append(value.trim()).append(
									"' ");
							continue;
						}
						if ("dateEnd".equals(s[0])) {
							sql.append(" and p.").append(s[1]).append(
									"<='").append(value.trim()).append(
									"'");
							continue;
						}
						if ("status".equals(s[0])) {
							sql.append(" and p.").append(s[1]).append("= '")
									.append(value.trim()).append("'");
							continue;
						}
						if ("in".equals(s[0])) {
							sql.append(" and p.").append(s[1]).append(" in(")
									.append(value.trim()).append(")");
							continue;
						}
						if ("numStart".equals(s[0])) {
							sql.append(" and p.").append(s[1]).append(
									">=").append(value.trim()).append(
									" ");
							continue;
						}
						if ("numEnd".equals(s[0])) {
							sql.append(" and p.").append(s[1]).append(
									"<=").append(value.trim()).append(
									" ");
							continue;
						}
						if ("startWith".equals(s[0])) {
							sql.append(" and p.").append(s[1]).append(
									" like '").append(value.trim()).append(
									"%' ");
							continue;
						}
					
					}
					if(field.equals("orderby"))
						orderby=" order by p."+value.trim()+(condition.length>2?(" "+condition[2]):" asc");
					else
					sql.append(" and p.").append(field).append(" like \'%")
							.append(value.trim()).append("%\' ");
				}
			}
		}
//		// 根据方法名执行调用相应方法
//		if (StringUtils.isNotBlank(methodName)) {
//			sql = (StringBuilder) BeanUtils.invokeMethodByName(invokeClass,
//					methodName,
//					new Class[] { StringBuilder.class, User.class },
//					new Object[] { sql, user });
//		}
		
		return sql.toString()+orderby;
	}
	/**
	 * 方法描述：联表查询追加查询条件<br>
	 * 创立时间 ： 2012-04-24<br>
	 * 创建人： 朱江 <br>
	 * 
	 * @param sql将要拼加的sql
	 * @param conditions需要被追加的查询条件
	 * @param invokeClass执行方法的类
	 *            需注意前台js关于日期条件开始必须以"dateStart-"加上所对应字段,结束必须以"dateEnd-"加上所对应字段,
	 *            对于不支持模糊查询的处理则是 "status-"加所对应字段 对应in查询的处理则是"in-"加所对应字段
	 * @return 拼装的HQl语句
	 */
	public String appendSql2(StringBuilder sql, List<String[]> conditions,
			Class invokeClass) {
		String orderby="";
		if (null != conditions && conditions.size() > 0) {
			for (String[] condition : conditions) {
				if (condition.length > 1) {
					String field = condition[0]; // 字段名
					String value = condition[1]; // 字段条件值
					if (StringUtils.isBlank(value)||StringUtils.isBlank(field)||field.equals("1")) {
						continue;
					}
					if (field.indexOf("-") != -1) {
						String[] s = field.split("-");
						if ("dateStart".equals(s[0])) {
							sql.append(" and ").append(s[1]).append(
									">='").append(value.trim()).append(
									"' ");
							continue;
						}
						if ("dateEnd".equals(s[0])) {
							sql.append(" and ").append(s[1]).append(
									"<='").append(value.trim()).append(
									"'");
							continue;
						}
						if ("status".equals(s[0])) {
							sql.append(" and ").append(s[1]).append("= '")
									.append(value.trim()).append("'");
							continue;
						}
						if ("in".equals(s[0])) {
							sql.append(" and ").append(s[1]).append(" in(")
									.append(value.trim()).append(")");
							continue;
						}
						if ("numStart".equals(s[0])) {
							sql.append(" and ").append(s[1]).append(
									">=").append(value.trim()).append(
									" ");
							continue;
						}
						if ("numEnd".equals(s[0])) {
							sql.append(" and ").append(s[1]).append(
									"<=").append(value.trim()).append(
									" ");
							continue;
						}
						if ("startWith".equals(s[0])) {
							sql.append(" and ").append(s[1]).append(
									" like '").append(value.trim()).append(
									"%' ");
							continue;
						}
					}
					if(field.equals("orderby"))
						orderby=" order by "+value.trim();
					else
					sql.append(" and ").append(field).append(" like \'%")
							.append(value.trim()).append("%\' ");
				}
			}
		}
//		// 根据方法名执行调用相应方法
//		if (StringUtils.isNotBlank(methodName)) {
//			sql = (StringBuilder) BeanUtils.invokeMethodByName(invokeClass,
//					methodName,
//					new Class[] { StringBuilder.class, User.class },
//					new Object[] { sql, user });
//		}
		return sql.toString()+orderby;
	}

	public QueryJson findPageByQuery(final Class voClazz, List conList,
			int pageSize, int startIndex) {
		final int pageSize1 = pageSize;
		final int startIndex1 = startIndex;
		final String hql1 = appendSql(new StringBuilder("From "+getEntityClass().getName()+" p where 1=1 "),conList,null);
		final String countHql1 = appendSql(new StringBuilder("select count(*) From "+getEntityClass().getName()+" p where 1=1 "),conList,null);;
		return (QueryJson) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							 {
						List items=null;
						int totalCount=0 ;
						try{
					    totalCount = Integer.parseInt(session.createQuery(countHql1).uniqueResult().toString());
						Query query = session.createQuery(hql1);
						if (totalCount <= startIndex1) {

							query.setFirstResult(startIndex1 - pageSize1);
						} else {
							query.setFirstResult(startIndex1);
						}

						query.setMaxResults(pageSize1);
						items = query.list();
						}catch(Exception e)
						{
							e.printStackTrace();
						}
						if(items!=null&&items.size()>0&&voClazz!=null)
						{
							List temp=new ArrayList();
							for(Object obj:items)
							{
								try {
									temp.add(Tool.cloneObj(obj,voClazz.newInstance()));
								} catch (InstantiationException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							items.clear();
							items.addAll(temp);
						}
						QueryJson json=new QueryJson(totalCount, items);
						return json;
					}
				});
	}
	
	public QueryJson findPageByQuery(String sql,String countsql,final Class voClazz, List conList,
			int pageSize, int startIndex) {
		final int pageSize1 = pageSize;
		final int startIndex1 = startIndex;
		final String sql1 = appendSql2(new StringBuilder("select * from ("+sql+" and rownum<="+(startIndex==0?pageSize:pageSize*startIndex)+") where ROWNO>"+(startIndex>1?(startIndex-1)*pageSize:0)),conList,null);
		final String countHql1 = appendSql2(new StringBuilder(countsql),conList,null);
		return (QueryJson) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						int totalCount = Integer.parseInt(session.createSQLQuery(countHql1).uniqueResult().toString());
						Connection conn = session.connection();
						ResultSet rs = null;
						Statement statement = null;
						List items = new ArrayList();

						try {
							statement = conn.createStatement();
							System.out.println(sql1);
							rs = statement.executeQuery(sql1);
							ResultSetMetaData rsmd = rs.getMetaData(); // 获得结果集的模型（列的相关信息）

										
							int columnCount = rsmd.getColumnCount(); // 获得一共有多少类
							Map vo = null;
							while (rs.next()) {
								vo = new HashMap();
								for (int i = 1; i <= columnCount; i++) {
									vo.put(rsmd.getColumnName(i).toLowerCase(),rs.getObject(i));

								}
								items.add(vo);
							}

						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if (rs != null)
								rs.close();
							if (statement != null)
								statement.close();
							if (conn != null)
								conn.close();
						}
						
						
						if(items!=null&&items.size()>0&&voClazz!=null)
						{
							List temp=new ArrayList();
							for(Object obj:items)
							{
								try {
									temp.add(Tool.cloneMapToObj((Map)obj,voClazz.newInstance()));
								} catch (InstantiationException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							items.clear();
							items.addAll(temp);
						}
						QueryJson json=new QueryJson(totalCount, items);
						return json;
					}
				});
	}

	public QueryJson findPageByQuery(String hql, String countHql, List conList,
			int pageSize, int startIndex) {
		final int pageSize1 = pageSize;
		final int startIndex1 = startIndex;
		final String hql1 = appendSql2(new StringBuilder(hql),conList,null);
		final String countHql1 = appendSql2(new StringBuilder(countHql),conList,null);
		return (QueryJson) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							 {
						List items=null;
						int totalCount=0 ;
						try{
					    totalCount = Integer.parseInt(session.createQuery(countHql1).uniqueResult().toString());
						Query query = session.createQuery(hql1);
						if (totalCount <= startIndex1) {

							query.setFirstResult(startIndex1 - pageSize1);
						} else {
							query.setFirstResult(startIndex1);
						}

						query.setMaxResults(pageSize1);
						items = query.list();
						}catch(Exception e)
						{
							e.printStackTrace();
						}
						QueryJson json=new QueryJson(totalCount, items);
						return json;
					}
				});
	}

	public List queryBySql(final String sql,final Class voClazz) {
		return (List) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						ResultSet rs = null;
						Statement statement = null;
						List items = new ArrayList();

						try {
							statement = conn.createStatement();
							System.out.println(sql);
							rs = statement.executeQuery(sql);
							ResultSetMetaData rsmd = rs.getMetaData(); // 获得结果集的模型（列的相关信息）

										
							int columnCount = rsmd.getColumnCount(); // 获得一共有多少类
							Map vo = null;
							while (rs.next()) {
								vo = new HashMap();
								for (int i = 1; i <= columnCount; i++) {
									vo.put(rsmd.getColumnName(i).toLowerCase(),rs.getObject(i));

								}
								items.add(vo);
							}

						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if (rs != null)
								rs.close();
							if (statement != null)
								statement.close();
							if (conn != null)
								conn.close();
						}
						
						
						if(items!=null&&items.size()>0&&voClazz!=null)
						{
							List temp=new ArrayList();
							for(Object obj:items)
							{
								try {
									temp.add(Tool.cloneMapToObj((Map)obj,voClazz.newInstance()));
								} catch (InstantiationException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							items.clear();
							items.addAll(temp);
						}
						return items;
					}
				});
	}
	@Deprecated
	public int update(final String sql) {
		return (Integer) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						Statement statement = null;
						try {
							statement = conn.createStatement();
							return statement.executeUpdate(sql);
						} catch (SQLException e) {
							e.printStackTrace();
							return -1;
						} finally {
							if (statement != null)
								statement.close();
						}
					}
				});
	}
}
