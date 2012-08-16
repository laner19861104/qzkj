/**
 * ������LoginLeftAction
 *
 * ���Struts2 Action
 * ���ܣ���¼��ʵ�ֹ����û��ĵ�¼��
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2011-11-26  CFIT-PM   syl         ����
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.login.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.sys.resource.service.ResourceService;
@Controller
public class LoginLeftAction extends baseAction {
	/*
	 * ���峣��������
	 */
	@Resource
	private ResourceService resservice;

	private static final long serialVersionUID = 1L;
	private String message = "";
	String treeListstr;
	/*
	 * ҳ�渳ֵ
	 */
	private String resourceid;

	public String loginLeft() {
		HttpServletRequest request = this.getRequest();
		HttpServletResponse response = this.getResponse();
		try {
			resourceid = request.getParameter("resourceid");//����ģ��ID
			List<Map> list=this.resservice.getRsourceListByResPid(resourceid, super.getUser().getUserid());
			String str="";
			if (null == list || 0 == list.size()) {
				request.setAttribute("treeList", "");
				return "success";
			}
			for (Map o : list) {
				str = str 
					+ "{id:\"" + o.get("id")
					+ "\", pId:\"" + o.get("pid") 
					+ "\", name:\"" + (null == o.get("name") ? "" :  o.get("name"))
					+ "\", icon:\"" + (null == o.get("icon") ? "" : o.get("icon"))
					+ "\", url:\"" + (null == o.get("url") ? "" : o.get("url"))
					+ "\", target:\"" + (null == o.get("target") ? "" : o.get("target"))
					+ "\"}, ";
			}
//			this.response.setHeader("Pragma", "no-cache");
//			this.response.setHeader("Cache-Control", "no-cache");
			treeListstr = str.substring(0, str.lastIndexOf(", "));
			request.setAttribute("treeListstr", treeListstr);
			System.out.println("json-str : " + treeListstr);
			return "success";
		} catch (Exception ex) {
			ex.printStackTrace();
			setMessage("����ת�������⣬��鿴�����Ƿ�Ϊ�գ�");
			return "failure";
		}
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public ResourceService getResservice() {
		return resservice;
	}

	public void setResservice(ResourceService resservice) {
		this.resservice = resservice;
	}
}
