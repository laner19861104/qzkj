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
package com.bip.www.service;

import com.bip.common.util.QueryJson;
import com.bip.sys.wwwuser.po.WwwUsers;

/**
 * ���ܣ�
 * ����: zj
 * ���ڣ�2012-10-18
 */
public interface WwwPayRecordService {

	/**
	 * ���ܣ�<br>
	 * author��zj<br>
	 * ���ڣ�2012-10-19 <br>
	 * @param conditions
	 * @param row
	 * @param i
	 * @return
	 */
	QueryJson findPageByQuery(String conditions, int row, int i);

	/**
	 * ���ܣ�<br>
	 * author��zj<br>
	 * ���ڣ�2012-10-19 <br>
	 * @param money
	 * @param wwwUser
	 * @return
	 */
	boolean pay(double money, WwwUsers wwwUser);

	/**
	 * ���ܣ�<br>
	 * author��zj<br>
	 * ���ڣ�2012-10-23 <br>
	 * @param wuser
	 * @return
	 */
	String getTotal(WwwUsers wuser);

}
