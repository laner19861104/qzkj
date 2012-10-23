/************************************************************
 * ������WwwPayRecordDao.java
 *
 * ���Struts2 Action
 * ���ܣ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2012-10-18  CFIT-PG   �콭         ����
 *
 * Copyright (c) 2012 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.www.dao;

import com.bip.common.dao.IGenericDao;
import com.bip.www.po.WwwPayRecord;

/**
 * ���ܣ�
 * ����: zj
 * ���ڣ�2012-10-18
 */
public interface WwwPayRecordDao extends IGenericDao<WwwPayRecord,String>{

	/**
	 * ���ܣ�<br>
	 * author��zj<br>
	 * ���ڣ�2012-10-23 <br>
	 * @param hql
	 * @return
	 */
	String executeHQL(String hql);

}
