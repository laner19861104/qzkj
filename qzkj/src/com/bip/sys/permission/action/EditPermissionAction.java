/************************************************************
 * ������EditPermissionAction.java
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
package com.bip.sys.permission.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

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

import com.bip.common.util.idinfo.service.IdInfoService;
import com.bip.common.util.idinfo.service.PairValue;
import com.bip.common.util.idinfo.serviceimpl.IdInfoServiceImpl;
import com.bip.sys.permission.po.SysPermission;
import com.bip.sys.permission.service.PermissionService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EditPermissionAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * ������� Service
	 */
	@Resource
	private PermissionService dservice;
	@Resource
	private IdInfoService idService;

	/*
	 * ����������Ϣ�ֶ� author��zhaosy
	 */
	private String message;

	/*
	 * ��ѯ����
	 */
	private String qpermissionname = "";

	


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
			SysPermission addpo = new SysPermission();
			SysPermission po = (SysPermission) sqlUtil.getObjByMap(map, addpo);
			
			/*
			 * �ж��Ƿ�����ظ���¼
			 */
			List existl = dservice.find(" where permissionno='"
					+ po.getPermissionno() + "'");
			if (existl != null) {
				if (existl.size() != 0) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
							UniContant.existerror), this.getResponse());
					return;
				}
			}
			/*
			 * ȡ���ݱ�������Ҫ������ID
			 */
			PairValue pv = idService
					.getIDs("sys_permission", "permissionid", 1);
			long id = pv.max;
			po.setPermissionid(Integer.parseInt(String.valueOf(id)));
			/*
			 * ִ�����ݿ�д������������ݷ���ֵ���гɹ���ʧ�ܴ���
			 */

			Serializable a = dservice.save(po);
			if ((Integer) a ==po.getPermissionid()) {
				ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
						UniContant.addok), this.getResponse());
				return;
			} else {
				ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
						UniContant.adderror), this.getResponse());
				return;
			}
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.adderror), this.getResponse());
			return;
		}
	}

	/*
	 * �޸�
	 * 
	 * author��zhaosy
	 */
	public void edit() {

		/******
		 * �޸�
		 ******/
		try {
			/*
			 * ��ҳ��ֵת����po����
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysPermission addpo = new SysPermission();
			SysPermission po = (SysPermission) sqlUtil.getObjByMap(map, addpo);

			dservice.update(po);
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.editok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.editerror), this.getResponse());
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
//			String[] idlist = Tool.explode(",", ids);
//			for (int i = 0; i < idlist.length; i++) {
//				String id = (String) idlist[i];
//				dservice.delete("", " permissionid=" + id + "");
//			}
			dservice.delete("", " permissionid in (" + ids + ")");
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return ;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}
	}

	public PermissionService getDservice() {
		return dservice;
	}

	public void setDservice(PermissionService dservice) {
		this.dservice = dservice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getQpermissionname() {
		return qpermissionname;
	}

	public void setQpermissionname(String qpermissionname) {
		this.qpermissionname = qpermissionname;
	}

	public IdInfoService getIdService() {
		return idService;
	}

	public void setIdService(IdInfoService idService) {
		this.idService = idService;
	}

}
