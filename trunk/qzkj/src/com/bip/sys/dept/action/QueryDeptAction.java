/************************************************************
 * 类名：QueryDeptAction.java
 *
 * 类别：Struts2 Action
 * 功能：部门查询。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-30  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.dept.action;

import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.dept.service.DeptService;
import com.bip.sys.user.po.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class QueryDeptAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private DeptService dservice;
	/*
	 * 查询列表使用： 1>ps：查询返回类； 2>pageId：首页判断字段； 3>hql：hibernate查询用sql author：zhaosy
	 */
	private PaginationSupport ps;
	private String hql = "";

	/*
	 * 操作返回信息字段 author：zhaosy
	 */
	private String message;

	/*
	 * 查询条件
	 */
	private String qdeptname = "";
	private String qdeptno = "";
	private String qdepttype = "";
	private String qdeptlevel = "";

	/*
	 * 查询
	 * 
	 * author：zhaosy
	 */
	public void query() {
		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		int row = Integer.parseInt(this.getRequest().getParameter("rows"));// 接受参数page和rows
		/*
		 * 按条件读取数据列表
		 */
		try {
			/*
			 * 超级管理员用户admin可查看所有，其它用户只能查看本机构/部门下
			 */
			if ("admin".equals(this.getUser().getUsername())) {
				hql = " where deptno like '%'";
			} else {
				if("00".equals(this.getSysDept().getDeptno().substring(4,6)))
				{
					hql = " where deptno like '%" + (this.getSysDept().getDeptno().substring(6)) + "'";
				}	
				else
				{
					hql=" where deptno like '" + this.getSysDept().getDeptno() + "'";
				}
			}
			if (!(this.getQdepttype() == null
					|| "%".equals(this.getQdepttype().trim()) || "".equals(this
					.getQdepttype().trim())))
				hql = hql + " and depttype like '%" + this.getQdepttype()
						+ "%'";
			if (!(this.getQdeptlevel() == null
					|| "%".equals(this.getQdeptlevel().trim()) || ""
					.equals(this.getQdeptlevel().trim())))
				hql = hql + " and deptlevel like '%" + this.getQdeptlevel()
						+ "%'";
			if (!(this.getQdeptname() == null || "".equals(this.getQdeptname()
					.trim())))
				hql = hql
						+ " and deptname like '%"
						+ URLDecoder.decode(URLDecoder.decode(this
								.getQdeptname(), "utf-8"), "utf-8") + "%'";
			if (!(this.getQdeptno() == null || "".equals(this.getQdeptno()
					.trim())))
				hql = hql + " and deptno like '%" + this.getQdeptno() + "%'";
			hql = hql + " order by deptno ";
			ps = dservice.findPageByQuery(hql, hql, row, (page - 1) * row);
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps
					.getTotalCount(), ps.getItems()), this.getResponse());
		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);
		}
	}

	public void setDservice(DeptService dservice) {
		this.dservice = dservice;
	}

	public DeptService getDservice() {
		return dservice;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public String getHql() {
		return hql.trim();
	}

	public String getQdeptname() {
		return qdeptname;
	}

	public void setQdeptname(String qdeptname) {
		this.qdeptname = qdeptname;
	}

	public String getQdeptno() {
		return qdeptno;
	}

	public void setQdeptno(String qdeptno) {
		this.qdeptno = qdeptno;
	}

	public String getQdepttype() {
		return qdepttype;
	}

	public void setQdepttype(String qdepttype) {
		this.qdepttype = qdepttype;
	}

	public String getQdeptlevel() {
		return qdeptlevel;
	}

	public void setQdeptlevel(String qdeptlevel) {
		this.qdeptlevel = qdeptlevel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
