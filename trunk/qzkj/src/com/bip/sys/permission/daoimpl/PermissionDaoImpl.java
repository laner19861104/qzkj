/**
 * 类名：PermissionDaoImpl.java
 *
 * 类别：Hibernate DaoImpl
 * 功能：权限管理Hibernate实现。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.permission.daoimpl;


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
import com.bip.sys.permission.dao.*;
import com.bip.sys.permission.po.*;
@Repository
public class PermissionDaoImpl extends GenericDao<SysPermission, Integer> implements
		PermissionDao {
	/**
	 * 函数说明：查询用户资源－设置菜单：
	 */
	public List findPermission(final Integer userid) {
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
							String sql = "select * from  sys_permission where permissionid in (select permissionid from sys_rolepermission where roleid in (select roleid from sys_userroles where userid="
									+ userid.toString()
									+ "))  order by permissionno";
							 System.out.println("Sql is "+sql);
							rs = statement.executeQuery(sql);
							int i = 0;
							while (rs.next()) {
								SysPermission srpo = new SysPermission();
								srpo.setPermissionid(rs
										.getInt("permissionid"));
								srpo.setPermissionname(rs
										.getString("permissionname"));
								srpo.setPermissionno(rs.getString("permissionno"));
								srpo.setPpermissionno(rs.getString("ppermissionno"));
								
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
	/**
	 * 函数说明：查询用户资源－设置菜单：
	 */
	public List findPermissionByRoleid(final Integer roleid) {
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
							String sql = "select * from  sys_permission where permissionid in (select permissionid from sys_rolepermission where roleid ="
									+ roleid.toString()
									+ ")  order by permissionno";
							 System.out.println("Sql is "+sql);
							rs = statement.executeQuery(sql);
							int i = 0;
							while (rs.next()) {
								SysPermission srpo = new SysPermission();
								srpo.setPermissionid(rs
										.getInt("permissionid"));
								srpo.setPermissionname(rs
										.getString("permissionname"));
								srpo.setPermissionno(rs.getString("permissionno"));
								srpo.setPpermissionno(rs.getString("ppermissionno"));
								
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
