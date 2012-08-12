/************************************************************
 * 类名：DeptServiceImpl.java
 *
 * 类别：Spring Service
 * 功能：部门管理逻辑实现。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.dept.serviceimpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.util.*;
import com.bip.sys.dept.po.*;
import com.bip.sys.dept.dao.*;
import com.bip.sys.dept.service.*;
@Service
public class DeptServiceImpl implements DeptService {
	@Resource
	private DeptDao deptDao;

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public DeptDao getDeptDao() {
		return deptDao;
	}

	public DeptServiceImpl() {
	}

	/**
	 * 添加部门
	 * 
	 * @param dept
	 * @return
	 */
	public Serializable save(SysDepartment t) throws DataAccessException {
		try {

			return deptDao.save(t);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 按条件查找部门
	 * 
	 * @return
	 */
	public SysDepartment get(Integer id) {
		SysDepartment sr = new SysDepartment();
		sr = deptDao.get(id);
		return sr;
	}

	public SysDepartment getByNo(String deptno) {
		SysDepartment sr = new SysDepartment();

		List srlist = deptDao.find("FROM SysDepartment  where deptno like '"
				+ deptno + "'");

		if (srlist == null || srlist.size() == 0) {
			return null;
		} else
			sr = (SysDepartment) srlist.get(0);
		return sr;
	}

	public List find(String queryString) {
		List rlist = new ArrayList();
		rlist = deptDao.find("FROM SysDepartment " + queryString);
		return rlist;
	}

	public List findBySql(String queryString) {
		List rlist = new ArrayList();
		rlist = deptDao.find("" + queryString);
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
		ps = deptDao.findPageByQuery("FROM SysDepartment " + hql,
				"FROM SysDepartment " + countHql, pageSize, startIndex);
		return ps;
	}

	/**
	 * 修改部门信息
	 * 
	 * @param SysDepartment
	 * @return
	 * @throws Exception
	 */
	public void update(SysDepartment t) throws Exception {
		deptDao.update(t);
	}

	public int update(final String sql) throws Exception {
		return deptDao.update(sql);
	}

	/**
	 * 删除部门
	 * 
	 * @param id
	 * @return
	 */
	public void delete(SysDepartment t) {
		deptDao.delete(t);
	}

	public Boolean delete(String table, String where) {
		return deptDao.delete("sys_department", where);

	}

}
