/**
 * ������RoleService.java
 *
 * ���Spring Service
 * ���ܣ���ɫ�����߼��ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
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
	 * ��ӽ�ɫ
	 * 
	 * @param role
	 * @return
	 */
	public Serializable save(SysRole t) throws DataAccessException {
		return roleDao.save(t);
	}

	/**
	 * ���������ҽ�ɫ
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
	 * ��ҳ����
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
	 * �޸Ľ�ɫ��Ϣ
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
	 * ɾ����ɫ
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
