/************************************************************
 * ������EditRoleAction.java
 *
 * ���Struts2 Action
 * ���ܣ�Ȩ���������޸ġ�ɾ����
 * 
 *   Ver     �����               Ȩ��            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-30  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.role.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.UniContant;
import com.bip.common.util.Replace;
import com.bip.sys.permission.po.SysPermission;
import com.bip.sys.permission.service.PermissionService;
import com.bip.sys.role.po.SysRolepermission;
import com.bip.sys.role.po.SysRolepermissionId;
import com.bip.sys.role.service.RolePermissionService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class EditRolepermissionAction extends baseAction {
	/*
	 * ���峣������
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ������� Service
	 */
	@Resource
	private RolePermissionService rpservice;
	@Resource
	private PermissionService pservice;

	/*
	 * ����������Ϣ�ֶ� author��zhaosy
	 */
	private String message;

	/*
	 * ����
	 * 
	 * author��zhaosy
	 */
	public void add() {
		/******
		 * ����
		 ******/
		try {
			/*
			 * ��ҳ��ֵת����po����
			 */
			String roleid = this.getRequest().getParameter("roleid");// ��ȡ��ɫ���
			String permissionidsc = this.getRequest().getParameter("permissionidsc");// ��ȡȨ�ޱ��

			if (permissionidsc == null || "".equals(permissionidsc)) {
				ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
						UniContant.adderror), this.getResponse());
				return;
			}
			/*
			 * �����ɫȨ��PO
			 */
			SysRolepermissionId srpid = new SysRolepermissionId();
			SysRolepermission srp = new SysRolepermission();
			/*
			 * ִ�����ݿ�д������������ݷ���ֵ���гɹ���ʧ�ܴ���
			 */
			/*
			 * ɾ����ɫ��ӦȨ��
			 */
			rpservice.delete("", " roleid="+roleid);
			/*
			 * ������ӽ�ɫ��ӦȨ��
			 */
			List plist = new ArrayList();
			plist = Replace.replaceStringToList(permissionidsc);
			for (int i = 0; i < plist.size(); i++) {
				String pno = (String) plist.get(i);
				SysPermission sp = pservice.findBySql(" where permissionno ='"
						+ pno + "'");
				srpid.setRoleid(Integer.parseInt(roleid));
				srpid.setPermissionid(sp.getPermissionid());
				srp.setId(srpid);
				rpservice.save(srp);
			}

			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.addok), this.getResponse());
			return;

		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.adderror), this.getResponse());
			return;
		}
	}

	/*
	 * ɾ��
	 * 
	 * author��zhaosy
	 */
	public void del() {
		/*
		 * ɾ��
		 */
		try {
			/*
			 * ɾ������
			 */
			String ids = this.getRequest().getParameter("id");
			System.out.println("ids is " + ids);
			rpservice.delete("", " (roleid,permissionid) in (" + ids + ")");
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}
	}

	public RolePermissionService getRpservice() {
		return rpservice;
	}

	public void setRpservice(RolePermissionService rpservice) {
		this.rpservice = rpservice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PermissionService getPservice() {
		return pservice;
	}

	public void setPservice(PermissionService pservice) {
		this.pservice = pservice;
	}

}
