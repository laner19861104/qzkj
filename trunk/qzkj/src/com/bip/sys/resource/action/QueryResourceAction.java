/************************************************************
 * 类名：QueryResourceAction.java
 *
 * 类别：Struts2 Action
 * 功能：资源查询。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-30  CFIT-PM   赵胜运         初版
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
	 * 定义操作 Service
	 */
	@Resource
	private ResourceService rservice;
	/*
	 * 查询列表使用： 1>ps：查询返回类； 2>pageId：首页判断字段； 3>hql：hibernate查询用sql author：zhaosy
	 */
	private PaginationSupport ps;
	private String hql = "";
	/*
	 * 操作返回信息字段 author：zhaosy
	 */
	private String message;

	/*
	 * 查询条件
	 */
	private String qresourcename = "";
	private String qtype = "";

	/*
	 * 资源查询
	 * 
	 * author：zhaosy
	 */
	public void query() {
		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		int row = Integer.parseInt(this.getRequest().getParameter("rows"));// 接受参数page和rows

		/*
		 * 按条件读取数据列表
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
	 * 资源查询,返回查询json串
	 * 
	 * author：zhaosy
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
