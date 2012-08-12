/**
 * ������EditResourceAction.java
 *
 * ���Struts2 Action
 * ���ܣ���Դ�������޸ġ�ɾ����
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-30  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.resource.action;

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

import com.opensymphony.xwork2.ActionSupport;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.SqlUtil;
import com.bip.common.util.UniContant;
import com.bip.common.util.idinfo.service.IdInfoService;
import com.bip.common.util.idinfo.service.PairValue;
import com.bip.common.util.idinfo.serviceimpl.IdInfoServiceImpl;
import com.bip.sys.resource.po.SysResource;
import com.bip.sys.resource.service.ResourceService;
@Controller
public class EditResourceAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * ������� Service
	 */
	@Resource
	private ResourceService rservice;

	/*
	 * ����������Ϣ�ֶ� author��zhaosy
	 */
	private String message;
	@Resource
	private IdInfoService idService;

	/*
	 * ��Դ��ѯ
	 * 
	 * author��zhaosy
	 */
	public void add() {

		/*
		 * ������Դ
		 */
		try {
			/*
			 * ��ҳ��ֵת����po����
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysResource addpo = new SysResource();
			SysResource po = (SysResource) sqlUtil.getObjByMap(map, addpo);

			/*
			 * �ж��Ƿ�����ظ���¼
			 */
			List existl = rservice.find(" where resourceno='"
					+ po.getResourceno() + "'");
			if (existl != null) {
				if (existl.size() != 0) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(
							false, UniContant.existerror), this.getResponse());
					return;
				}
			}
			/*
			 * ȡ���ݱ�������Ҫ������ID
			 */
			PairValue pv = idService.getIDs("sys_resource", "resourceid", 1);
			long id = pv.max;
			po.setResourceid(Integer.parseInt(String.valueOf(id)));
			/*
			 * ִ�����ݿ�д������������ݷ���ֵ���гɹ���ʧ�ܴ���
			 */

			Serializable a = rservice.save(po);

			if ((Integer) a == po.getResourceid()) {
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
			SysResource addpo = new SysResource();
			SysResource po = (SysResource) sqlUtil.getObjByMap(map, addpo);

			rservice.update(po);
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
			// String[] idlist = Tool.explode(",", ids);
			// for (int i = 0; i < idlist.length; i++) {
			// String id = (String) idlist[i];
			// rservice.delete("", " resourceid=" + id + "");
			// }
			rservice.delete("", " resourceid in (" + ids + ")");
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}
	}

	public ResourceService getRservice() {
		return rservice;
	}

	public void setRservice(ResourceService rservice) {
		this.rservice = rservice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IdInfoService getIdService() {
		return idService;
	}

	public void setIdService(IdInfoService idService) {
		this.idService = idService;
	}

}
