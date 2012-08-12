/************************************************************
 * ������EntryDeptAction.java
 *
 * ���Struts2 Action
 * ���ܣ����Ź�����ڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-12  CFIT-PM   ��ʤ��         ����
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
	 * ����������Ϣ�ֶ�
	 */
	private String message;
	/*
	 * ��������ֵ�Service����������ֶ�List
	 */
	@Resource
	private DmzdService dmzdservice;
	private List dept_typesc;
	private List dept_levelsc;

	/*
	 * �������
	 * 
	 * author��zhaosy
	 */
	public String deptEntry() {
		try {
			/*
			 * ��ȡ�����ֵ��й��ڵ�λ��,����ȡ����ֵ����session��
			 */
			String ssxt = "";
			if ("admin".equals(this.getUser().getUsername())
					|| "00".equals(this.getSysDept().getDepttype()))// ϵͳ��ȫ����
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
			 * ��ȡĬ�������б�ҳ�����û���ɫȨ�ޣ�
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