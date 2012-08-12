/**
 * ������EditDmzdAction.java
 *
 * ���Struts2 Action
 * ���ܣ��������༭��
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-12  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */

package com.bip.sys.codediction.dmlb.action;

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
import com.bip.sys.codediction.dmlb.po.SysDmlb;
import com.bip.sys.codediction.dmlb.service.DmlbService;
@Controller
public class EditDmlbAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * ����service
	 */
	@Resource
	private DmlbService dmlbService;
	@Resource
	private IdInfoService idService;

	/*
	 * ҳ�渳ֵ
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
			SysDmlb addpo = new SysDmlb();
			SysDmlb po = (SysDmlb) sqlUtil.getObjByMap(map, addpo);

			/*
			 * �ж��Ƿ�����ظ���¼
			 */
			List existl = dmlbService
					.find(" where lbbh='" + po.getLbbh() + "'");
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
			PairValue pv = idService.getIDs("sys_dmlb", "id", 1);
			long id = pv.max;
			po.setId(Integer.parseInt(String.valueOf(id)));
			/*
			 * ִ�����ݿ�д������������ݷ���ֵ���гɹ���ʧ�ܴ���
			 */

			Serializable a = dmlbService.save(po);
			if ((Integer) a == po.getId()) {
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
			SysDmlb addpo = new SysDmlb();
			SysDmlb po = (SysDmlb) sqlUtil.getObjByMap(map, addpo);
			/*
			 * ִ���޸����ݿ����
			 */

			dmlbService.update(po);
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
			dmlbService.delete("", " id in (" + ids + ")");
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}
	}

	public DmlbService getDmlbService() {
		return dmlbService;
	}

	public void setDmlbService(DmlbService dmlbService) {
		this.dmlbService = dmlbService;
	}

	public IdInfoService getIdService() {
		return idService;
	}

	public void setIdService(IdInfoService idService) {
		this.idService = idService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
