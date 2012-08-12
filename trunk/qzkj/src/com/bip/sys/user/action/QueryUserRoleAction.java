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
package com.bip.sys.user.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.user.service.UserRoleService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class QueryUserRoleAction extends baseAction {

	private static final long serialVersionUID = 1L;

	/*
	 * 定义操作 Service
	 */
	@Resource
	private UserRoleService userroleservice;
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
			 * 按条件查找
			 */
			String userid = this.getRequest().getParameter("userid");
			hql = " where userid=" + userid;
			hql = hql + "  order by userid";
			ps = userroleservice.findPageByQuery(hql, hql, row, (page - 1)
					* row);
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps
					.getTotalCount(), ps.getItems()), this.getResponse());
			return;
			
		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);
			return;
		}
	}

	public UserRoleService getUserroleservice() {
		return userroleservice;
	}

	public void setUserroleservice(UserRoleService userroleservice) {
		this.userroleservice = userroleservice;
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

}
