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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.Tool;
import com.bip.sys.codediction.dmzd.service.DmzdService;
import com.bip.sys.resource.service.ResourceService;
import com.opensymphony.xwork2.ActionSupport; //ģ���
@Controller
public class LoginLeftAction extends baseAction {
	/*
	 * ���峣��������
	 */
	@Resource
	private ResourceService resservice;

	public ResourceService getResservice() {
		return resservice;
	}

	public void setResservice(ResourceService resservice) {
		this.resservice = resservice;
	}

	private static final long serialVersionUID = 1L;
	private String message = "";
	/*
	 * ҳ�渳ֵ
	 */
	private String resourceid;

	public String loginLeft() {
		try {
			resourceid = this.getRequest().getParameter("resourceid");
			List list=this.resservice.getRsourceListByResPid(resourceid,super.getUser().getUserid());
			String str="";
			for(int i=0;i<list.size();i++)
			{
				if(i==0)
				{
					str=JSONObject.fromObject(list.get(i)).toString();
				}else
				{
					str+=","+JSONObject.fromObject(list.get(i)).toString();
				}
			}
			
			
			this.getRequest().setAttribute("treeList",str);
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

}
