/**
 * 类名：RoleService.java
 *
 * 类别：Spring Service
 * 功能：角色管理逻辑接口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.role.serviceimpl;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public RoleServiceImpl() {
	}

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return
	 */
	public Serializable save(SysRole t) throws DataAccessException {
		return roleDao.save(t);
	}

	/**
	 * 按条件查找角色
	 * 
	 * @return
	 */
	public SysRole get(Integer id) {
		SysRole sr = new SysRole();
		sr = roleDao.get(id);
		return sr;
	}

	public List find(String queryString) {
		List rlist = new ArrayList();
		rlist = roleDao.find("FROM SysRole " + queryString);
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
		ps = roleDao.findPageByQuery("FROM SysRole " + hql,
				"FROM SysRole " + countHql, pageSize, startIndex);
		return ps;
	}

	/**
	 * 修改角色信息
	 * 
	 * @param SysRole
	 * @return
	 * @throws Exception
	 */
	public void update(SysRole t) throws Exception {
		roleDao.update(t);
	}
	public int update(final String sql) throws Exception {
		return roleDao.update(sql);
	}
	/**
	 * 删除角色
	 * 
	 * @param id
	 * @return
	 */
	public void delete(SysRole t) {
		roleDao.delete(t);
	}
	public Boolean delete(String table, String where) {
		return roleDao.delete("sys_role", where);

	}
}
