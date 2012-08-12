/**
 * ������PermissionService.java
 *
 * ���Spring Service
 * ���ܣ�Ȩ�޹����߼��ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.permission.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.*;
import com.bip.sys.permission.po.*;

public interface PermissionService {
	/**
	 * ���Ȩ��
	 * 
	 * @param permission
	 * @return
	 */
	Serializable save(SysPermission permission) throws DataAccessException;
	/**
	 * ����������Ȩ��
	 * 
	 * @return
	 */
	SysPermission get(Integer id);

	List find(String queryString);
	
	SysPermission findBySql(String queryString);

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
	 * �޸�Ȩ����Ϣ
	 * 
	 * @param SysPermission
	 * @return
	 * @throws Exception
	 */
	void update(SysPermission permission) throws Exception;
	int update(String sql) throws Exception;
	/**
	 * ɾ��Ȩ��
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysPermission permission);
	Boolean delete(String table,String where);
	
	public List findPermission(Integer userid);
	public List findPermissionByRoleid(Integer roleid);
}
