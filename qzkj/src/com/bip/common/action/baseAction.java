package com.bip.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.user.po.SysUsers;
import com.opensymphony.xwork2.ActionSupport;

public class baseAction extends ActionSupport{
	public HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}
	public HttpServletResponse getResponse()
	{
		 return ServletActionContext.getResponse();
	} 
	public HttpSession getSession()
	{
		return this.getRequest().getSession();
	}
	public SysDepartment getSysDept()
	{
		return (SysDepartment) getSession().getAttribute("sysdept");
	}
	public SysUsers getUser()
	{
		return  (SysUsers) getSession().getAttribute("sysuser");
	}
}
