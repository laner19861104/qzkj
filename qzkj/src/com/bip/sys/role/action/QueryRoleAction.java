/************************************************************
 * 类名：QueryRoleAction.java
 *
 * 类别：Struts2 Action
 * 功能：角色查询。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-30  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.role.action;

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
import com.bip.sys.role.service.RoleService;
import com.bip.sys.user.po.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class QueryRoleAction extends baseAction {

	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private RoleService rservice;
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
	private String qrolename = "";
	private String qtype = "";

	/*
	 * 资源查询
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
			 * 按权限查找
			 */
			if ("admin".equals(this.getUser().getUsername())) {
				hql = " where 1=1 ";
			} else {
				hql = " where  rolename not like '超级管理员%' and (deptno like '%"
						+ (this.getSysDept().getDeptno().substring(6)) + "' or deptno='') ";
			}

			/*
			 * 按条件查找
			 */

			if (!(this.getQtype() == null || "".equals(this.getQtype()) || "%"
					.equals(this.getQtype()))) {
				hql = hql + " and type like '" + this.getQtype() + "'";
			}

			if (!(this.getQrolename() == null || "".equals(this.getQrolename()
					.trim())))
				hql = hql + " and rolename like '%" + this.getQrolename()
						+ "%'";
			hql = hql + "  order by roleid";

			ps = rservice.findPageByQuery(hql, hql, row, (page - 1) * row);
			this.getResponse().setCharacterEncoding("utf-8");
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps
					.getTotalCount(), ps.getItems()), this.getResponse());
		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);
		}
	}

	public RoleService getRservice() {
		return rservice;
	}

	public void setRservice(RoleService rservice) {
		this.rservice = rservice;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getQrolename() {
		return qrolename;
	}

	public void setQrolename(String qrolename) {
		this.qrolename = qrolename;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

}
