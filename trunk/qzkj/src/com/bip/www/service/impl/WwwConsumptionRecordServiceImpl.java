/************************************************************
 * ������WwwConsumptionRecordServiceImpl.java
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
import com.bip.www.dao.WwwConsumptionRecordDao;
import com.bip.www.service.WwwConsumptionRecordService;

/**
 * ���ܣ�
 * ����: zj
 * ���ڣ�2012-10-19
 */
@Service
public class WwwConsumptionRecordServiceImpl extends BaseService implements WwwConsumptionRecordService{
	@Resource
	private WwwConsumptionRecordDao wwwConsumptionRecordDao;
	

	public WwwConsumptionRecordDao getWwwConsumptionRecordDao() {
		return wwwConsumptionRecordDao;
	}

	public void setWwwConsumptionRecordDao(
			WwwConsumptionRecordDao wwwConsumptionRecordDao) {
		this.wwwConsumptionRecordDao = wwwConsumptionRecordDao;
	}

	/* (non-Javadoc)
	 * @see com.bip.www.service.WwwConsumptionRecordService#findPageByQuery(java.lang.String, int, int)
	 */
	@Override
	public QueryJson findPageByQuery(String conditions, int row, int i) {	
		return super.PageQuery(wwwConsumptionRecordDao, null, conditions, row, i);
	}
}
