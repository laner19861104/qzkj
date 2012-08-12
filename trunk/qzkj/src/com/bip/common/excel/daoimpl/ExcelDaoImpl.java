package com.bip.common.excel.daoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bip.common.dao.ColVO;
import com.bip.common.dao.SQLBean;
import com.bip.common.dao.SQLBean.SqlVO;
import com.bip.common.excel.dao.ExcelDao;
import com.bip.common.util.Tool;

public class ExcelDaoImpl extends HibernateDaoSupport implements ExcelDao {
	public SQLBean sqlBean = new SQLBean();

	public void setSqlBean(SQLBean sqlBean) {
		this.sqlBean = sqlBean;
	}

	public SQLBean getSqlBean() {
		return sqlBean;
	}

	/**
	 * ��ֵ����PreparedStatement
	 * 
	 * @param values
	 *            ֵ
	 * @param i
	 *            ������
	 * @param prpe
	 *            PreparedStatement����
	 * @param columns
	 *            ��������
	 * @return i ������
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
	 * ��ֵ����PreparedStatement
	 * 
	 * @param values
	 *            ֵ
	 * @param i
	 *            ������
	 * @param prpe
	 *            PreparedStatement����
	 * @param columns
	 *            ��������
	 * @return i ������
	 * @throws SQLException
	 * 
	 */

