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
package com.bip.sys.login.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.util.*;
import com.bip.sys.login.po.*;
import com.bip.sys.login.dao.*;
import com.bip.sys.login.service.*;
@Service
public class ViewLoginServiceImpl implements ViewLoginService {
	@Resource
	private ViewLoginDao viewloginDao;

	
	public ViewLoginDao getViewloginDao() {
		return viewloginDao;
	}

	public void setViewloginDao(ViewLoginDao viewloginDao) {
		this.viewloginDao = viewloginDao;
	}

	public ViewLoginServiceImpl() {
	}

	/**
	 * ��ӽ�ɫȨ��
	 * 
	 * @param role
	 * @return
	 */
	public Serializable save(ViewLogin t) throws DataAccessException {
		return viewloginDao.save(t);
	}

	/**
	 * ���������ҽ�ɫȨ��
	 * 
	 * @return
	 */
	public ViewLogin get(ViewLoginId id) {
		ViewLogin sr = new ViewLogin();
		sr = viewloginDao.get(id);
		return sr;
	}

	public List find(String queryString) {
		List rlist = new ArrayList();
		rlist = viewloginDao.find("FROM ViewLogin " + queryString);
		return rlist;
	}

	public List findByUserid(int userid) {
		List rlist = new ArrayList();
		rlist = viewloginDao.findByUserid(userid);
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
		ps = viewloginDao.findPageByQuery("FROM ViewLogin " + hql,
				"FROM ViewLogin " + countHql, pageSize, startIndex);
		return ps;
	}

	/**
	 * �޸Ľ�ɫȨ��Ȩ����Ϣ
	 * 
	 * @param ViewLogin
	 * @return
	 * @throws Exception
	 */
	public void update(ViewLogin t) throws Exception {
		viewloginDao.update(t);
	}
	public int update(final String sql) throws Exception {
		return viewloginDao.update(sql);
	}
	/**
	 * ɾ����ɫȨ��
	 * 
	 * @param id
	 * @return
	 */
	public void delete(ViewLogin t) {
		viewloginDao.delete(t);
	}
	public Boolean delete(String table, String where) {
		return viewloginDao.delete("view_login", where);

	}
}
