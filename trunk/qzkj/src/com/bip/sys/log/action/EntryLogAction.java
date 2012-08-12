/**
 * 类名：EntryLogAction.java
 *
 * 类别：Struts2 Action
 * 功能：日志管理入口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-12  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
*/

package com.bip.sys.log.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class EntryLogAction extends ActionSupport {

	/**
	 * 定义常量变量
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 日志入口
	 * 
	 * author：zhaosy
	 * 
	 */
	public String logEntry() {

		return "success";
	}
	
}
