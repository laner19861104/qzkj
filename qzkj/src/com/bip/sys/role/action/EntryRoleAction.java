/**
 * ������EntryRoleAction.java
 *
 * ���Struts2 Action
 * ���ܣ���ɫ����ɫȨ�޹�����ڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-12  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */

package com.bip.sys.role.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.UniContant;
import com.bip.sys.codediction.dmzd.service.DmzdService;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.permission.service.PermissionService;
import com.bip.sys.user.po.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EntryRoleAction extends baseAction {

	
	private static final long serialVersionUID = 1L;
	
	/*
	 * ������� Service
	 */
	@Resource
	private DmzdService dmzdservice;
	@Resource
	private PermissionService pservice;

	/*
	 * ����������Ϣ�ֶ� author��zhaosy
	 */
	private String message;
	/*
	 * ��������ֵ�Service����������ֶ�List
	 */
	
	private List role_typesc;
	private List permissionlist;

	/*
	 * Ȩ�޹������
	 * 
	 * author��zhaosy
	 */
	public String roleEntry() throws Exception {
		/*
		 * ��ȡ�����ֵ��й��ڽ�ɫ�ļ�¼����ɫ����
		 */
		try {
			String ssxt = "";
			if ("admin".equals(this.getUser().getUsername())
					|| "00".equals(this.getSysDept().getDepttype()))// ϵͳ��ȫ����
			{
				ssxt = " and (ssxt is null or ssxt like '%')";
			} else {
				ssxt = " and (ssxt is null or ssxt=''  or ssxt='00' or ssxt='"
						+ this.getSysDept().getDepttype() + "')";
			}
			List rlist = dmzdservice.findRoleSc(ssxt);
			if (rlist == null || rlist.size() < 1) {
				this.setMessage(UniContant.dmzderror);
				return "failure";
			}
			role_typesc = (List) rlist.get(0);
			this.getSession().setAttribute("role_typesc", role_typesc);
			this.getSession().setAttribute("permissionlist", permissionlist);
			return "success";
		} catch (Exception ex) {
			this.setMessage(UniContant.connerror);
			return "failure";
		}
	}

	public PermissionService getPservice() {
		return pservice;
	}

	public void setPservice(PermissionService pservice) {
		this.pservice = pservice;
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

	public List getRole_typesc() {
		return role_typesc;
	}

	public void setRole_typesc(List roleTypesc) {
		role_typesc = roleTypesc;
	}

	public List getPermissionlist() {
		return permissionlist;
	}

	public void setPermissionlist(List permissionlist) {
		this.permissionlist = permissionlist;
	}

}
