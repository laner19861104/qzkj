/************************************************************
 * 类名：EntryDmlbAction.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2011-8-16  CFIT-PG   赵梅             初版
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.codediction.dmlb.action;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EntryDmlbAction extends baseAction {

	/*
	 * 操作返回信息字段
	 */
	private String message;

	/**
	 * 入口
	 * 
	 * @return
	 */
	public String dmlbEntry() {

		return "success";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
