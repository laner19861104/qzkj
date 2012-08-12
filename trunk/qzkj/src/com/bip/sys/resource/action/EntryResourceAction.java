/**
 * 类名：EntryResourceAction.java
 *
 * 类别：Struts2 Action
 * 功能：资源管理入口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-12  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */

package com.bip.sys.resource.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.codediction.dmzd.service.DmzdService;
import com.bip.sys.resource.service.ResourceService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EntryResourceAction extends baseAction {

	
	private static final long serialVersionUID = 1L;

	/*
	 * 操作返回信息字段 author：zhaosy
	 */
	private String message;
	/*
	 * 定义代码字典Service，定义代码字段List
	 */
	@Resource
	private DmzdService dmzdservice;
	private List resource_typesc;

	/*
	 * 资源管理入口
	 * 
	 * author：zhaosy
	 */
	public String resourceEntry() throws Exception {

		try {
			/*
			 * 读取数据字典中关于资源的：是否可删、资源类型
			 */
			List rlist = dmzdservice.findResourceSc();
			if (rlist == null || rlist.size() < 1) {
				this.setMessage(UniContant.dmzderror);
				return "failure";
			}
			resource_typesc = (List) rlist.get(0);
			this.getSession().setAttribute("resource_typesc", resource_typesc);
			return "success";
		} catch (Exception ex) {
			ex.printStackTrace();
			this.setMessage(UniContant.queryerror);
			return "failure";
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DmzdService getDmzdservice() {
		return dmzdservice;
	}

	public void setDmzdservice(DmzdService dmzdservice) {
		this.dmzdservice = dmzdservice;
	}

	public List getResource_typesc() {
		return resource_typesc;
	}

	public void setResource_typesc(List resourceTypesc) {
		resource_typesc = resourceTypesc;
	}

}
