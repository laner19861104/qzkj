/**
 * 类名：LoginEntryAction.java
 *
 * 类别：Struts2 Action
 * 功能：登录入口，实现管理中心用户和企业用户的登录入口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-12  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */

package com.bip.sys.login.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.opensymphony.xwork2.ActionSupport; //模块包
@Controller
public class LoginEntryAction extends baseAction {
	/**
	 * 定义常量及变量
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 管理用户登录
	 */
	public String adminLoginEntry() {
		/*
		 * 清空所有的session
		 */
		Enumeration e = this.getSession().getAttributeNames();
		while (e.hasMoreElements()) {
			String sessionName = (String) e.nextElement();
			this.getSession().removeAttribute(sessionName);
		}
		return "success";
	}
}
