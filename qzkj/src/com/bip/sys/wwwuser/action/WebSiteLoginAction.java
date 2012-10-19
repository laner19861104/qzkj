/************************************************************
 * 类名：WebSiteLoginAction.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2012-10-18  CFIT-PG   朱江         初版
 *
 * Copyright (c) 2012 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.wwwuser.action;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.sys.wwwuser.po.WwwUsers;
import com.bip.sys.wwwuser.service.WwwUsersService;

/**
 * 功能：
 * 作者: zj
 * 日期：2012-10-18
 */
@Controller
public class WebSiteLoginAction extends baseAction{
	private static final long serialVersionUID = 1L;
	private String message = "";
	private String account = "";
	
	private String password = "";
	private String verifycode="";
	private WwwUsers wwwUser;

	@Resource
	private WwwUsersService wwwUsersService;
public String login()
{
	String msgverifycode=(String)this.getSession().getAttribute("verifyCode");
	/*
	 * 清空所有的session
	 */
	Enumeration e = this.getSession().getAttributeNames();
	while (e.hasMoreElements()) {
		String sessionName = (String) e.nextElement();
		this.getSession().removeAttribute(sessionName);
	}
    
	if ("".equals(this.getAccount()) || "".equals(this.getPassword())) {
		setMessage("用户名、密码不能为空，请输入！");
		return "failure";
	}
	
//	if(this.getVerifycode()==null||!this.getVerifycode().equalsIgnoreCase(msgverifycode))
//	{
//		setMessage("验证码错误，请重新输入！");
//		return "failure";
//	}
	try {
		// ---判断用户、密码正确
		if (!wwwUsersService.validate(account, password)) {
			setMessage("用户名或密码错误，请重新输入！");
			return "failure";
		}
	} catch (Exception ex) {
		setMessage("网站异常！请联系客服！");
		ex.printStackTrace();
		return "failure";
	}

	try {
		
		// ---进行系统公用参数的读取，并导入session中。
		this.getSession().setAttribute("webuser", wwwUser);

		
		return "success";
	} catch (Exception ex) {
		setMessage("网站异常！请联系客服！");
		ex.printStackTrace();
		return "failure";
	}
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getVerifycode() {
	return verifycode;
}
public void setVerifycode(String verifycode) {
	this.verifycode = verifycode;
}
public WwwUsers getWwwUser() {
	return wwwUser;
}
public void setWwwUser(WwwUsers wwwUser) {
	this.wwwUser = wwwUser;
}

public void setWwwUsersService(WwwUsersService wwwUsersService) {
	this.wwwUsersService = wwwUsersService;
}

}
