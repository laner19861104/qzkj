/**
 * ������EntryLogAction.java
 *
 * ���Struts2 Action
 * ���ܣ���־������ڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-12  CFIT-PM   ��ʤ��         ����
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
	 * ���峣������
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ��־���
	 * 
	 * author��zhaosy
	 * 
	 */
	public String logEntry() {

		return "success";
	}
	
}
