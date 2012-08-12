/**
 * 类名：RolePermissionService.java
 *
 * 类别：Spring Service
 * 功能：角色权限管理逻辑接口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.login.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.*;
import com.bip.sys.login.po.*;

public interface ViewLoginService {
	/**
	 * 添加角色权限
	 * 
	 * @param role
	 * @return
	 */
	Serializable save(ViewLogin role) throws DataAccessException;
	/**
	 * 按条件查找角色权限
	 * 
	 * @return
	 */
	ViewLogin get(ViewLoginId id);

	List find(String queryString);
	
	List findByUserid(int userid);

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
	 * 修改角色权限信息
	 * 
	 * @param SysRole
	 * @return
	 * @throws Exception
	 */
	void update(ViewLogin role) throws Exception;
	int update(String sql) throws Exception;
	/**
	 * 删除角色权限
	 * 
	 * @param id
	 * @return
	 */
	void delete(ViewLogin role);
	Boolean delete(String table,String where);
}
