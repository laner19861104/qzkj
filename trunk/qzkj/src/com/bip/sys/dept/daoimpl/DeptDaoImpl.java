/************************************************************
 * 类名：DeptDaoImpl.java
 *
 * 类别：Hibernate DaoImpl
 * 功能：部门管理Hibernate实现。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.dept.daoimpl;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.sys.dept.dao.*;
import com.bip.sys.dept.po.*;
@Repository
public class DeptDaoImpl extends GenericDao<SysDepartment, Integer> implements
		DeptDao {

}
