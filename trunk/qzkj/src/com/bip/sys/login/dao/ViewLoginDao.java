/**
 * ������RoleDao.java
 *
 * ���Hibernate Dao
 * ���ܣ���ɫȨ�޹���Hibernate�ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.login.dao;

import java.util.List;

import com.bip.common.dao.IGenericDao;
import com.bip.sys.login.po.*;

public interface ViewLoginDao extends IGenericDao<ViewLogin, ViewLoginId> {
	public List findByUserid(int userid) ;

}
