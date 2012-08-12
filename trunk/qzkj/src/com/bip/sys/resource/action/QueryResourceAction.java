/************************************************************
 * ������QueryResourceAction.java
 *
 * ���Struts2 Action
 * ���ܣ���Դ��ѯ��
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-30  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.resource.action;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.jqueryeasyui.JqueryUtil;
import com.bip.common.jqueryeasyui.TreeVo;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.resource.po.SysResource;
import com.bip.sys.resource.service.ResourceService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class QueryResourceAction extends baseAction {

	private static final long serialVersionUID = 1L;
	/*
	 * ������� Service
	 */
	@Resource
	private ResourceService rservice;
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
	private String qresourcename = "";
	private String qtype = "";

	/*
	 * ��Դ��ѯ
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

			if (!(this.getQtype() == null || "".equals(this.getQtype()) || "%"
					.equals(this.getQtype()))) {
				hql = hql + " and  (type like '" + this.getQtype() + "')";
			}

			if (!(this.getQresourcename() == null || "".equals(this
					.getQresourcename())))
				hql = hql
						+ " and resourcename like '%"
						+ URLDecoder.decode(URLDecoder.decode(this
								.getQresourcename(), "utf-8"), "utf-8") + "%'";
			hql = hql + " order by resourceno";

			ps = rservice.findPageByQuery(hql, hql, row, (page - 1) * row);
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps
					.getTotalCount(), ps.getItems()), this.getResponse());
		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);
		}
	}

	/*
	 * ��Դ��ѯ,���ز�ѯjson��
	 * 
	 * author��zhaosy
	 */
	public void queryResourceTree() {
		try {
			List resourcelist = rservice.find(" order by resourceno");
			SysResource respo = new SysResource();
			List restreelist = new ArrayList();

			for (int i = 0; i < resourcelist.size(); i++) {

				respo = (SysResource) resourcelist.get(i);
				TreeVo treevo = new TreeVo();
				treevo.setId(respo.getResourceno());
				treevo.setText(respo.getResourceno());
				treevo.setPid(respo.getPresourceno());

				restreelist.add(i, treevo);
			}

			String treejson = JqueryUtil.getComboTreeJson("0", restreelist);
			System.out.println("treejson is " + treejson);
			ControllerUtil.responseWriter("[" + treejson + "]", this.getResponse());

		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);

		}
	}

	public ResourceService getRservice() {
		return rservice;
	}

	public void setRservice(ResourceService rservice) {
		this.rservice = rservice;
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

	public String getQresourcename() {
		return qresourcename;
	}

	public void setQresourcename(String qresourcename) {
		this.qresourcename = qresourcename;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

}
