/**
 * ������LoginAction.java
 *
 * ���Struts2 Action
 * ���ܣ���¼��ʵ�ֹ����û��ĵ�¼��
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-12  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.login.action;

import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport; //ģ���
import com.bip.common.action.baseAction;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.dept.service.DeptService;
import com.bip.sys.login.service.ViewLoginService;
import com.bip.sys.resource.po.SysResource;
import com.bip.sys.resource.service.ResourceService;
import com.bip.sys.user.po.SysUsers;
import com.bip.sys.user.service.UserService;
@Controller
public class LoginAction extends baseAction {
	/*
	 * ���峣��������
	 */
	private static final long serialVersionUID = 1L;
	private String message = "";
	private String username = "";
	private String password = "";
	private String verifycode="";
	private SysUsers sysuser;
	private SysDepartment sysdept;
	private List reslist = null;
	/*
	 * ����service
	 */
	@Resource
	private UserService us;// �û�
	@Resource
	private DeptService dservice;// ��������
	@Resource
	private ResourceService resservice;// ��Դ
	@Resource
	private ViewLoginService viewloginservice;//��¼Ȩ����Դ

	/*
	 * �ֶ�У��
	 */
	public void validate() {

	}

	/*
	 * �����û���¼
	 * 
	 * 1>�жϺϷ�2>�û�Ȩ���ж��������˵�
	 */
	public String adminlogin() {
		String msgverifycode=(String)this.getSession().getAttribute("verifyCode");
		/*
		 * ������е�session
		 */
		Enumeration e = this.getSession().getAttributeNames();
		while (e.hasMoreElements()) {
			String sessionName = (String) e.nextElement();
			this.getSession().removeAttribute(sessionName);
		}
        
		if ("".equals(this.getUsername()) || "".equals(this.getPassword())) {
			setMessage("�û��������벻��Ϊ�գ������룡");
			return "failure";
		}
		
		if(this.getVerifycode()==null||!this.getVerifycode().equalsIgnoreCase(msgverifycode))
		{
			setMessage("��֤��������������룡");
			return "failure";
		}
		try {
			// ---�ж��û���������ȷ
			if (!us.validate(username, password)) {
				setMessage("�û�������������������룡");
				return "failure";
			}
		} catch (Exception ex) {
			setMessage("���ݿ��޷��������ӣ���鿴���ݿ��Ƿ������ã�");
			ex.printStackTrace();
			return "failure";
		}

		try {
			// ---����Ȩ�޶�ȡ��������ʾ�˵�
			sysuser = us.getUserByUserName(username);
			sysdept = dservice.getByNo(sysuser.getDeptid());
			
			// ---����ϵͳ���ò����Ķ�ȡ��������session�С�
			this.getSession().setAttribute("sysuser", sysuser);
			this.getSession().setAttribute("sysdept", sysdept);
//			reslist = resservice.findResource(sysuser.getUserid());
			
			reslist=viewloginservice.findByUserid(sysuser.getUserid());
			String resourceId = getFirstResourceId(reslist);
			this.getSession().setAttribute("resourceId", resourceId);
			this.getSession().setAttribute("reslist", reslist);
			
			this.getSession().setAttribute("reslist", reslist);
			return "success";
		} catch (Exception ex) {
			setMessage("�û���Ϣ���󣬵�½ʧ�ܣ�����ϵ����Ա�������û���Ϣ��");
			ex.printStackTrace();
			return "failure";
		}
	}

	private String getFirstResourceId(List<SysResource> list){
		String resourceId = "";
		for(SysResource rs:list){
			if("0".equals(rs.getPresourceno()));
			resourceId = rs.getResourceno();
			break;
		}
		return resourceId;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username.trim();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password.trim();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SysUsers getSysuser() {
		return sysuser;
	}

	public void setSysuser(SysUsers sysuser) {
		this.sysuser = sysuser;
	}

	public SysDepartment getSysdept() {
		return sysdept;
	}

	public void setSysdept(SysDepartment sysdept) {
		this.sysdept = sysdept;
	}

	public List getReslist() {
		return reslist;
	}

	public void setReslist(List reslist) {
		this.reslist = reslist;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public DeptService getDservice() {
		return dservice;
	}

	public void setDservice(DeptService dservice) {
		this.dservice = dservice;
	}

	public ResourceService getResservice() {
		return resservice;
	}

	public void setResservice(ResourceService resservice) {
		this.resservice = resservice;
	}

	public ViewLoginService getViewloginservice() {
		return viewloginservice;
	}

	public void setViewloginservice(ViewLoginService viewloginservice) {
		this.viewloginservice = viewloginservice;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

}
