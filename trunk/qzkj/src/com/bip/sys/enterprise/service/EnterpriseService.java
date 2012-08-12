/************************************************************
 * 类名：EnterpriseService.java
 *
 * 类别：Spring Service
 * 功能：企业单位管理逻辑接口。
 * 
 *   Ver     変更日               企业单位            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.enterprise.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.*;
import com.bip.sys.enterprise.po.*;

public interface EnterpriseService{
	/**
	 * 添加企业单位
	 * 
	 * @param enterprise
	 * @return
	 */
	Serializable save(SysEnterprise enterprise) throws DataAccessException;
	/**
	 * 按条件查找企业单位
	 * 
	 * @return
	 */
	SysEnterprise get(Integer id);

	List find(String queryString);
	List find(String table,String where);

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
	 * 修改企业单位信息
	 * 
	 * @param SysEnterprise
	 * @return
	 */
	void update(SysEnterprise enterprise);
	
	int update(String sql);

	/**
	 * 删除企业单位
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysEnterprise enterprise);
	
	Boolean delete(String table,String where);
	/**
	 * 无sql单表分页查询
	 * @param congditions
	 * @param row
	 * @param i
	 * @return
	 */
	QueryJson findPageByQuery(String congditions, int row, int i);
	/**
	 * 原生sql分页查询
	 * @param congditions
	 * @param row
	 * @param i
	 * @return
	 */
	QueryJson findPageBySql(String congditions, int row, int i);
	/**
	 * HQL分页查询
	 * @param congditions
	 * @param row
	 * @param i
	 * @return
	 */
	QueryJson findPageByHql(String congditions, int row, int i);
	
	SysEnterprise getEnterpriseById(int id);
}
