/************************************************************
 * ������EnterpriseService.java
 *
 * ���Spring Service
 * ���ܣ���ҵ��λ�����߼��ӿڡ�
 * 
 *   Ver     �����               ��ҵ��λ            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.enterprise.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.*;
import com.bip.sys.enterprise.po.*;

public interface EnterpriseService{
	/**
	 * �����ҵ��λ
	 * 
	 * @param enterprise
	 * @return
	 */
	Serializable save(SysEnterprise enterprise) throws DataAccessException;
	/**
	 * ������������ҵ��λ
	 * 
	 * @return
	 */
	SysEnterprise get(Integer id);

	List find(String queryString);
	List find(String table,String where);

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
	 * �޸���ҵ��λ��Ϣ
	 * 
	 * @param SysEnterprise
	 * @return
	 */
	void update(SysEnterprise enterprise);
	
	int update(String sql);

	/**
	 * ɾ����ҵ��λ
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysEnterprise enterprise);
	
	Boolean delete(String table,String where);
	/**
	 * ��sql�����ҳ��ѯ
	 * @param congditions
	 * @param row
	 * @param i
	 * @return
	 */
	QueryJson findPageByQuery(String congditions, int row, int i);
	/**
	 * ԭ��sql��ҳ��ѯ
	 * @param congditions
	 * @param row
	 * @param i
	 * @return
	 */
	QueryJson findPageBySql(String congditions, int row, int i);
	/**
	 * HQL��ҳ��ѯ
	 * @param congditions
	 * @param row
	 * @param i
	 * @return
	 */
	QueryJson findPageByHql(String congditions, int row, int i);
	
	SysEnterprise getEnterpriseById(int id);
}
