/************************************************************
 * 类名：EnterpriseServiceImpl.java
 *
 * 类别：Spring Service
 * 功能：企业单位管理逻辑实现。
 * 
 *   Ver     変更日               企业单位            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.enterprise.serviceimpl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.service.BaseService;
import com.bip.common.util.*;
import com.bip.sys.enterprise.po.*;
import com.bip.sys.enterprise.dao.*;
import com.bip.sys.enterprise.service.*;
@Service
public class EnterpriseServiceImpl extends BaseService implements EnterpriseService {
	private EnterpriseDao enterpriseDao;
	@Autowired
	public void setEnterpriseDao(EnterpriseDao enterpriseDao) {
		this.enterpriseDao = enterpriseDao;
	}

	public EnterpriseDao getEnterpriseDao() {
		return enterpriseDao;
	}
	public EnterpriseServiceImpl() {
	}
	/**
	 * 添加企业单位
	 * 
	 * @param enterprise
	 * @return
	 */
	public Serializable save(SysEnterprise t) throws DataAccessException {
		try {
			return enterpriseDao.save(t);
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * 按条件查找企业单位
	 * 
	 * @return
	 */
	public SysEnterprise get(Integer id) {
		SysEnterprise sr = new SysEnterprise();
		sr = enterpriseDao.get(id);
		return sr;
	}
	public List find(String queryString) {
		List rlist = new ArrayList();
		
		System.out.println("    "+"FROM SysEnterprise " + queryString);
		
		rlist = enterpriseDao.find("FROM SysEnterprise " + queryString);
		return rlist;
	}
	public List find(String table, String where) {
		List rlist = new ArrayList();
		rlist=enterpriseDao.find("job_enterprise", where);
		return rlist==null?null:rlist;

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
		System.out.println("FROM SysEnterprise " + hql);
		
		ps = enterpriseDao.findPageByQuery("FROM SysEnterprise " + hql,
				"FROM SysEnterprise " + countHql, pageSize, startIndex);
		return ps;
	}
	/**
	 * 修改企业单位信息
	 * 
	 * @param SysEnterprise
	 * @return
	 * @throws Exception
	 */
	public void update(SysEnterprise t){
		enterpriseDao.update(t);
	}
	public int update(final String sql) {
		return enterpriseDao.update(sql);
	}
	/**
	 * 删除企业单位
	 * 
	 * @param id
	 * @return
	 */
	public void delete(SysEnterprise t) {
		enterpriseDao.delete(t);
	}
	public Boolean delete(String table, String where) {
		return enterpriseDao.delete("job_enterprise", where);
	}

	public QueryJson findPageByQuery(String congditions, int row, int i) {
		return super.PageQuery(enterpriseDao, VoSysEnterprise.class, congditions, row, i);
	}
	public QueryJson findPageBySql(String congditions, int row, int i) {
		String sql="select rownum as ROWNO,p.id as id,p.dwbh as dwbh,p.dwmc as dwmc from job_enterprise p where 1=1 ";
		String countSql="select count(*) from job_enterprise p where 1=1";
		return super.PageQueryBySql(sql, countSql, enterpriseDao, VoSysEnterprise.class, congditions, row, i);
	}
	public QueryJson findPageByHql(String congditions, int row, int i) {
		String sql="SELECT new com.bip.sys.enterprise.po.VoSysEnterprise(p.id,p.dwbh,p.dwmc,p.xxdz) From SysEnterprise p where 1=1";
		String countSql="select count(*) from SysEnterprise p where 1=1";
		return super.PageQueryByHql(sql, countSql, enterpriseDao, congditions, row, i);
	}
	public SysEnterprise getEnterpriseById(int id) {
		return this.enterpriseDao.get(id);
	}


}
