/**
 * ������PermissionService.java
 *
 * ���Spring Service
 * ���ܣ�Ȩ�޹����߼��ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.permission.serviceimpl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.util.*;
import com.bip.sys.permission.po.*;
import com.bip.sys.permission.dao.*;
import com.bip.sys.permission.service.*;
import com.bip.sys.resource.po.SysResource;
@Service
public class PermissionServiceImpl implements PermissionService {
	@Resource
	private PermissionDao permissionDao;

	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

	public PermissionDao getPermissionDao() {
		return permissionDao;
	}

	public PermissionServiceImpl() {
	}

	/**
	 * ���Ȩ��
	 * 
	 * @param permission
	 * @return
	 */
	public Serializable save(SysPermission t) throws DataAccessException {
		return permissionDao.save(t);
	}

	/**
	 * ����������Ȩ��
	 * 
	 * @return
	 */
	public SysPermission get(Integer id) {
		SysPermission sr = new SysPermission();
		sr = permissionDao.get(id);
		return sr;
	}

	public List find(String queryString) {
		List rlist = new ArrayList();
		rlist = permissionDao.find("FROM SysPermission " + queryString);
		return rlist;
	}
	public SysPermission findBySql(String queryString){
		List rlist = new ArrayList();
		rlist = permissionDao.find("FROM SysPermission " + queryString);
		return rlist==null?null:(SysPermission)rlist.get(0);

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
		ps = permissionDao.findPageByQuery("FROM SysPermission " + hql,
				"FROM SysPermission " + countHql, pageSize, startIndex);
		return ps;
	}
	
	/**
	 * �޸�Ȩ����Ϣ
	 * 
	 * @param SysPermission
	 * @return
	 * @throws Exception
	 */
	public void update(SysPermission t) throws Exception {
		permissionDao.update(t);
	}

	
	public int update(final String sql) throws Exception {
		return permissionDao.update(sql);
	}
	/**
	 * ɾ��Ȩ��
	 * 
	 * @param id
	 * @return
	 */
	public void delete(SysPermission t) {
		permissionDao.delete(t);
	}
	public Boolean delete(String table, String where) {
		return permissionDao.delete("sys_permission", where);

	}
	/**
	 * 
	 */
	public List findPermission(Integer userid)
	{
		return permissionDao.findPermission(userid);
	}
	/**
	 * 
	 */
	public List findPermissionByRoleid(Integer roleid)
	{
		return permissionDao.findPermissionByRoleid(roleid);
	}
}
