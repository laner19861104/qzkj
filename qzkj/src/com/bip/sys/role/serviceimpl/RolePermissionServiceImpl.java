/**
 * 类名：RolePermissionServiceImpl.java
 *
 * 类别：Spring Service
 * 功能：角色权限管理逻辑实现。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.role.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.util.*;
import com.bip.sys.role.po.*;
import com.bip.sys.role.dao.*;
import com.bip.sys.role.service.*;
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	@Resource
	private RolePermissionDao rolepermissionDao;

	public void setRolepermissionDao(RolePermissionDao rolepermissionDao) {
		this.rolepermissionDao = rolepermissionDao;
	}

	public RolePermissionDao getRolepermissionDao() {
		return rolepermissionDao;
	}

	public RolePermissionServiceImpl() {
	}

	/**
	 * 添加角色权限
	 * 
	 * @param role
	 * @return
	 */
	public Serializable save(SysRolepermission t) throws DataAccessException {
		return rolepermissionDao.save(t);
	}

	/**
	 * 按条件查找角色权限
	 * 
	 * @return
	 */
	public SysRolepermission get(SysRolepermissionId id) {
		SysRolepermission sr = new SysRolepermission();
		sr = rolepermissionDao.get(id);
		return sr;
	}

	public List find(String queryString) {
		List rlist = new ArrayList();
		rlist = rolepermissionDao.find("FROM SysRolepermission " + queryString);
		return rlist;
	}

	/**
	 * 分页查找
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	public PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex) {
		PaginationSupport ps = new PaginationSupport(null, 0, 0, 0);
		ps = rolepermissionDao.findPageByQuery("FROM SysRolepermission " + hql,
				"FROM SysRolepermission " + countHql, pageSize, startIndex);
		return ps;
	}

	/**
	 * 修改角色权限权限信息
	 * 
	 * @param SysRolepermission
	 * @return
	 * @throws Exception
	 */
	public void update(SysRolepermission t) throws Exception {
		rolepermissionDao.update(t);
	}
	public int update(final String sql) throws Exception {
		return rolepermissionDao.update(sql);
	}
	/**
	 * 删除角色权限
	 * 
	 * @param id
	 * @return
	 */
	public void delete(SysRolepermission t) {
		rolepermissionDao.delete(t);
	}
	public Boolean delete(String table, String where) {
		return rolepermissionDao.delete("sys_rolepermission", where);

	}
}
