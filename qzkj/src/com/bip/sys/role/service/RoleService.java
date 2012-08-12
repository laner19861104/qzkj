/**
 * 类名：RoleService.java
 *
 * 类别：Spring Service
 * 功能：角色管理逻辑接口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.role.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.*;
import com.bip.sys.role.po.*;

public interface RoleService {
	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return
	 */
	Serializable save(SysRole role) throws DataAccessException;
	/**
	 * 按条件查找角色
	 * 
	 * @return
	 */
	SysRole get(Integer id);

	List find(String queryString);

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
	 * 修改角色信息
	 * 
	 * @param SysRole
	 * @return
	 * @throws Exception
	 */
	void update(SysRole role) throws Exception;
	int update(String sql) throws Exception;
	/**
	 * 删除角色
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysRole role);
	Boolean delete(String table,String where);
}
