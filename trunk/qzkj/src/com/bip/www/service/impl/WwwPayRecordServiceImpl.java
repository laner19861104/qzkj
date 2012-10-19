/************************************************************
 * ������WwwPayRecordServiceImpl.java
 *
 * ���Struts2 Action
 * ���ܣ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2012-10-19  CFIT-PG   �콭         ����
 *
 * Copyright (c) 2012 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.www.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bip.common.service.BaseService;
import com.bip.common.util.QueryJson;
import com.bip.sys.wwwuser.dao.WwwUsersDao;
import com.bip.sys.wwwuser.service.WwwUsersService;
import com.bip.www.dao.WwwPayRecordDao;
import com.bip.www.service.WwwPayRecordService;

/**
 * ���ܣ�
 * ����: zj
 * ���ڣ�2012-10-19
 */
@Service
public class WwwPayRecordServiceImpl extends BaseService implements WwwPayRecordService{
	@Resource
	private WwwPayRecordDao wwwPayRecordDao ;
	@Resource
	private WwwUsersDao wwwUsersDao;
	/* (non-Javadoc)
	 * @see com.bip.www.service.WwwPayRecordService#findPageByQuery(java.lang.String, int, int)
	 */
	@Override
	public QueryJson findPageByQuery(String conditions, int row, int i) {
		return super.PageQuery(wwwPayRecordDao, null, conditions, row, i);
	}
	public WwwPayRecordDao getWwwPayRecordDao() {
		return wwwPayRecordDao;
	}
	public void setWwwPayRecordDao(WwwPayRecordDao wwwPayRecordDao) {
		this.wwwPayRecordDao = wwwPayRecordDao;
	}
	public WwwUsersDao getWwwUsersDao() {
		return wwwUsersDao;
	}
	public void setWwwUsersDao(WwwUsersDao wwwUsersDao) {
		this.wwwUsersDao = wwwUsersDao;
	}
}
