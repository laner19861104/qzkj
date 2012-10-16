/**
 * 类名：LoginAction.java
 *
 * 类别：Struts2 Action
 * 功能：登录，实现管理用户的登录。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-12  CFIT-PM   赵胜运         初版
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

import com.opensymphony.xwork2.ActionSupport; //模块包
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
	 * 定义常量及变量
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
	 * 定义service
	 */
	@Resource
	private UserService us;// 用户
	@Resource
	private DeptService dservice;// 机构部门
	@Resource
	private ResourceService resservice;// 资源
	@Resource
	private ViewLoginService viewloginservice;//登录权限资源

	/*
	 * 手动校验
	 */
	public void validate() {

	}

	/*
	 * 管理用户登录
	 * 
	 * 1>判断合法2>用户权限判定，关联菜单
	 */
	public String adminlogin() {
		String msgverifycode=(String)this.getSession().getAttribute("verifyCode");
		/*
		 * 清空所有的session
		 */
		Enumeration e = this.getSession().getAttributeNames();
		while (e.hasMoreElements()) {
			String sessionName = (String) e.nextElement();
			this.getSession().removeAttribute(sessionName);
		}
        
		if ("".equals(this.getUsername()) || "".equals(this.getPassword())) {
			setMessage("用户名、密码不能为空，请输入！");
			return "failure";
		}
		
		if(this.getVerifycode()==null||!this.getVerifycode().equalsIgnoreCase(msgverifycode))
		{
			setMessage("验证码错误，请重新输入！");
			return "failure";
		}
		try {
			// ---判断用户、密码正确
			if (!us.validate(username, password)) {
				setMessage("用户名密码错误，请重新输入！");
				return "failure";
			}
		} catch (Exception ex) {
			setMessage("数据库无法建立连接，请查看数据库是否已启用！");
			ex.printStackTrace();
			return "failure";
		}

		try {
			// ---进行权限读取，设置显示菜单
			sysuser = us.getUserByUserName(username);
			sysdept = dservice.getByNo(sysuser.getDeptid());
			
			// ---进行系统公用参数的读取，并导入session中。
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
			setMessage("用户信息错误，登陆失败！请联系管理员修正此用户信息！");
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
