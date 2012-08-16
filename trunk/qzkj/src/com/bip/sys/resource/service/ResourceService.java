/**
 * ������ResourceService.java
 *
 * ���Spring Service
 * ���ܣ���Դ�����߼��ӿڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.resource.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.jqueryeasyui.Tree;
import com.bip.common.jqueryeasyui.TreeVo;
import com.bip.common.util.*;
import com.bip.sys.resource.po.*;

public interface ResourceService {
	/**
	 * �����Դ
	 * 
	 * @param resource
	 * @return
	 */
	Serializable save(SysResource resource) throws DataAccessException;
	/**
	 * ������������Դ
	 * 
	 * @return
	 */
	SysResource get(Integer id);

	List find(String queryString);
	List findResource(Integer userid);
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
	 * �޸���Դ��Ϣ
	 * 
	 * @param SysResource
	 * @return
	 * @throws Exception
	 */
	void update(SysResource resource) throws Exception;
	int update(String sql) throws Exception;
	/**
	 * ɾ����Դ
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysResource resource);
	Boolean delete(String table,String where);
	List getRsourceListByResPid(String resourceid, Integer userid);
}
