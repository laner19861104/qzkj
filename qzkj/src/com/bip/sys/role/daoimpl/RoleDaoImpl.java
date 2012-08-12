/**
 * 类名：RoleDaoImpl.java
 *
 * 类别：Hibernate DaoImpl
 * 功能：角色管理Hibernate实现。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.role.daoimpl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.sys.role.dao.*;
import com.bip.sys.role.po.*;
@Repository
public class RoleDaoImpl extends GenericDao<SysRole, Integer> implements
		RoleDao {

}
