/************************************************************
 * 类名：JocFileDaoImpl.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2012-7-23  CFIT-PG   刘学堂         初版
 *
 * Copyright (c) 2012 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.common.upload.daoimpl;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.common.upload.dao.JocFileDao;
import com.bip.common.upload.po.JocFile;

/**
 * 
 * 功能：
 * 作者: lxt
 * 日期： 2012-7-23
 */
@Repository
public class JocFileDaoImpl extends GenericDao<JocFile,String> implements JocFileDao {


}
