/**
 * 类名：EntryPermissionAction.java
 *
 * 类别：Struts2 Action
 * 功能：权限管理入口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-12  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */

package com.bip.sys.permission.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.jqueryeasyui.JqueryUtil;
import com.bip.common.util.UniContant;
import com.bip.sys.codediction.dmzd.service.DmzdService;
import com.bip.sys.resource.service.ResourceService;
import com.bip.sys.util.DatalistToTreelist;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EntryPermissionAction extends baseAction {


	private static final long serialVersionUID = 1L;

	/*
	 * 操作返回信息字段 author：zhaosy
	 */
	private String message;
	/*
	 * 定义代码字典Service，定义代码字段List
	 */
	@Resource
	private DmzdService dmzdservice;
	@Resource
	private ResourceService rservice;
	private List resourcelist;
	private List permission_actionidsc;
	private String restreejson;

	/*
	 * 权限管理入口
	 * 
	 * author：zhaosy
	 */
	public String permissionEntry() throws Exception {
		try {
			/*
			 * 读取数据字典中关于权限的：是否可删、权限类型
			 */
			List rlist = dmzdservice.findPermissionSc();
			if (rlist == null || rlist.size() < 1) {
				this.setMessage(UniContant.dmzderror);
				return "failure";
			}
			permission_actionidsc = (List) rlist.get(0);
			this.getSession()
					.setAttribute("permission_actionidsc",
							permission_actionidsc);
			resourcelist = rservice.find(" order by resourceno");
			
			this.getSession().setAttribute("resourcelist", resourcelist);

			restreejson = JqueryUtil
					.getDropDownMenuTreeJson("0", DatalistToTreelist
							.fromResourcelistToTreelist(resourcelist));
			System.out.println("restreejson is " + restreejson);
			return "success";
		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);
			return "failure";
		}
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DmzdService getDmzdservice() {
		return dmzdservice;
	}

	public void setDmzdservice(DmzdService dmzdservice) {
		this.dmzdservice = dmzdservice;
	}

	public List getPermission_actionidsc() {
		return permission_actionidsc;
	}

	public void setPermission_actionidsc(List permissionActionidsc) {
		permission_actionidsc = permissionActionidsc;
	}

	public ResourceService getRservice() {
		return rservice;
	}

	public void setRservice(ResourceService rservice) {
		this.rservice = rservice;
	}

	public String getRestreejson() {
		return restreejson;
	}

	public void setRestreejson(String restreejson) {
		this.restreejson = restreejson;
	}

}
