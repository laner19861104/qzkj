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
package com.bip.sys.role.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.UniContant;
import com.bip.common.util.Replace;
import com.bip.sys.permission.po.SysPermission;
import com.bip.sys.permission.service.PermissionService;
import com.bip.sys.role.po.SysRolepermission;
import com.bip.sys.role.po.SysRolepermissionId;
import com.bip.sys.role.service.RolePermissionService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class EditRolepermissionAction extends baseAction {
	/*
	 * 定义常量变量
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private RolePermissionService rpservice;
	@Resource
	private PermissionService pservice;

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
			String roleid = this.getRequest().getParameter("roleid");// 获取角色编号
			String permissionidsc = this.getRequest().getParameter("permissionidsc");// 获取权限编号

			if (permissionidsc == null || "".equals(permissionidsc)) {
				ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
						UniContant.adderror), this.getResponse());
				return;
			}
			/*
			 * 定义角色权限PO
			 */
			SysRolepermissionId srpid = new SysRolepermissionId();
			SysRolepermission srp = new SysRolepermission();
			/*
			 * 执行数据库写入操作，并根据返回值进行成功、失败处理
			 */
			/*
			 * 删除角色对应权限
			 */
			rpservice.delete("", " roleid="+roleid);
			/*
			 * 重新添加角色对应权限
			 */
			List plist = new ArrayList();
			plist = Replace.replaceStringToList(permissionidsc);
			for (int i = 0; i < plist.size(); i++) {
				String pno = (String) plist.get(i);
				SysPermission sp = pservice.findBySql(" where permissionno ='"
						+ pno + "'");
				srpid.setRoleid(Integer.parseInt(roleid));
				srpid.setPermissionid(sp.getPermissionid());
				srp.setId(srpid);
				rpservice.save(srp);
			}

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
			rpservice.delete("", " (roleid,permissionid) in (" + ids + ")");
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}
	}

	public RolePermissionService getRpservice() {
		return rpservice;
	}

	public void setRpservice(RolePermissionService rpservice) {
		this.rpservice = rpservice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PermissionService getPservice() {
		return pservice;
	}

	public void setPservice(PermissionService pservice) {
		this.pservice = pservice;
	}

}
