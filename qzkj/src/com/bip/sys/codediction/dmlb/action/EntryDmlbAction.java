/************************************************************
 * ������EntryDmlbAction.java
 *
 * ���Struts2 Action
 * ���ܣ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2011-8-16  CFIT-PG   ��÷             ����
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
	 * ����������Ϣ�ֶ�
	 */
	private String message;

	/**
	 * ���
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
