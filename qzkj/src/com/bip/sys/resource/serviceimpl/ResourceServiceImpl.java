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
package com.bip.sys.resource.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.service.BaseService;
import com.bip.common.util.*;
import com.bip.sys.resource.po.*;
import com.bip.sys.resource.dao.*;
import com.bip.sys.resource.service.*;
@Service
public class ResourceServiceImpl extends BaseService implements ResourceService {
	@Resource
	private ResourceDao resourceDao;

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public ResourceServiceImpl() {
	}

	/**
	 * 添加资源
	 * 
	 * @param resource
	 * @return
	 */
	public Serializable save(SysResource t) throws DataAccessException {
		return resourceDao.save(t);
	}

	/**
	 * 按条件查找资源
	 * 
	 * @return
	 */
	public SysResource get(Integer id) {
		SysResource sr = new SysResource();
		sr = resourceDao.get(id);
		return sr;
	}
	public List findResource(Integer userid) {
		List rlist = new ArrayList();
		rlist = resourceDao.findResource(userid);
		return rlist;
	}
	public List find(String queryString) {
		List rlist = new ArrayList();
		rlist = resourceDao.find("FROM SysResource " + queryString);
		return rlist;
	}

	/**
	 * 分页查找
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	public PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex) {
		PaginationSupport ps = new PaginationSupport(null, 0, 0, 0);
		ps = resourceDao.findPageByQuery("FROM SysResource " + hql,
				"FROM SysResource " + countHql, pageSize, startIndex);
		return ps;
	}

	/**
	 * 修改资源信息
	 * 
	 * @param SysResource
	 * @return
	 * @throws Exception
	 */
	public void update(SysResource t) throws Exception {
		resourceDao.update(t);
	}
	public int update(final String sql) throws Exception {
		return resourceDao.update(sql);
	}
	/**
	 * 删除资源
	 * 
	 * @param id
	 * @return
	 */
	public void delete(SysResource t) {
		resourceDao.delete(t);
	}
	public Boolean delete(String table, String where) {
		return resourceDao.delete("sys_resource", where);

	}

	public List getRsourceListByResPid(String resourceid, Integer userid) {
		String sql="select t6.resourceno as id, t6.presourceno as pid, t6.resourcename as name,t6.link as url, t6.imageurl as icon, if(t6.link is null,'true','false') as isParent,'mainFrame' as target"+
		 " from sys_users t1"+
		 " join sys_userroles t2 on t1.userid=t2.userid"+
		 " join sys_role t3 on t2.roleid=t3.roleid"+
		 " join sys_rolepermission t4 on t3.roleid=t4.roleid"+
		 " join sys_permission t5 on t4.permissionid=t5.permissionid"+
		 " join sys_resource t6 on t5.resourceid=t6.resourceno where t6.PRESOURCENO like'"+resourceid+"%' and t1.userid="+userid+" order by t6.resourceno";
		return resourceDao.query(sql);
	}
}
