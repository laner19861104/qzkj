/************************************************************
 * 类名：ReptDao.java
 *
 * 类别：Hibernate Dao
 * 功能：部门管理Hibernate接口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.dept.dao;

import com.bip.common.dao.IGenericDao;
import com.bip.sys.dept.po.*;

public interface DeptDao extends IGenericDao<SysDepartment, Integer> {
	
}
