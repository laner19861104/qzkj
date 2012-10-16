/************************************************************
 * 类名：QueryDmlbAction.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2011-6-17  CFIT-PM    赵胜运               初版
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.codediction.dmlb.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.iap.Response;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.codediction.dmlb.service.DmlbService;

@Controller
public class QueryDmlbAction extends baseAction {



	/*
	 * 定义Service
	 */
	@Resource
	private DmlbService dmlbService;
	private PaginationSupport ps;

	/*
	 * 页面
	 */
	private String message;

	/**
	 * 查询
	 */
	public void query() {
		try {
			int page = Integer.parseInt(this.getRequest().getParameter("page"));
			int row = Integer.parseInt(this.getRequest().getParameter("rows"));// 接受参数page和rows

			String hql = "where 1=1";
			hql += " order by lbbh";
			ps = dmlbService.findPageByQuery(hql, hql, row, (page - 1)
					* row);	
			System.out.println("json  is "+ControllerUtil.getJsonString(ps.getTotalCount(), ps.getItems()));
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps.getTotalCount(), ps.getItems()), this.getResponse());
		} catch (Exception ex) {
			this.setMessage(UniContant.connerror);
		}
	}

	public DmlbService getDmlbService() {
		return dmlbService;
	}

	public void setDmlbService(DmlbService dmlbService) {
		this.dmlbService = dmlbService;
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
