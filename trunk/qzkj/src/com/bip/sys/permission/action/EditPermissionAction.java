/************************************************************
 * 类名：EditPermissionAction.java
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
package com.bip.sys.permission.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

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

import com.bip.common.util.idinfo.service.IdInfoService;
import com.bip.common.util.idinfo.service.PairValue;
import com.bip.common.util.idinfo.serviceimpl.IdInfoServiceImpl;
import com.bip.sys.permission.po.SysPermission;
import com.bip.sys.permission.service.PermissionService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EditPermissionAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private PermissionService dservice;
	@Resource
	private IdInfoService idService;

	/*
	 * 操作返回信息字段 author：zhaosy
	 */
	private String message;

	/*
	 * 查询条件
	 */
	private String qpermissionname = "";

	


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
			SysPermission addpo = new SysPermission();
			SysPermission po = (SysPermission) sqlUtil.getObjByMap(map, addpo);
			
			/*
			 * 判断是否存在重复记录
			 */
			List existl = dservice.find(" where permissionno='"
					+ po.getPermissionno() + "'");
			if (existl != null) {
				if (existl.size() != 0) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
							UniContant.existerror), this.getResponse());
					return;
				}
			}
			/*
			 * 取数据表新增需要的自增ID
			 */
			PairValue pv = idService
					.getIDs("sys_permission", "permissionid", 1);
			long id = pv.max;
			po.setPermissionid(Integer.parseInt(String.valueOf(id)));
			/*
			 * 执行数据库写入操作，并根据返回值进行成功、失败处理
			 */

			Serializable a = dservice.save(po);
			if ((Integer) a ==po.getPermissionid()) {
				ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
						UniContant.addok), this.getResponse());
				return;
			} else {
				ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
						UniContant.adderror), this.getResponse());
				return;
			}
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.adderror), this.getResponse());
			return;
		}
	}

	/*
	 * 修改
	 * 
	 * author：zhaosy
	 */
	public void edit() {

		/******
		 * 修改
		 ******/
		try {
			/*
			 * 将页面值转换成po对象
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysPermission addpo = new SysPermission();
			SysPermission po = (SysPermission) sqlUtil.getObjByMap(map, addpo);

			dservice.update(po);
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.editok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.editerror), this.getResponse());
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
//			String[] idlist = Tool.explode(",", ids);
//			for (int i = 0; i < idlist.length; i++) {
//				String id = (String) idlist[i];
//				dservice.delete("", " permissionid=" + id + "");
//			}
			dservice.delete("", " permissionid in (" + ids + ")");
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return ;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}
	}

	public PermissionService getDservice() {
		return dservice;
	}

	public void setDservice(PermissionService dservice) {
		this.dservice = dservice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getQpermissionname() {
		return qpermissionname;
	}

	public void setQpermissionname(String qpermissionname) {
		this.qpermissionname = qpermissionname;
	}

	public IdInfoService getIdService() {
		return idService;
	}

	public void setIdService(IdInfoService idService) {
		this.idService = idService;
	}

}
