/**
 * ������LoginEntryAction.java
 *
 * ���Struts2 Action
 * ���ܣ���¼��ڣ�ʵ�ֹ��������û�����ҵ�û��ĵ�¼��ڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-12  CFIT-PM   ��ʤ��         ����
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
import com.opensymphony.xwork2.ActionSupport; //ģ���
@Controller
public class LoginEntryAction extends baseAction {
	/**
	 * ���峣��������
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * �����û���¼
	 */
	public String adminLoginEntry() {
		/*
		 * ������е�session
		 */
		Enumeration e = this.getSession().getAttributeNames();
		while (e.hasMoreElements()) {
			String sessionName = (String) e.nextElement();
			this.getSession().removeAttribute(sessionName);
		}
		return "success";
	}
}
