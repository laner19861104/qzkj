/************************************************************
 * 类名：EditRoleAction.java
 *
 * 类别：Struts2 Action
 * 功能：权限新增、修改、删除。
 * 
 *   Ver     変更日               权限            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-30  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.user.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.SqlUtil;
import com.bip.common.util.UniContant;
import com.bip.sys.user.po.SysUserroles;
import com.bip.sys.user.po.SysUserrolesId;
import com.bip.sys.user.service.UserRoleService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EditUserRoleAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private UserRoleService userroleservice;
	// private PermissionService pservice;

	/*
	 * 操作返回信息字段 author：zhaosy
	 */
	private String message;

	/*
	 * 新增
	 * 
	 * author：zhaosy
	 */
	public void add() {
		/******
		 * 新增
		 ******/
		try {
			/*
			 * 将页面值转换成po对象
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysUserroles addpo = new SysUserroles();
			SysUserroles po = (SysUserroles) sqlUtil.getObjByMap(map, addpo);

			String userid = this.getRequest().getParameter("userid");
			String roleid = this.getRequest().getParameter("roleid");

			SysUserrolesId suid = new SysUserrolesId();
			suid.setUserid(Integer.parseInt(userid));
			suid.setRoleid(Integer.parseInt(roleid));
			po.setId(suid);

			Serializable a = userroleservice.save(po);

			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.addok), this.getResponse());
			return;

		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.adderror), this.getResponse());
			return;
		}
	}

	/*
	 * 删除
	 * 
	 * author：zhaosy
	 */
	public void del() {
		/*
		 * 删除
		 */
		try {
			/*
			 * 删除数据
			 */
			String ids = this.getRequest().getParameter("id");
			System.out.println("ids is " + ids);
			userroleservice.delete("", " (userid,roleid) in (" + ids + ")");
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}
	}

	public UserRoleService getUserroleservice() {
		return userroleservice;
	}

	public void setUserroleservice(UserRoleService userroleservice) {
		this.userroleservice = userroleservice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
