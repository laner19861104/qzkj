/************************************************************
 * 类名：EntryDeptAction.java
 *
 * 类别：Struts2 Action
 * 功能：部门管理入口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-12  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/

package com.bip.sys.dept.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import com.bip.common.action.baseAction;
import com.bip.common.util.UniContant;
import com.bip.sys.codediction.dmzd.service.*;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.user.po.SysUsers;
@Controller
public class EntryDeptAction extends baseAction {
	private static final long serialVersionUID = 1L;
	

	/*
	 * 操作返回信息字段
	 */
	private String message;
	/*
	 * 定义代码字典Service，定义代码字段List
	 */
	@Resource
	private DmzdService dmzdservice;
	private List dept_typesc;
	private List dept_levelsc;

	/*
	 * 部门入口
	 * 
	 * author：zhaosy
	 */
	public String deptEntry() {
		try {
			/*
			 * 读取数据字典中关于单位的,并将取出的值放入session中
			 */
			String ssxt = "";
			if ("admin".equals(this.getUser().getUsername())
					|| "00".equals(this.getSysDept().getDepttype()))// 系统（全部）
			{
				ssxt = " and (ssxt is null or ssxt like '%')";
			} else {
				ssxt = " and (ssxt is null or ssxt='' or ssxt='00' or ssxt='"
						+ this.getSysDept().getDepttype() + "')";
			}
			List rlist = dmzdservice.findDeptSc(ssxt);
			if (rlist == null || rlist.size() < 2) {
				this.setMessage(UniContant.dmzderror);
				return "failure";
			}
			dept_typesc = (List) rlist.get(0);
			dept_levelsc = (List) rlist.get(1);
			this.getSession().setAttribute("dept_typesc", dept_typesc);
			this.getSession().setAttribute("dept_levelsc", dept_levelsc);
			/*
			 * 读取默认数据列表页（按用户角色权限）
			 */
			return "success";
		} catch (Exception ex) {
			this.setMessage(UniContant.connerror);
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

	public List getDept_typesc() {
		return dept_typesc;
	}

	public void setDept_typesc(List deptTypesc) {
		dept_typesc = deptTypesc;
	}

	public List getDept_levelsc() {
		return dept_levelsc;
	}

	public void setDept_levelsc(List deptLevelsc) {
		dept_levelsc = deptLevelsc;
	}

}