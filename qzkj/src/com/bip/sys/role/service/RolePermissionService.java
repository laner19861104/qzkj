/**
 * ������RolePermissionService.java
 *
 * ���Spring Service
 * ���ܣ���ɫȨ�޹����߼��ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.role.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.*;
import com.bip.sys.role.po.*;

public interface RolePermissionService {
	/**
	 * ��ӽ�ɫȨ��
	 * 
	 * @param role
	 * @return
	 */
	Serializable save(SysRolepermission role) throws DataAccessException;
	/**
	 * ���������ҽ�ɫȨ��
	 * 
	 * @return
	 */
	SysRolepermission get(SysRolepermissionId id);

	List find(String queryString);

	/**
	 * ��ҳ����
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex);

	/**
	 * �޸Ľ�ɫȨ����Ϣ
	 * 
	 * @param SysRole
	 * @return
	 * @throws Exception
	 */
	void update(SysRolepermission role) throws Exception;
	int update(String sql) throws Exception;
	/**
	 * ɾ����ɫȨ��
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysRolepermission role);
	Boolean delete(String table,String where);
}
