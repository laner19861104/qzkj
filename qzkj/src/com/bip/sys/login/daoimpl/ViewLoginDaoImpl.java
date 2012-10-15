/**
 * ������RoleDaoImpl.java
 *
 * ���Hibernate DaoImpl
 * ���ܣ���ɫȨ�޹���Hibernateʵ�֡�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.login.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.sys.login.dao.*;
import com.bip.sys.login.po.*;
import com.bip.sys.resource.po.SysResource;
@Repository
public class ViewLoginDaoImpl extends GenericDao<ViewLogin, ViewLoginId> implements
		ViewLoginDao {
	
	/**
	 * ����˵������ѯ�û���Դ�����ò˵���
	 */
	public List findByUserid(final int userid) {
		return (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection conn = session.connection();
						Statement statement = null;
						ResultSet rs = null;
						List rlist = new ArrayList();
						try {
							statement = conn.createStatement();
							String sql = "select * from VIEW_LOGIN where userid="+userid+"";
						System.out.println("Sql is "+sql);
							rs = statement.executeQuery(sql);
							int i = 0;
							while (rs.next()) {
								SysResource srpo = new SysResource();
//								srpo.setResourceid(rs
//										.getInt("resourceid"));
								srpo.setResourcename(rs
										.getString("resourcename"));
								srpo.setResourceno(rs.getString("resourceno"));
//								srpo.setRemark(rs.getString("remark"));
//								srpo.setIsdelete(rs.getString("isdelete"));
								srpo
										.setPresourceno(rs
												.getString("presourceno"));
								srpo.setLink(rs.getString("link"));
//								srpo.setImageurl(rs.getString("imageurl"));
//								srpo.setType(rs.getString("type"));
//								srpo.setWinsize(rs.getString("winsize"));
								rlist.add(i, srpo);
								i++;
							}
							return rlist;
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
