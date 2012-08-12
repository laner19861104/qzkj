/**
 * ������RoleService.java
 *
 * ���Spring Service
 * ���ܣ���ɫ�����߼��ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.role.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.*;
import com.bip.sys.role.po.*;

public interface RoleService {
	/**
	 * ��ӽ�ɫ
	 * 
	 * @param role
	 * @return
	 */
	Serializable save(SysRole role) throws DataAccessException;
	/**
	 * ���������ҽ�ɫ
	 * 
	 * @return
	 */
	SysRole get(Integer id);

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
	 * �޸Ľ�ɫ��Ϣ
	 * 
	 * @param SysRole
	 * @return
	 * @throws Exception
	 */
	void update(SysRole role) throws Exception;
	int update(String sql) throws Exception;
	/**
	 * ɾ����ɫ
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysRole role);
	Boolean delete(String table,String where);
}
