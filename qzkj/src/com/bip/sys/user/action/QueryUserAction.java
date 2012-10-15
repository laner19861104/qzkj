/************************************************************
 * 类名：QueryUserAction.java
 *
 * 类别：Struts2 Action
 * 功能：用户查询。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-30  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.user.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.user.service.UserService;

@Controller
public class QueryUserAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private UserService uservice;
	/*
	 * 查询列表使用： 1>ps：查询返回类； 2>pageId：首页判断字段； 3>hql：hibernate查询用sql author：zhaosy
	 */
	private PaginationSupport ps;
	private int pageId = 1;
	private String hql = "";
	private int startIndex = 0;
	/*
	 * 操作返回信息字段 author：zhaosy
	 */
	private String message;

	/*
	 * 查询条件
	 */
	private String qusername;
	private String qdeptid;
	private String quserxm;

	private List deptlist;

	/*
	 * 查询
	 * 
	 * author：zhaosy
	 */
	public void query() {
		/*
		 * 按条件读取数据列表
		 */
		try {
			if ("admin".equals(this.getUser().getUsername())) {
				hql = " where 1=1 ";
			} else {			
					hql = " where deptid like '%" + (this.getSysDept().getDeptno().substring(6))
							+ "' and username<>'admin' ";
			}

			hql = hql + " order by deptid,username";
			ps = uservice.findPageByQuery(hql, hql, UniContant.pageSize, this
					.getStartIndex());
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps
					.getTotalCount(), ps.getItems()), this.getResponse());
		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);
		}
	}

	public void setQusername(String qusername) {
		this.qusername = qusername;
	}

	public String getQusername() {
		return qusername;
	}

	public void setQdeptid(String qdeptid) {
		this.qdeptid = qdeptid;
	}

	public String getQdeptid() {
		return qdeptid;
	}

	public void setQuserxm(String quserxm) {
		this.quserxm = quserxm;
	}

	public String getQuserxm() {
		return quserxm;
	}

	public void setUservice(UserService uservice) {
		this.uservice = uservice;
	}

	public UserService getUservice() {
		return uservice;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public String getHql() {
		return hql;
	}

	public void setDeptlist(List deptlist) {
		this.deptlist = deptlist;
	}

	public List getDeptlist() {
		return deptlist;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
