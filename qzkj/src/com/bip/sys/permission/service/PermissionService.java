/**
 * 类名：PermissionService.java
 *
 * 类别：Spring Service
 * 功能：权限管理逻辑接口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.permission.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.*;
import com.bip.sys.permission.po.*;

public interface PermissionService {
	/**
	 * 添加权限
	 * 
	 * @param permission
	 * @return
	 */
	Serializable save(SysPermission permission) throws DataAccessException;
	/**
	 * 按条件查找权限
	 * 
	 * @return
	 */
	SysPermission get(Integer id);

	List find(String queryString);
	
	SysPermission findBySql(String queryString);

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
	 * 修改权限信息
	 * 
	 * @param SysPermission
	 * @return
	 * @throws Exception
	 */
	void update(SysPermission permission) throws Exception;
	int update(String sql) throws Exception;
	/**
	 * 删除权限
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysPermission permission);
	Boolean delete(String table,String where);
	
	public List findPermission(Integer userid);
	public List findPermissionByRoleid(Integer roleid);
}