	public int addSetPrepareStatement(Map values, int i,
			PreparedStatement prpe, List columns) throws SQLException {
		ColVO col = null;
		Object value = null;
		try {

			for (int j = 0; j < columns.size(); j++) {
				col = (ColVO) columns.get(j);

				value = values.get(col.getName());

				if (value != null
						&& (!col.isIsnumber() || !value.toString().equals(""))) {

					if (col.isIsnumber()) {

						if (value instanceof java.util.Date)
							prpe.setDate(i, new java.sql.Date(
									((java.util.Date) value).getTime()));
						else if ((value instanceof String)
								&& Tool.isDate(value.toString())) {
							prpe.setDate(i, new java.sql.Date(
									new java.util.Date(value.toString())
											.getTime()));
						} else {
							prpe.setBigDecimal(i, new BigDecimal(value
									.toString()).setScale(5,
									BigDecimal.ROUND_HALF_UP));
						}
					} else {

						prpe.setString(i, value.toString());

					}
				} else {

					if (col.getDefVal() == null)
						prpe.setObject(i, null);
					else {
						if (col.isIsnumber())
							prpe.setBigDecimal(i, new BigDecimal(col
									.getDefVal()).setScale(5,
									BigDecimal.ROUND_HALF_UP));
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
	 * �����޸����ݿ�ֵ
	 * 
	 * @param values
	 *            ��Ҫ��ӵ�ֵ��List����List��ÿ������ΪMap����, map��keyΪ���� ע:��������Сд
	 * @param tablename
	 *            ��Ҫ�޸ĵı���
	 * @return �Ƿ�ɹ��޸�
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
						// System.out.println(session);

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
	 * ����������ݿ�ֵ:pkΪ���ֲ�ͨ��sys_idinfo������
	 * 
	 * @param values
	 *            ��Ҫ��ӵ�ֵ��List����List��ÿ������ΪMap����, map��keyΪ���� ע:��������Сд
	 * @param tablename
	 *            ��Ҫ�޸ĵı���
	 * @return �Ƿ�ɹ����
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
						if (values == null || values.size() <= 0)
							return null;
						SqlVO vo = sqlBean.getTableInfo(tablename, conn);
						PreparedStatement prpe = null;
						prpe = conn.prepareStatement(vo.getInsertSql());
						int i = 1;
						int count = 0;
						for (Iterator iterator = values.iterator(); iterator
								.hasNext();) {
							i = 1;
							Map object = (Map) iterator.next();

							if (vo.getKeys().size() == 1) { // �ж��Ƿ�ֻ��һ������
								ColVO key = (ColVO) vo.getKeys().get(0);
								if (key.isIsnumber()
										&& (object.get(key.getName()) == null || Integer
												.parseInt(object.get(
														key.getName())
														.toString()) == 0)) {
									// �ж������Ƿ�Ϊ��
									// ����ǲ����������͵�
									// ͨ��sys_idinfo����

									// object
									// .put(key.getName(),
									// getSequenceNextVal(
									// tablename, conn));
									// System.out.println("Begin Inputexcel of ExcelDaoImpl-addBatch......");
									object.put(key.getName(),
											getNextPkByIdInfo(tablename, conn,
													key.getName()));
									// System.out.println(key.getName()+"===="+object.get(key.getName()));
								}

							}

							addSetPrepareStatement(object, i, prpe, vo
									.getCols()); // �����ݷ���Ԥ����α���
							prpe.addBatch();
							count++;

							if (count >= 5000) {
								count = 0;
								prpe.executeBatch();
							}
						}
						prpe.executeBatch();

						prpe.close();

						return values;
					}
				});

	}

	/**
	 * ����������ݿ�ֵ:pkΪ���ֲ�ͨ������sequence����
	 * 
	 * @param values
	 *            ��Ҫ��ӵ�ֵ��List����List��ÿ������ΪMap����, map��keyΪ���� ע:��������Сд
	 * @param tablename
	 *            ��Ҫ�޸ĵı���
	 * @return �Ƿ�ɹ����
	 * @throws IllegalStateException
	 * @throws HibernateException
	 * @throws DataAccessResourceFailureException
	 * @throws Exception
	 */
	public List addBatchBySeq(final List values, final String tablename) {
		return (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						if (values == null || values.size() <= 0)
							return null;
						SqlVO vo = sqlBean.getTableInfo(tablename, conn);
						PreparedStatement prpe = null;
						prpe = conn.prepareStatement(vo.getInsertSql());
						int i = 1;
						int count = 0;
						for (Iterator iterator = values.iterator(); iterator
								.hasNext();) {
							i = 1;
							Map object = (Map) iterator.next();

							if (vo.getKeys().size() == 1) { // �ж��Ƿ�ֻ��һ������
								ColVO key = (ColVO) vo.getKeys().get(0);
								if (key.isIsnumber()
										&& (object.get(key.getName()) == null || Integer
												.parseInt(object.get(
														key.getName())
														.toString()) == 0)) {
									// �ж������Ƿ�Ϊ��
									// ����ǲ����������͵�
									// ͨ����������
									object
											.put(key.getName(),
													getSequenceNextVal(
															tablename, conn));
								}
							}
							addSetPrepareStatement(object, i, prpe, vo
									.getCols()); // �����ݷ���Ԥ����α���
							prpe.addBatch();
							count++;

							if (count >= 5000) {
								count = 0;
								prpe.executeBatch();
							}
						}
						prpe.executeBatch();

						prpe.close();

						return values;
					}
				});

	}

	/**
	 * ����������ݿ�ֵ:pkΪ�ַ���ͨ��UUID�Զ�����uuid
	 * 
	 * @param values
	 *            ��Ҫ��ӵ�ֵ��List����List��ÿ������ΪMap����, map��keyΪ���� ע:��������Сд
	 * @param tablename
	 *            ��Ҫ�޸ĵı���
	 * @return �Ƿ�ɹ����
	 * @throws IllegalStateException
	 * @throws HibernateException
	 * @throws DataAccessResourceFailureException
	 * @throws Exception
	 */
	public List addBatchByUuid(final List values, final String tablename) {
		return (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						if (values == null || values.size() <= 0)
							return null;
						System.out.println("tablename is =="+tablename);
						SqlVO vo = sqlBean.getTableInfo(tablename, conn);
						
						PreparedStatement prpe = null;
						System.out.println(vo.getInsertSql());
						prpe = conn.prepareStatement(vo.getInsertSql());
						int i = 1;
						int count = 0;
						for (Iterator iterator = values.iterator(); iterator
								.hasNext();) {
							i = 1;
							Map object = (Map) iterator.next();

							if (vo.getKeys().size() == 1) { // �ж��Ƿ�ֻ��һ������
								ColVO key = (ColVO) vo.getKeys().get(0);
								object.put(key.getName(), getStringUUid());
							}
							addSetPrepareStatement(object, i, prpe, vo
									.getCols()); // �����ݷ���Ԥ����α���
							prpe.addBatch();

							count++;

							if (count >= 5000) {
								count = 0;
								prpe.executeBatch();
							}
						}
						prpe.executeBatch();

						prpe.close();

						return values;
					}
				});

	}

	/**
	 * ��ȡ���ݱ��Ӧ�����е���һ��ֵ(���ݱ��pk�ֶ�Ϊint��bigdecimal)
	 * 
	 * @param tablename
	 *            ��ת���ɶ�Ӧ����"s_"+tablename
	 * @param conn
	 *            : ���ݿ������
	 * @return �� ���е���һ��ֵ
	 */
	public Integer getSequenceNextVal(String tablename, Connection conn) {
		String sequenceName = "s_" + tablename;
		if (tablename.charAt(0) == 't') {
			tablename = tablename.replaceFirst("t", "s");
		} else {
			tablename = "s_" + tablename;
		}
		String sql = "select " + tablename + ".NEXTVAL from dual";
		Object sequence = getSQLObject(conn, sql);
		return sequence == null ? null : new Integer(sequence.toString());
	}

	/**
	 * ��ȡ���ݱ�pk�ֶε����ֵ
	 * 
	 * @param tablename
	 *            �����ݱ�
	 * @param conn
	 *            �����ݿ������
	 * @param keyName
	 *            �����ݱ��pk�ֶ�
	 * @return �����ݱ�pk�ֶε����ֵ
	 */
	public Integer getNextPk(String tablename, Connection conn, String keyName) {
		String sql = "select max(" + keyName + ") " + " from " + tablename;
		Object sequence = getSQLObject(conn, sql);
		return sequence == null ? 1 : new Integer(sequence.toString()) + 1;
	}

	/**
	 * ��ȡ���ݱ�pk�ֶ���sys_idinfo���е���һ��ֵ
	 * 
	 * @param tablename
	 *            �����ݱ�
	 * @param conn
	 *            �����ݿ������
	 * @param keyName
	 *            �����ݱ��pk�ֶ�
	 * @return �����ݱ�pk�ֶ���sys_idinfo���е���һ��ֵ
	 */
	public Integer getNextPkByIdInfo(String tablename, Connection conn,
			String keyName) {
		String sql = "select currentvalue "
				+ " from  sys_idinfo where tablename='" + tablename + "'"
				+ " and fieldname='" + keyName + "'";
		Object sequence = getSQLObject(conn, sql);
		String stepSql = "select laststep "
				+ " from  sys_idinfo where tablename='" + tablename + "'"
				+ " and fieldname='" + keyName + "'";
		Object step = getSQLObject(conn, stepSql);
		String updateSql = "update sys_idinfo set currentvalue="
				+ (new Integer(sequence.toString()) + new Integer(step
						.toString())) + " where tablename='" + tablename + "'"
				+ " and fieldname='" + keyName + "'";
		this.exeSQL(conn, updateSql);
		return sequence == null ? 1 : new Integer(sequence.toString());// + 1;
	}

	/**
	 * ִ��sql���
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 */
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

	/**
	 * ִ��sql���
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 */
	public Object exeSQL(Connection conn, String sql) {
		Statement statement = null;
		try {
			statement = conn.createStatement();
			statement.execute(sql);
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	/**
	 *���ݿ�ͨ��uuid
	 */
	public static String getStringUUid() {
		return UUID.randomUUID().toString();

	}
	// /**
	// * ��ȡ���ݱ�ı�ṹ�����list(column_name,data_type,character_maximum_length)
	// *
	// * @param tableName
	// * @return
	// */
	// public List getTableStru(String tableName) {
	// final String sql =
	// "select column_name,data_type,character_maximum_length "
	// + "from information_schema.columns where table_name='"
	// + tableName + "'";
	// List list = this.getHibernateTemplate().executeFind(
	// new HibernateCallback() {
	// public Object doInHibernate(Session s)
	// throws HibernateException, SQLException {
	// return s.createSQLQuery(sql).list();
	// }
	//
	// });
	// return list;
	// }

}
