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
package com.bip.sys.user.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.SqlUtil;
import com.bip.common.util.UniContant;
import com.bip.sys.user.po.SysUserroles;
import com.bip.sys.user.po.SysUserrolesId;
import com.bip.sys.user.service.UserRoleService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EditUserRoleAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * ������� Service
	 */
	@Resource
	private UserRoleService userroleservice;
	// private PermissionService pservice;

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
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysUserroles addpo = new SysUserroles();
			SysUserroles po = (SysUserroles) sqlUtil.getObjByMap(map, addpo);

			String userid = this.getRequest().getParameter("userid");
			String roleid = this.getRequest().getParameter("roleid");

			SysUserrolesId suid = new SysUserrolesId();
			suid.setUserid(Integer.parseInt(userid));
			suid.setRoleid(Integer.parseInt(roleid));
			po.setId(suid);

			Serializable a = userroleservice.save(po);

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
			userroleservice.delete("", " (userid,roleid) in (" + ids + ")");
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}
	}

	public UserRoleService getUserroleservice() {
		return userroleservice;
	}

	public void setUserroleservice(UserRoleService userroleservice) {
		this.userroleservice = userroleservice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
