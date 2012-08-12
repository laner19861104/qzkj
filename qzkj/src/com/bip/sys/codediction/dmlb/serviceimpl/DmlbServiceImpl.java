/**
 * 类名：DmlbService.java
 *
 * 类别：Spring Service
 * 功能：代码类别管理逻辑接口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
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
	 * 添加代码类别
	 * 
	 * @param energyindex
	 * @return
	 */
	public Serializable save(SysDmlb t) throws DataAccessException {
		return dmlbDao.save(t);
	}

	/**
	 * 按条件查找代码类别
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
	 * 分页查找
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
	 * 修改代码类别信息
	 * 
	 * @param SysDmlb
	 * @return
	 * @throws Exception
	 */
	public void update(SysDmlb t) throws Exception {
		dmlbDao.update(t);
	}

	/**
	 * 删除代码类别
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
