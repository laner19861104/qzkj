/************************************************************
 * ������QueryPermissionAction.java
 *
 * ���Struts2 Action
 * ���ܣ�Ȩ�޲�ѯ��
 * 
 *   Ver     �����               Ȩ��            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-30  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.permission.action;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.permission.service.PermissionService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class QueryPermissionAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * ������� Service
	 */
	@Resource
	private PermissionService dservice;
	/*
	 * ��ѯ�б�ʹ�ã� 1>ps����ѯ�����ࣻ 2>pageId����ҳ�ж��ֶΣ� 3>hql��hibernate��ѯ��sql author��zhaosy
	 */
	private PaginationSupport ps;
	private String hql = "";
	/*
	 * ����������Ϣ�ֶ� author��zhaosy
	 */
	private String message;

	/*
	 * ��ѯ����
	 */
	private String qpermissionname = "";

	/*
	 * ��ѯ
	 * 
	 * author��zhaosy
	 */
	public void query() {
		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		int row = Integer.parseInt(this.getRequest().getParameter("rows"));// ���ܲ���page��rows

		/*
		 * ��������ȡ�����б�
		 */
		try {
			hql = " where 1=1 ";
			if (!(this.getQpermissionname() == null || "".equals(this
					.getQpermissionname())))
				hql = hql
						+ " and permissionName like '%"
						+ URLDecoder.decode(URLDecoder.decode(this
								.getQpermissionname(), "utf-8"), "utf-8")
						+ "%'";

			hql = hql + " order by permissionno";

			ps = dservice.findPageByQuery(hql, hql, row, (page - 1) * row);
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps
					.getTotalCount(), ps.getItems()), this.getResponse());
		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);
		}
	}

	public PermissionService getDservice() {
		return dservice;
	}

	public void setDservice(PermissionService dservice) {
		this.dservice = dservice;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
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

}
