/**
 * ������RoleDaoImpl.java
 *
 * ���Hibernate DaoImpl
 * ���ܣ���ɫȨ�޹���Hibernateʵ�֡�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.role.daoimpl;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.sys.role.dao.*;
import com.bip.sys.role.po.*;
@Repository
public class RolePermissionDaoImpl extends GenericDao<SysRolepermission, SysRolepermissionId> implements
		RolePermissionDao {

}
