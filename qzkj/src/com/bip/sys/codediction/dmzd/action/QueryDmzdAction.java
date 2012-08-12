/************************************************************
 * ������QueryDmzdAction.java
 *
 * ���Struts2 Action
 * ���ܣ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2011-6-17  CFIT-PM    ��ʤ��               ����
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.codediction.dmzd.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.codediction.dmzd.service.DmzdService;
@Controller
public class QueryDmzdAction extends baseAction {
	/*
	 * ����Service
	 */
	@Resource
	private DmzdService dmzdService;
	private PaginationSupport ps;

	/*
	 * ҳ��
	 */
	private String message;

	/**
	 * ��ѯ
	 */
	public void query() {
		try {
			
			String lbbh = this.getRequest().getParameter("lbbh");
			int page = Integer.parseInt(this.getRequest().getParameter("page"));
			int row = Integer.parseInt(this.getRequest().getParameter("rows"));// ���ܲ���page��rows

			String hql = " where lbbh like '" + lbbh + "'";

			hql += " order by lbbh,bh,sjbh";
			ps = dmzdService.findPageByQuery(hql, hql, row, (page - 1) * row);
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps
					.getTotalCount(), ps.getItems()), this.getResponse());
		} catch (Exception ex) {
			this.setMessage(UniContant.connerror);
		}
	}

	public DmzdService getDmzdService() {
		return dmzdService;
	}

	public void setDmzdService(DmzdService dmzdService) {
		this.dmzdService = dmzdService;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
