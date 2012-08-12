/**
 * ������RolePermissionServiceImpl.java
 *
 * ���Spring Service
 * ���ܣ���ɫȨ�޹����߼�ʵ�֡�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
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
	 * ��ӽ�ɫȨ��
	 * 
	 * @param role
	 * @return
	 */
	public Serializable save(SysRolepermission t) throws DataAccessException {
		return rolepermissionDao.save(t);
	}

	/**
	 * ���������ҽ�ɫȨ��
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
	 * ��ҳ����
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
	 * �޸Ľ�ɫȨ��Ȩ����Ϣ
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
	 * ɾ����ɫȨ��
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
