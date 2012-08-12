/************************************************************
 * ������ReptDao.java
 *
 * ���Hibernate Dao
 * ���ܣ���ҵ��λ����Hibernate�ӿڡ�
 * 
 *   Ver     �����               ��ҵ��λ            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
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
