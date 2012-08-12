/**
 * 类名：PermissionDao.java
 *
 * 类别：Hibernate Dao
 * 功能：权限管理Hibernate接口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.permission.dao;

import java.util.List;

import com.bip.common.dao.IGenericDao;
import com.bip.sys.permission.po.*;

public interface PermissionDao extends IGenericDao<SysPermission, Integer> {
	public List findPermission(Integer userid);
	public List findPermissionByRoleid(Integer roleid);
}
