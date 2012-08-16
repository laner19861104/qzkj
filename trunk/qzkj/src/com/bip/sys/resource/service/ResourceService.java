/**
 * 类名：ResourceService.java
 *
 * 类别：Spring Service
 * 功能：资源管理逻辑接口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
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
	 * 添加资源
	 * 
	 * @param resource
	 * @return
	 */
	Serializable save(SysResource resource) throws DataAccessException;
	/**
	 * 按条件查找资源
	 * 
	 * @return
	 */
	SysResource get(Integer id);

	List find(String queryString);
	List findResource(Integer userid);
	/**
	 * 分页查找
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex);

	/**
	 * 修改资源信息
	 * 
	 * @param SysResource
	 * @return
	 * @throws Exception
	 */
	void update(SysResource resource) throws Exception;
	int update(String sql) throws Exception;
	/**
	 * 删除资源
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysResource resource);
	Boolean delete(String table,String where);
	List getRsourceListByResPid(String resourceid, Integer userid);
}
