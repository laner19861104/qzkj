/**
 * ������DmlbService.java
 *
 * ���Spring Service
 * ���ܣ������������߼��ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.codediction.dmlb.serviceimpl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.util.*;
import com.bip.sys.codediction.dmlb.dao.DmlbDao;
import com.bip.sys.codediction.dmlb.po.SysDmlb;
import com.bip.sys.codediction.dmlb.service.DmlbService;
@Service
public class DmlbServiceImpl implements DmlbService {
	@Resource
	private DmlbDao dmlbDao;

	public DmlbServiceImpl() {
	}

	/**
	 * ��Ӵ������
	 * 
	 * @param energyindex
	 * @return
	 */
	public Serializable save(SysDmlb t) throws DataAccessException {
		return dmlbDao.save(t);
	}

	/**
	 * ���������Ҵ������
	 * 
	 * @return
	 */
	public SysDmlb get(Integer id) {
		SysDmlb sr = new SysDmlb();
		sr = dmlbDao.get(id);
		return sr;
	}

	public List find(String queryString) {
		List rlist = new ArrayList();
		rlist = dmlbDao.find("FROM SysDmlb " + queryString);
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
		ps = dmlbDao.findPageByQuery("FROM SysDmlb " + hql, "FROM SysDmlb "
				+ countHql, pageSize, startIndex);
		return ps;
	}

	/**
	 * �޸Ĵ��������Ϣ
	 * 
	 * @param SysDmlb
	 * @return
	 * @throws Exception
	 */
	public void update(SysDmlb t) throws Exception {
		dmlbDao.update(t);
	}

	/**
	 * ɾ���������
	 * 
	 * @param id
	 * @return
	 */
	public void delete(SysDmlb t) {
		dmlbDao.delete(t);
	}

	public void setDmlbDao(DmlbDao dmlbDao) {
		this.dmlbDao = dmlbDao;
	}

	public DmlbDao getDmlbDao() {
		return dmlbDao;
	}

	public Boolean delete(String tablename, String where) {
		// TODO Auto-generated method stub
		return dmlbDao.delete("sys_dmlb", where);
	}

}
