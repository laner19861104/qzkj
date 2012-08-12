/************************************************************
 * 类名：QueryEnterpriseAction.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2011-12-3  CFIT-PG   赵梅            初版
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.enterprise.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.QueryJson;
import com.bip.common.util.TotalJson;
import com.bip.common.util.UniContant;
import com.bip.sys.enterprise.po.SysEnterprise;
import com.bip.sys.enterprise.service.EnterpriseService;

import com.opensymphony.xwork2.ActionSupport;
@Controller
public class QueryEnterpriseAction extends baseAction {

	/*
	 * 定义service
	 */
	@Autowired
	private EnterpriseService enterpriseService;
	/*
	 * 页面
	 */
	private QueryJson queryJson;
	private SysEnterprise instance;



	/*
	 * 查询
	 */
	
	public String query() {
			
			
			int page = Integer.parseInt(this.getRequest().getParameter("page"));
			int row = Integer.parseInt(this.getRequest().getParameter("rows"));// 接受参数page和rows
			String congditions=this.getRequest().getParameter("conditions");
			if(congditions!=null)
				try {
					congditions=URLDecoder.decode(URLDecoder.decode(congditions, "utf-8"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			queryJson = enterpriseService.findPageByQuery(congditions, row, (page - 1)
					* row);
		return "success";
	}
	public String queryBySql() {
		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		int row = Integer.parseInt(this.getRequest().getParameter("rows"));// 接受参数page和rows
		String congditions=this.getRequest().getParameter("conditions");
		if(congditions!=null)
			try {
				congditions=URLDecoder.decode(URLDecoder.decode(congditions, "utf-8"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		queryJson = enterpriseService.findPageBySql(congditions, row, (page - 1)
				* row);
	return "success";
}
public String queryByHql() {
		
		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		int row = Integer.parseInt(this.getRequest().getParameter("rows"));// 接受参数page和rows
		String congditions=this.getRequest().getParameter("conditions");
		if(congditions!=null)
			try {
				congditions=URLDecoder.decode(URLDecoder.decode(congditions, "utf-8"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		queryJson = enterpriseService.findPageByHql(congditions, row, (page - 1)
				* row);
	return "success";
}	
	public String getObjById()
	{
		int id=Integer.parseInt(this.getRequest().getParameter("id"));
		instance=this.enterpriseService.getEnterpriseById(id);
		return "success";
	}
	
	
	public EnterpriseService getEnterpriseService() {
		return enterpriseService;
	}

	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}
	public SysEnterprise getInstance() {
		return instance;
	}
	public void setInstance(SysEnterprise instance) {
		this.instance = instance;
	}
	public QueryJson getQueryJson() {
		return queryJson;
	}
	public void setQueryJson(QueryJson queryJson) {
		this.queryJson = queryJson;
	}
}
