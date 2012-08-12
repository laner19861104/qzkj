/************************************************************
 * ������DeptService.java
 *
 * ���Spring Service
 * ���ܣ����Ź����߼��ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.dept.service;

import java.io.Serializable;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.*;
import com.bip.sys.dept.po.*;

public interface DeptService {
	/**
	 * ��Ӳ���
	 * 
	 * @param dept
	 * @return
	 */
	Serializable save(SysDepartment dept) throws DataAccessException;

	/**
	 * ���������Ҳ���
	 * 
	 * @return
	 */
	SysDepartment get(Integer id);

	SysDepartment getByNo(String deptno);

	List find(String queryString);

	List findBySql(String queryString);

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
	 * �޸Ĳ�����Ϣ
	 * 
	 * @param SysDepartment
	 * @return
	 * @throws Exception
	 */
	void update(SysDepartment dept) throws Exception;

	int update(String sql) throws Exception;

	/**
	 * ɾ������
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysDepartment dept);

	Boolean delete(String table, String where);
}
