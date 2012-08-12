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
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.role.po.SysRole;
import com.bip.sys.role.service.RolePermissionService;
import com.bip.sys.role.service.RoleService;
import com.bip.sys.user.po.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EditRoleAction extends baseAction {
	/*
	 * 定义常量变量
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private RoleService rservice;
	@Resource
	private RolePermissionService rpservice;
	@Resource
	private IdInfoService idService;

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
			SysRole addpo = new SysRole();
			SysRole po = (SysRole) sqlUtil.getObjByMap(map, addpo);
			/*
			 * 判断po.getDeptno()
			 */
			if (po.getDeptno() == null || "".equals(po.getDeptno())) {
				if ("admin".equals(this.getUser().getUsername())) {
					po.setDeptno("");
				} else {
					po.setDeptno(this.getSysDept().getDeptno());
				}
			}
			
			/*
			 * 取数据表新增需要的自增ID
			 */
			PairValue pv = idService.getIDs("sys_role", "roleid", 1);
			long id = pv.max;
			po.setRoleid(Integer.parseInt(String.valueOf(id)));
			/*
			 * 重复判断
			 */
			List existl=rservice.find(" where rolename='"+po.getRolename()+"' and deptno='"+po.getDeptno()+"'");
			if (existl.size() > 0) {
					SysRole role = (SysRole) existl.get(0);
					if(!(role.getRoleid()==po.getRoleid())){
						ControllerUtil.responseWriter(ControllerUtil
								.getJsonMsg(false, UniContant.existerror),
								this.getResponse());
						return;
					}
				}
			/*
			 * 执行数据库写入操作，并根据返回值进行成功、失败处理
			 */
			
			Serializable a = rservice.save(po);
			if ((Integer) a == po.getRoleid()) {
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
			SysRole addpo = new SysRole();
			SysRole po = (SysRole) sqlUtil.getObjByMap(map, addpo);
			
			/*
			 * 重复判断
			 */
			List existl=rservice.find(" where rolename='"+po.getRolename()+"' and deptno='"+po.getDeptno()+"'");
			
			if (existl.size() > 0) {
				SysRole role = (SysRole) existl.get(0);
				if(role.getRoleid().compareTo(po.getRoleid())!=0){
					ControllerUtil.responseWriter(ControllerUtil
							.getJsonMsg(false, UniContant.existerror),
							this.getResponse());
					return;
				}
			}
			/*
			 * 执行修改数据库操作
			 */
			rservice.update(po);
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

			rservice.delete("", " roleid in (" + ids + ")");
			rpservice.delete("", " roleid in (" + ids + ")");
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}
	}

	public RoleService getRservice() {
		return rservice;
	}

	public void setRservice(RoleService rservice) {
		this.rservice = rservice;
	}

	public IdInfoService getIdService() {
		return idService;
	}

	public void setIdService(IdInfoService idService) {
		this.idService = idService;
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

	public RolePermissionService getRpservice() {
		return rpservice;
	}

	public void setRpservice(RolePermissionService rpservice) {
		this.rpservice = rpservice;
	}

}
