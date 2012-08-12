/************************************************************
 * 类名：ReptDao.java
 *
 * 类别：Hibernate Dao
 * 功能：企业单位管理Hibernate接口。
 * 
 *   Ver     変更日               企业单位            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.enterprise.dao;

import java.math.BigDecimal;
import java.util.List;

import com.bip.common.dao.IGenericDao;
import com.bip.sys.enterprise.po.*;

public interface EnterpriseDao extends IGenericDao<SysEnterprise, Integer> {
	List find(String table,String where);
}
