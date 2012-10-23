/************************************************************
 * 类名：WwwPayRecordDao.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2012-10-18  CFIT-PG   朱江         初版
 *
 * Copyright (c) 2012 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.www.dao;

import com.bip.common.dao.IGenericDao;
import com.bip.www.po.WwwPayRecord;

/**
 * 功能：
 * 作者: zj
 * 日期：2012-10-18
 */
public interface WwwPayRecordDao extends IGenericDao<WwwPayRecord,String>{

	/**
	 * 功能：<br>
	 * author：zj<br>
	 * 日期：2012-10-23 <br>
	 * @param hql
	 * @return
	 */
	String executeHQL(String hql);

}
