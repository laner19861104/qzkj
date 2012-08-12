package com.bip.common.dao;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.SystemException;

import net.sf.json.JSONArray;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsDateJsonBeanProcessor;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bip.common.dao.SQLBean.SqlVO;
import com.bip.common.page.Page;
import com.bip.common.page.PageModel;

import com.bip.common.util.PaginationSupport;
import com.bip.common.util.Tool;
import com.bip.common.util.TotalJson;


public class MapDataDao  extends HibernateDaoSupport {

	public SQLBean sqlBean = null;
	JsDateJsonBeanProcessor beanProcessor = new JsDateJsonBeanProcessor();
	JsonConfig config = new JsonConfig();

	/**
	 * 
	 * @param sqlBean
	 */
	public void setSqlBean(SQLBean sqlBean) {
		this.sqlBean = sqlBean;
	}

	public SQLBean getSqlBean() {
		return sqlBean;
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
	public int setPrepareStatement(Map values, int i, PreparedStatement prpe,
			List columns) throws SQLException {
		ColVO col = null;
		Object value = null;
		try {

			for (int j = 0; j < columns.size(); j++) {
				col = (ColVO) columns.get(j);

				
				
				value = values.get(col.getName().toLowerCase());
				if (value != null) {
					if (col.isIsnumber()) {

						if (value instanceof java.util.Date)
							prpe.setDate(i, new java.sql.Date(
									((java.util.Date) value).getTime()));
						else {
							value = value.toString();
							if (!value.equals(""))
								prpe.setBigDecimal(i, new BigDecimal(
										(String) value));
							else
								prpe.setObject(i, null);
						}
					} else {

						prpe.setString(i, value.toString());

					}
				} else {

					prpe.setObject(i, null);
				}

				i++;
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();

			throw new SQLException(e.getMessage() + " col " + col.getName());

		}
		return i;
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
	 * 
	 */
	public int addSetPrepareStatement(Map values, int i, PreparedStatement prpe,
			List columns) throws SQLException {
		ColVO col = null;
		Object value = null;
		try {

			for (int j = 0; j < columns.size(); j++) {
				col = (ColVO) columns.get(j);
				
				value = values.get(col.getName());
				
				if (value != null&&(!col.isIsnumber()||!value.toString().equals(""))) {

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
	
	
	
	/**
	 * 修改数据库值
	 * 
	 * @param values
	 *            需要修改的值, map的key为列名 注:列名必须小写
	 * @param tablename
	 *            需要修改的表名
	 * @return 是否成功修改
	 * @throws DataAccessResourceFailureException
	 * @throws HibernateException
	 * @throws IllegalStateException
	 */
	public Map update(final Map values, final String tablename) {

		return update(values, tablename, sqlBean);
	}
	/**
	 * 修改数据库值所有
	 * 
	 * @param values
	 *            需要修改的值, map的key为列名 注:列名必须小写
	 * @param tablename
	 *            需要修改的表名
	 * @return 是否成功修改
	 * @throws DataAccessResourceFailureException
	 * @throws HibernateException
	 * @throws IllegalStateException
	 */
	public Map updateAll(final Map values, final String tablename) {

		return (Map) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
//						System.out.println("<<<<tablename>>>==" + tablename);
//						System.out.println("<<<<conn>>>==" + conn);
						SqlVO vo = sqlBean.getTableInfo(tablename, conn);
						PreparedStatement prpe = null;

						prpe = conn.prepareStatement(vo.getUpdateSql());

						int i = 1;
						i = setPrepareStatement(values, i, prpe, vo.getCols());
						setPrepareStatement(values, i, prpe, vo.getKeys());
						prpe.executeUpdate();
						prpe.close();

						return values;
					}
				});
	}

	public Map update(final Map values, final String tablename,
			final SQLBean sqlBean) {
		return (Map) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
//						System.out.println("<<<<tablename>>>==" + tablename);
//						System.out.println("<<<<conn>>>==" + conn);
						SqlVO vo = sqlBean
								.getTableInfo(tablename, conn, values);
						PreparedStatement prpe = null;
//						System.out.println("<<<<conn>>>==" + vo.getUpdateSql());
						prpe = conn.prepareStatement(vo.getUpdateSql());

						int i = 1;
						i = setPrepareStatement(values, i, prpe, vo.getCols());
						setPrepareStatement(values, i, prpe, vo.getKeys());
						prpe.executeUpdate();
						prpe.close();

						return values;
					}
				});

	}

	/**
	 * 批量修改数据库值
	 * 
	 * @param values
	 *            需要添加的值的List集合List中每个对象为Map类型, map的key为列名 注:列名必须小写
	 * @param tablename
	 *            需要修改的表名
	 * @return 是否成功修改
	 * @throws DataAccessResourceFailureException
	 * @throws HibernateException
	 * @throws IllegalStateException
	 */
	public List updateBatch(final List values, final String tablename) {
		return (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
//						System.out.println(session);

						if (values == null || values.size() <= 0)
							return null;
						SqlVO vo = sqlBean.getTableInfo(tablename, conn);
						PreparedStatement prpe = null;

						prpe = conn.prepareStatement(vo.getUpdateSql());
						
						int i = 1;
						for (Iterator iterator = values.iterator(); iterator
								.hasNext();) {
							i = 1;
							Map object = (Map) iterator.next();
							i = setPrepareStatement(object, i, prpe, vo
									.getCols());
							setPrepareStatement(object, i, prpe, vo.getKeys());
							prpe.addBatch();

						}
						prpe.executeBatch();
						prpe.close();

						return values;
					}
				});

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
	public List addBatch(final List values, final String tablename) {
		return (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
//						System.out.println(session);
						if (values == null || values.size() <= 0)
							return null;
						SqlVO vo = sqlBean.getTableInfo(tablename, conn);
						PreparedStatement prpe = null;
//						System.out.println(vo.getInsertSql());
						prpe = conn.prepareStatement(vo.getInsertSql());
						int i = 1;
						
						for (Iterator iterator = values.iterator(); iterator
								.hasNext();) {
							i = 1;
							Map object = (Map) iterator.next();

							if (vo.getKeys().size() == 1) { // 判断是否只有一个主键
								ColVO key = (ColVO) vo.getKeys().get(0);
								if (key.isIsnumber() && (object.get(key.getName()) == null
										||  Integer.parseInt(object.get(key.getName()).toString()) ==0)) { // 判读主键是否为空
									// 并且是数字型的如果是
									// 通过序列生成

									object
											.put(key.getName(),
													getSequenceNextVal(
															tablename, conn));
//									System.out.println(key.getName()+"===="+object.get(key.getName())+"===========kname");
								}

							}

							addSetPrepareStatement(object, i, prpe, vo.getCols()); // 将数据放入预存的游标中
							prpe.addBatch();

						}
						prpe.executeBatch();

						prpe.close();

						return values;
					}
				});

	}

	public Integer getSequenceNextVal(String tablename, Connection conn) {
		 @SuppressWarnings("unused")
		String sequenceName = "s_" + tablename;
		if (tablename.charAt(0) == 't') {
			tablename = tablename.replaceFirst("t", "s");
		} else {
			tablename = "s_" + tablename;
		}

		String sql = "select " + tablename + ".NEXTVAL from dual";
		// String sql = "select s_app_plan.NEXTVAL from dual";
//		System.out.println("sql:	" + sql);
		Object sequence = getSQLObject(conn, sql);

		return sequence == null ? null : new Integer(sequence.toString());

	}

	public Map add(final Map values, final String tablename,
			final SQLBean sqlBean) {
		return (Map) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();

						SqlVO vo = sqlBean.getTableInfo(tablename, conn);
						PreparedStatement prpe = null;
						prpe = conn.prepareStatement(vo.getInsertSql());
						int i = 1;
						if (vo.getKeys().size() == 1) { // 判断是否只有一个主键
							ColVO key = (ColVO) vo.getKeys().get(0);
							if ((values.get(key.getName()) == null ||  Integer.parseInt(values.get(key.getName()).toString()) ==0)
									&& key.isIsnumber()) { // 判读主键是否为空
								// 并且是数字型的如果是 通过序列生成
								values.put(key.getName(), getSequenceNextVal(
										tablename, conn));
							}

						}

						i = addSetPrepareStatement(values, i, prpe, vo.getCols()); // 将数据放入预存的游标中
						prpe.executeUpdate();
						prpe.close();
						
						return values;
					}
				});

	}

	public Map add(final Map values, final String tablename) {
		return add(values, tablename, sqlBean);
		
	}

	public List query(final String tablename, final String where) {
		return query(tablename, null, where);
	}

	public List query(final String tablename, final Collection columns,
			final String where) {

		return (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						SqlVO vo = sqlBean.getQuerySqlVo(columns, tablename,
								where, conn);

						Collection columns = vo.getCols();
						ResultSet rs = null;
						Statement statement = null;
						try {
							statement = conn.createStatement();
//							 System.out.println("-_--yjt-----"+vo.getSql());
							rs = statement.executeQuery(vo.getSql());
							List list = new ArrayList();
							Map map = null;
							ColVO column = null;
							int i = 1;
							Object anObject = null;
							while (rs.next()) {
								i = 1;
								map = new HashMap();
								for (Iterator iterator = columns.iterator(); iterator
										.hasNext();) {
									column = (ColVO) iterator.next();
									anObject = rs.getObject(i);

									map.put(column.getName(), anObject);

									i++;
								}
								list.add(map);
							}
							return list;
						} finally {
							if (rs != null)
								rs.close();
							if (statement != null)
								statement.close();

						}

					}
				});
	}

	public Object getSQLObject(Connection conn, String sql) {
		ResultSet rs = null;
		Statement statement = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			if (rs.next())
				return rs.getObject(1);
			else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	public int getCount(Connection conn, String tablename, String where) {

		String sql = "select count(*) from " + tablename
				+ (where == null || where.equals("") ? "" : " where " + where);
		Object count = getSQLObject(conn, sql);
		return count == null ? 0 : Integer.parseInt(count.toString());

	}
	
	//根据条件计算总数
	public int getCount(final String tablename, final String where) {
		return (Integer) super.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						
						Object count = getSQLObject(conn, "select count(*) from " + tablename
								+ (where == null || where.equals("") ? "" : " where " + where));
						return count == null ? 0 : Integer.parseInt(count.toString());
					}
				});
	}
	

	public TotalJson queryPage(final String tablename,
			final Collection columns, final String where, final int start,
			final int limit) {
//		final String newWhere = where != null && !where.equals("") ? "  rownum<="
//				+ (limit + start) + " and " + where
//				: " rownum<=" + (limit + start); // 生成分页sql
		return (TotalJson) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						SqlVO vo = sqlBean.getQuerySqlVo(columns, tablename,
								where, conn); // 获得数据库表的结构
						// System.out.println("============"+vo.getSql());
						Collection columns = vo.getCols();
						ResultSet rs = null;
						Statement statement = null;

						TotalJson total = new TotalJson();
						try {
							statement = conn.createStatement();
							//System.out.println("------------"+"select * from("+vo.getSql()+") where rownum<="+ (limit + start));

							rs = statement.executeQuery("select * from("+vo.getSql()+") where rownum<="+ (limit + start) ); // 执行sql
							List list = new JSONArray();
							Map map = null;
							ColVO column = null;
							int i = 1;
							int j = 0;
							Object anObject = null;

							while (rs.next()) {
								i = 1;
								if (j >= start) { // 判读从多少行开始接收数据
									map = new JSONObject();
									for (Iterator iterator = columns.iterator(); iterator
											.hasNext();) {
										column = (ColVO) iterator.next();
										anObject = rs.getObject(i);
										if (anObject instanceof java.sql.Date) {
											
//											JSONObject json = beanProcessor
//													.processBean(new java.util.Date().getTime()),config);

											map.put(column.getName(), Tool.stringOfDateTime(((java.sql.Date)anObject)));
										} else {

											if (!(anObject instanceof java.sql.Clob))
												map.put(column.getName(),anObject);
										}

										i++;
									}
									list.add(map);
									
								}

								j++;
							}
							total.setItems(list);
							total.setResults(getCount(conn, tablename, where));
							return total;
						} finally {
							if (rs != null)
								rs.close();
							if (statement != null)
								statement.close();

						}

					}
				});
	}

	public List query(final String sql, final Class VOClass) {
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
							Object vo = null;
							while (rs.next()) {
								vo = VOClass.newInstance();
								for (int i = 1; i <= columnCount; i++) {

									try {
										BeanUtils
												.setProperty(vo, rsmd
														.getColumnName(i) // 获得结果集列名
														.toLowerCase(), rs
														.getObject(i));
									} catch (IllegalAccessException e) {

										e.printStackTrace();
									} catch (InvocationTargetException e) {

										e.printStackTrace();
									}

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

						}
//						System.out.println("list:          "+list.size());
						
						return list;

					}
				});

	}

	public TotalJson queryPage(final String sql, final int start,
			final int limit) {
		return (TotalJson) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();

						ResultSet rs = null;
						Statement statement = null;
						List list = new ArrayList();
						TotalJson total = new TotalJson();
						try {
							statement = conn.createStatement();
							rs = statement.executeQuery("select * from("+sql+") where rownum<="+ (limit + start));
							ResultSetMetaData rsmd = rs.getMetaData(); // 获得结果集的模型（列的相关信息）

							int columnCount = rsmd.getColumnCount(); // 获得一共有多少类
							Map vo = null;
							int j=0;
							while (rs.next()) {
								if (j >= start) { // 判读从多少行开始接收数据
								vo = new HashMap();
								for (int i = 1; i <= columnCount; i++) {
									vo.put(rsmd.getColumnName(i).toLowerCase(),rs.getObject(i));

								}
								list.add(vo);
								}
								j++;
								
							}

						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if (rs != null)
								rs.close();
							if (statement != null)
								statement.close();

						}
						total.setItems(list);
						total.setResults(((BigDecimal) getSQLObject(conn, "select count(*) from("+sql+")")).intValue());
						return total;

					}
				});

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

						}
						return list;

					}
				});

	}
	/**
	 * 得到关键字对应记录的属性(如根据代码得到对应的名称)
	 * 
	 * @param Tablename
	 *            表名
	 * @param code
	 *            代码
	 * @param codevalue
	 *            代码值
	 * @param name
	 *            属性字段
	 * @return
	 */
	public String query(String Tablename, String code, final Object codevalue,
			String name) {
		final StringBuffer sql = new StringBuffer("select ");
		sql.append(name).append("  from ").append(Tablename).append(" where ")
				.append(code).append("=?");
//		System.out.println("=======+++++++++++++++=======querysql==="+sql.toString());
		return (String) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();

						PreparedStatement prpe = null;

						prpe = conn.prepareStatement(sql.toString());
						prpe.setObject(1, codevalue);
						ResultSet rs = prpe.executeQuery();
						String value = null;
						if (rs.next())
							value = rs.getString(1);
						rs.close();
						prpe.close();

						return value;
					}
				});
	}

	public Map queryDic(String Tablename, String code, String name, String where) {
		final StringBuffer sql = new StringBuffer("select ").append(code)
				.append(",").append(name).append("  from ").append(Tablename);
		if (where != null && !where.equals(""))
			sql.append(" where ").append(where);
		return (Map) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();

						Statement prpe = conn.createStatement();

						ResultSet rs = prpe.executeQuery(sql.toString());
						Map value = null;
						while (rs.next()) {
							value = new HashMap();
							value.put(rs.getString(1), rs.getString(2));
						}
						rs.close();
						prpe.close();
						return value;
					}
				});
	}

	public String querySingle(String Tablename, String code, String where) {
		final StringBuffer sql = new StringBuffer("select ");
		sql.append(code).append("  from ").append(Tablename).append(" where ")
				.append(where);
		return (String) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();

						Statement prpe = conn.createStatement();
						//System.out.println("sql::::"+sql);
						ResultSet rs = prpe.executeQuery(sql.toString());
						String value = null;
						if (rs.next())
							value = rs.getString(1);
						rs.close();
						prpe.close();

						return value;
					}
				});
	}

	public Boolean delete(String tablename, String where) {
		final StringBuffer sql = new StringBuffer("delete ").append("  from ")
				.append(tablename).append(" where ").append(where);
		 System.out.println(sql);
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

	/**
	 * 本方法抛出异常，在使用事务时使用。
	 * @param sql
	 * @return
	 */
	public int updateTX(final String sql) {
		return (Integer) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();

						Statement statement = conn.createStatement();

						int n = statement.executeUpdate(sql);

						if (statement != null)
							statement.close();

						return n;
					}
				});
	}
	
	/**
	 * 本方法抛出异常，查询分页配置。
	 * @author syl
	 * @param sql
	 * @return
	 */   
    public PageModel findAllList(String tableName,String where,int offset, int pagesize) {    
            
        //得到总记录数    
        String queryCountHql = "select count(*) from "+tableName+" "+where;    
        Query query = getSession().createQuery(queryCountHql);    
        int total = ((Long)query.uniqueResult()).intValue();    
        String queryList = " from "+tableName+" "+where;
        List datas = getSession().createQuery(queryList)    
                    .setFirstResult(offset)    
                    .setMaxResults(pagesize)    
                    .list();    
        
        //得到结果集    
        PageModel pm = new PageModel(); 
        pm.setTotal(total);    
        pm.setDatas(datas);    
        return pm;    
    
    }
	/**
	 * 本方法抛出异常，查询分页配置。
	 * @author syl
	 * @param sql
	 * @return
	 */   
    
	public PaginationSupport findPageByQuery(String tableName, String where,
			int pageSize, int startIndex) {

		final int pageSize1 = pageSize;
		final int startIndex1 = startIndex;
		if (where != null && !where.equals("") && where.indexOf("where") < 0)
			where = "where " + where;

		final String hql1 = "from " + tableName + where + " order by id desc";
		final String countHql1 = "select count(*) from  " + tableName + where;
		
		
		return (PaginationSupport) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
 				    	int totalCount = Integer.parseInt((session.createQuery(countHql1)).list().get(0).toString());
						Query query = session.createQuery(hql1);
                      if(totalCount<=startIndex1){							
							query.setFirstResult(startIndex1-pageSize1);
						}else{
							query.setFirstResult(startIndex1);
						}
						
						query.setMaxResults(pageSize1);
						List items = query.list();
						PaginationSupport ps;
						if(totalCount<=startIndex1){
						ps = new PaginationSupport(items,
								totalCount, pageSize1, startIndex1-pageSize1);
						}else{
							ps = new PaginationSupport(items,
									totalCount, pageSize1, startIndex1);
						}
						return ps;
					}
				});
		
			
		
		
		
		
		
	}
	
	
	
	/**
	 * 
	* Title: queryPageNojson
	* Description: 翻页查询方法，不依赖hbm　xml 文件   
	* @param tablename
	* @param columns
	* @param where
	* @param start
	* @param limit
	* @return 返回PaginationSupport对象
	 */
	public PaginationSupport queryPageNojson(final String tablename,
			final Collection columns, final String where, final int start,
			final int limit) {
		return (PaginationSupport) super.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						SqlVO vo = sqlBean.getQuerySqlVo(columns, tablename,where, conn); // 获得数据库表的结构
						Collection columns = vo.getCols();
						ResultSet rs = null;
						Statement statement = null;
						try {
							statement = conn.createStatement();
							//System.out.println("XXXXXXXx===XXXXX==="+"select * from("+vo.getSql()+") where rownum<="+ (limit + start));
							rs = statement.executeQuery("select * from("+vo.getSql()+") where rownum<="+ (limit + start) ); // 执行sql
							List list = new JSONArray();
							Map map = null;
							ColVO column = null;
							int i = 1;
							int j = 0;
							Object anObject = null;

							while (rs.next()) {
								i = 1;
								if (j >= start) { // 判读从多少行开始接收数据
									map = new HashMap();
									for (Iterator iterator = columns.iterator(); iterator
											.hasNext();) {
										column = (ColVO) iterator.next();
										anObject = rs.getObject(i);
										if (anObject instanceof java.sql.Date) {
											map.put(column.getName(), Tool.stringOfDateTime(((java.sql.Date)anObject)));
										} else {

											if (!(anObject instanceof java.sql.Clob))
												map.put(column.getName(),anObject);
										}

										i++;
									}
									list.add(map);
									
								}

								j++;
							}
							PaginationSupport ps=new PaginationSupport(list,getCount(conn, tablename, where),limit,start);
							return ps;
						} finally {
							if (rs != null)
								rs.close();
							if (statement != null)
								statement.close();
						}
					}
				});
	}
	


}
