/************************************************************
 * 类名：DeptService.java
 *
 * 类别：Spring Service
 * 功能：部门管理逻辑接口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.dept.service;

import java.io.Serializable;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.*;
import com.bip.sys.dept.po.*;

public interface DeptService {
	/**
	 * 添加部门
	 * 
	 * @param dept
	 * @return
	 */
	Serializable save(SysDepartment dept) throws DataAccessException;

	/**
	 * 按条件查找部门
	 * 
	 * @return
	 */
	SysDepartment get(Integer id);

	SysDepartment getByNo(String deptno);

	List find(String queryString);

	List findBySql(String queryString);

	/**
	 * 分页查找
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex);

	/**
	 * 修改部门信息
	 * 
	 * @param SysDepartment
	 * @return
	 * @throws Exception
	 */
	void update(SysDepartment dept) throws Exception;

	int update(String sql) throws Exception;

	/**
	 * 删除部门
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysDepartment dept);

	Boolean delete(String table, String where);
}
