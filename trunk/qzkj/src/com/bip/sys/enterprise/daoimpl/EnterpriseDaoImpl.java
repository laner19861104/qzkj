/************************************************************
 * ������EnterpriseDaoImpl.java
 *
 * ���Hibernate DaoImpl
 * ���ܣ���ҵ��λ����Hibernateʵ�֡�
 * 
 *   Ver     �����               ��ҵ��λ            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.enterprise.daoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.sys.enterprise.dao.*;
import com.bip.sys.enterprise.po.*;
@Repository
public class EnterpriseDaoImpl extends GenericDao<SysEnterprise, Integer>
		implements EnterpriseDao {
	public List find(final String table, final String where) {
		return (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						Statement statement = null;
						try {
							String sql = "select id,dwb h,dwmc,hyfl,ssqy from "
									+ table +" "+ where;
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
}
