/**
 * ������EntryResourceAction.java
 *
 * ���Struts2 Action
 * ���ܣ���Դ������ڡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-12  CFIT-PM   ��ʤ��         ����
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
	 * ����������Ϣ�ֶ� author��zhaosy
	 */
	private String message;
	/*
	 * ��������ֵ�Service����������ֶ�List
	 */
	@Resource
	private DmzdService dmzdservice;
	private List resource_typesc;

	/*
	 * ��Դ�������
	 * 
	 * author��zhaosy
	 */
	public String resourceEntry() throws Exception {

		try {
			/*
			 * ��ȡ�����ֵ��й�����Դ�ģ��Ƿ��ɾ����Դ����
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
