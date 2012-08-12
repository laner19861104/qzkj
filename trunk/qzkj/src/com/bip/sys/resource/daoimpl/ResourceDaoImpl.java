/**
 * 类名：ResourceDaoImpl.java
 *
 * 类别：Hibernate DaoImpl
 * 功能：资源管理Hibernate实现。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.resource.daoimpl;

import java.math.BigDecimal;
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
import com.bip.sys.resource.dao.*;
import com.bip.sys.resource.po.*;
@Repository
public class ResourceDaoImpl extends GenericDao<SysResource, Integer>
		implements ResourceDao {
	/**
	 * 函数说明：查询用户资源－设置菜单：
	 */
	public List findResource(final Integer userid) {
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
							String sql = "select * from sys_resource where (resourceno in (select resourceid from sys_permission where permissionid in (select permissionid from sys_rolepermission where roleid in (select roleid from sys_userroles where userid="
									+ userid.toString()
									+ ")))) and type='01' order by resourceno";
							// System.out.println("Sql is "+sql);
							rs = statement.executeQuery(sql);
							int i = 0;
							while (rs.next()) {
								SysResource srpo = new SysResource();
								srpo.setResourceid(rs
										.getInt("resourceid"));
								srpo.setResourcename(rs
										.getString("resourcename"));
								srpo.setResourceno(rs.getString("resourceno"));
								srpo.setRemark(rs.getString("remark"));
								srpo.setIsdelete(rs.getString("isdelete"));
								srpo
										.setPresourceno(rs
												.getString("presourceno"));
								srpo.setLink(rs.getString("link"));
								srpo.setImageurl(rs.getString("imageurl"));
								srpo.setType(rs.getString("type"));
								srpo.setWinsize(rs.getString("winsize"));
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
