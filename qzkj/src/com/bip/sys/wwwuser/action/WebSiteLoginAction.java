/************************************************************
 * ������WebSiteLoginAction.java
 *
 * ���Struts2 Action
 * ���ܣ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2012-10-18  CFIT-PG   �콭         ����
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
 * ���ܣ�
 * ����: zj
 * ���ڣ�2012-10-18
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
	 * ������е�session
	 */
	Enumeration e = this.getSession().getAttributeNames();
	while (e.hasMoreElements()) {
		String sessionName = (String) e.nextElement();
		this.getSession().removeAttribute(sessionName);
	}
    
	if ("".equals(this.getAccount()) || "".equals(this.getPassword())) {
		setMessage("�û��������벻��Ϊ�գ������룡");
		return "failure";
	}
	
//	if(this.getVerifycode()==null||!this.getVerifycode().equalsIgnoreCase(msgverifycode))
//	{
//		setMessage("��֤��������������룡");
//		return "failure";
//	}
	try {
		// ---�ж��û���������ȷ
		if (!wwwUsersService.validate(account, password)) {
			setMessage("�û���������������������룡");
			return "failure";
		}
	} catch (Exception ex) {
		setMessage("��վ�쳣������ϵ�ͷ���");
		ex.printStackTrace();
		return "failure";
	}

	try {
		
		// ---����ϵͳ���ò����Ķ�ȡ��������session�С�
		this.getSession().setAttribute("webuser", wwwUser);

		
		return "success";
	} catch (Exception ex) {
		setMessage("��վ�쳣������ϵ�ͷ���");
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
