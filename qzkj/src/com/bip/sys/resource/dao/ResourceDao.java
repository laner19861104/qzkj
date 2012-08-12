/**
 * ������ResourceDao.java
 *
 * ���Hibernate Dao
 * ���ܣ���Դ����Hibernate�ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.resource.dao;

import java.util.List;

import com.bip.common.dao.IGenericDao;
import com.bip.sys.resource.po.*;

public interface ResourceDao extends IGenericDao<SysResource, Integer> {
	public List findResource(Integer userid);
}
