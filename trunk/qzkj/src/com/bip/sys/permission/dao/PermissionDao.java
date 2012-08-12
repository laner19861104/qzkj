/**
 * ������PermissionDao.java
 *
 * ���Hibernate Dao
 * ���ܣ�Ȩ�޹���Hibernate�ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.permission.dao;

import java.util.List;

import com.bip.common.dao.IGenericDao;
import com.bip.sys.permission.po.*;

public interface PermissionDao extends IGenericDao<SysPermission, Integer> {
	public List findPermission(Integer userid);
	public List findPermissionByRoleid(Integer roleid);
}
