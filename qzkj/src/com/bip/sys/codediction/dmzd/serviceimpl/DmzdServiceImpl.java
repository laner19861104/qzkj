/**
 * 类名：DmzdService.java
 *
 * 类别：Spring ServiceImpl
 * 功能：代码字典spring实现。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-27  CFIT-PM   syl        初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.codediction.dmzd.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.util.*;
import com.bip.sys.codediction.dmzd.po.*;
import com.bip.sys.codediction.dmzd.dao.*;
import com.bip.sys.codediction.dmzd.service.*;
import com.bip.sys.codediction.util.SysCodeSupport;
@Service
public  class DmzdServiceImpl implements DmzdService {
	@Resource
	private DmzdDao dmzdDao;

	public void setDmzdDao(DmzdDao dmzdDao) {
		this.dmzdDao = dmzdDao;
	}

	public DmzdDao getDmzdDao() {
		return dmzdDao;
	}

	public DmzdServiceImpl() {
	}

	/**
	 * 添加
	 * 
	 * @param role
	 * @return
	 */
	public Serializable save(SysDmzd t) throws DataAccessException {
		return dmzdDao.save(t);
	}

	/**
	 * 按条件查找
	 * 
	 * @return
	 */
	public SysDmzd get(Integer id) {
		SysDmzd sr = new SysDmzd();
		sr = dmzdDao.get(id);
		return sr;
	}

	public List<SysDmzd> find(String queryString) {
		List rlist = new ArrayList();
		rlist = dmzdDao.find("FROM SysDmzd " + queryString);
		return rlist;
	}

	/**
	 * 分页查找
	 * 
	 * @param PaginationSupport
	 * @return
	 */
	public PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex) {
		PaginationSupport ps = new PaginationSupport(null, 0, 0, 0);
		ps = dmzdDao.findPageByQuery("FROM SysDmzd " + hql, "FROM SysDmzd "
				+ countHql, pageSize, startIndex);
		return ps;
	}

	/**
	 * 修改
	 * 
	 * @param SysDmzd
	 * @return
	 * @throws Exception
	 */
	public void update(SysDmzd t) throws Exception {
		dmzdDao.update(t);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public void delete(SysDmzd t) {
		dmzdDao.delete(t);
	}

	public Boolean delete(String tablename, String where) {
		return dmzdDao.delete("sys_dmzd", where);
	}

	public SysCodeSupport getSysCodeSupport(String lbbh) {
		// TODO Auto-generated method stub
		return dmzdDao.getSysCodeSupport(lbbh);
	}

	/**
	 * 获取部门字典
	 * 
	 * @return List(dept_typesc,dept_levelsc)
	 */
	public List findDeptSc(String sql) {
		List rlist = new ArrayList();
		List dept_typesc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.DEPT_TYPE + "') " + sql);
		rlist.add(0, dept_typesc);
		List dept_levelsc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.DEPT_LEVEL + "') " + sql);
		rlist.add(1, dept_levelsc);
		return rlist;
	}

	/**
	 * 获取资源字典
	 * 
	 * @return List(resource_typesc)
	 */
	public List findResourceSc() {
		List rlist = new ArrayList();
		List resource_typesc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.RESOURCE_TYPE + "')");
		rlist.add(0, resource_typesc);
		return rlist;
	}

	/**
	 * 获取权限字典
	 * 
	 * @return List(permission_actionidsc)
	 */
	public List findPermissionSc() {
		List rlist = new ArrayList();
		List pemission_actionidsc = dmzdDao
				.find("FROM SysDmzd Where upper(lbbh) like upper('"
						+ UniContant.PERMISSION_ACTIONID + "')");
		rlist.add(0, pemission_actionidsc);
		return rlist;
	}

	/**
	 * 获取角色字典
	 * 
	 * @return List(role_typesc)
	 */
	public List findRoleSc(String sql) {
		List rlist = new ArrayList();
		List role_typesc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.ROLE_TYPE + "') " + sql);
		rlist.add(0, role_typesc);
		return rlist;
	}

	/**
	 * 获取用户字典。
	 * 
	 * @return 
	 *         List(user_postprivsc,user_sexsc,user_hidebirthsc,user_hidemobilesc
	 *         ,user_smson,user_statesc,user_regionsc)
	 */
	public List findUserSc() {
		List rlist = new ArrayList();
		List user_postprivsc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.USER_POSTPRIV + "')");

		rlist.add(0, user_postprivsc);
		List user_sexsc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.USER_SEX + "')");
		rlist.add(1, user_sexsc);
		List user_hidebirthsc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.USER_HIDEBIRTH + "')");

		rlist.add(2, user_hidebirthsc);
		List user_hidemobilesc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.USER_HIDEMOBILE + "')");

		rlist.add(3, user_hidemobilesc);
		List user_smsonsc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.USER_SMSON + "')");

		rlist.add(4, user_smsonsc);
		List user_statessc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.USER_STATE + "')");
		rlist.add(5, user_statessc);

		List user_regionsc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.USER_REGION + "')");
		rlist.add(6, user_regionsc);
		
		List user_dutytypesc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.USER_DUTYTYPE + "')");
		rlist.add(7, user_dutytypesc);
		
		List user_typesc = dmzdDao.find("FROM SysDmzd Where upper(lbbh) like upper('"
				+ UniContant.USER_TYPE + "')");
		rlist.add(8, user_typesc);
		
		return rlist;
	}
	/**
	 * 企业基本信息
	 * 
	 * @return List(enter_dwlxsc, enter_zdlbsc, enter_zdlxsc, enter_dwlbsc
	 *         ,enter_dwxzsc,startmarksc,ssqysc)
	 */
	public List findEnterpriseSc() {
		List rlist = new ArrayList();
		List enter_ssqysc = dmzdDao.find("FROM SysDmzd Where lbbh like '"
				+ UniContant.ENTERPRISE_QYSC + "'");
		rlist.add(0, enter_ssqysc);
		List enter_hyflsc = dmzdDao.find("FROM SysDmzd Where lbbh like '"
				+ UniContant.ENTERPRISE_HYFLSC + "'");
		rlist.add(1, enter_hyflsc);
		List enter_zdlbsc = dmzdDao.find("FROM SysDmzd Where lbbh like '"
				+ UniContant.ENTERPRISE_ZDLBSC + "'");
		rlist.add(2, enter_zdlbsc);
		List enter_zdlxsc = dmzdDao.find("FROM SysDmzd Where lbbh like '"
				+ UniContant.ENTERPRISE_ZDLXSC + "'");
		rlist.add(3, enter_zdlxsc);
		List enter_typesc = dmzdDao.find("FROM SysDmzd Where lbbh like '"
				+ UniContant.ENTERPRISE_TYPESC + "'");
		rlist.add(4, enter_typesc);
		List enter_dwlxsc = dmzdDao.find("FROM SysDmzd Where lbbh like '"
				+ UniContant.ENTERPRISE_DWLXSC + "'");
		rlist.add(5, enter_dwlxsc);
		List enter_nhfw = dmzdDao.find("FROM SysDmzd Where lbbh like 'SYS_NHFW'");
		rlist.add(6, enter_nhfw);
//		List enter_gxtypesc = dmzdDao.find("FROM SysDmzd Where lbbh like '"
//				+ UniContant.enter_gxtype + "'");
//		rlist.add(7, enter_gxtypesc);

		return rlist;
	}
}
