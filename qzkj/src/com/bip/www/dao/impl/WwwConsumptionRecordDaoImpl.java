/************************************************************
 * 类名：WwwConsumptionRecordDaoImpl.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2012-10-19  CFIT-PG   朱江         初版
 *
 * Copyright (c) 2012 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.www.dao.impl;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.www.dao.WwwConsumptionRecordDao;
import com.bip.www.po.WwwConsumptionRecord;

/**
 * 功能：
 * 作者: zj
 * 日期：2012-10-19
 */
@Repository
public class WwwConsumptionRecordDaoImpl extends GenericDao<WwwConsumptionRecord,String> implements WwwConsumptionRecordDao{

}
