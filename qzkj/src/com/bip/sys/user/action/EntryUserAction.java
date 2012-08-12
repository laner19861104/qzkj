/**
 * 类名：EntryUserAction.java
 *
 * 类别：Struts2 Action
 * 功能：用户管理入口，实现管理中心用户和企业用户的管理入口。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-12  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */

package com.bip.sys.user.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.UniContant;
import com.bip.sys.codediction.dmzd.service.DmzdService;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.role.service.RoleService;
import com.bip.sys.user.po.SysUsers;
import com.bip.sys.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EntryUserAction extends baseAction {

	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private UserService uservice;
	@Resource
	private DmzdService dmzdservice;// 代码字典
	@Resource
	private RoleService rservice;// 角色

	/*
	 * 页面赋值
	 */
	private String message;

	private List user_postprivsc;
	private List user_sexsc;
	private List user_hidebirthsc;
	private List user_hidemobilesc;
	private List user_smsonsc;
	private List user_statesc;
	private List user_regionsc;
	private List user_dutytypesc;
	private List user_typesc;

	private List rolelist;
	private List ccpqlist;
	private String username;
	private String curpassword;
	private SysUsers sysuser;
	/*
	 * 用户入口
	 * 
	 * author：zhaosy
	 */
	public String userEntry() {

		try {
			/*
			 * 读取数据字典中关于用户的
			 */
			List rlist = dmzdservice.findUserSc();
			if (rlist == null || rlist.size() < 7) {
				this.setMessage(UniContant.dmzderror);
				return "failure";
			}
			user_postprivsc = (List) rlist.get(0);
			user_sexsc = (List) rlist.get(1);
			user_hidebirthsc = (List) rlist.get(2);
			user_hidemobilesc = (List) rlist.get(3);
			user_smsonsc = (List) rlist.get(4);
			user_statesc = (List) rlist.get(5);
			user_regionsc = (List) rlist.get(6);
			user_dutytypesc = (List) rlist.get(7);
			user_typesc = (List) rlist.get(8);

			this.getSession().setAttribute("user_postprivsc", user_postprivsc);
			this.getSession().setAttribute("user_sexsc", user_sexsc);
			this.getSession().setAttribute("user_hidebirthsc", user_hidebirthsc);
			this.getSession().setAttribute("user_hidemobilesc", user_hidemobilesc);
			this.getSession().setAttribute("user_smsonsc", user_smsonsc);
			this.getSession().setAttribute("user_statesc", user_statesc);
			this.getSession().setAttribute("user_regionsc", user_regionsc);
			this.getSession().setAttribute("user_dutytypesc", user_dutytypesc);
			this.getSession().setAttribute("user_typesc", user_typesc);
			/*
			 * 获取部门机构信息、角色信息
			 */
			String dsql = "";
			if ("admin".equals(this.getUser().getUsername()))// 人行 公司
			{
				dsql = " where 1=1 ";

			} else {
				dsql = " where deptno like '" + (this.getSysDept().getDeptno()) + "%'";
			}

			rolelist = rservice.find(dsql + " and rolename not like '超级管理员%'");
			this.getSession().setAttribute("rolelist", rolelist);
			/*
			 * 读取默认数据列表页（按用户角色权限）
			 */

			return "success";
		} catch (Exception ex) {
			this.setMessage(UniContant.connerror);
			return "failure";
		}
	}

	/**
	 * 根据机构代码获取评级人员表中的机构下的评级人员
	 */
//	public void getResList() {
//		try {
//			String deptno = request.getParameter("deptno");
//			ccpqlist = ccpqualService
//					.find(" where 1=1 and startmark='0' and cccode like '"
//							+ deptno + "%'");
//			session.setAttribute("ccpqlist", ccpqlist);
//			String jsonstr = "[" + this.getjsonStr(ccpqlist) + "]";
////			System.out.println("jsonstr is " + jsonstr);
//			ControllerUtil.responseWriter(jsonstr, response);
//		} catch (Exception ex) {
//			ControllerUtil.responseWriter(null, response);
//		}
//	}

//	/**
//	 * 将评级人员组成tree
//	 * 
//	 * @param ccpqlist
//	 * @return
//	 */
//	private String getjsonStr(List ccpqlist) {
//		String str = "";
//		for (int i = 0; i < ccpqlist.size(); i++) {
//			JocCcpqual jc = (JocCcpqual) ccpqlist.get(i);
//			if (i == 0) {
//				str += "{\"id\":\"" + jc.getCcpqcode() + "\",\"text\":\""
//						+ jc.getCcpqname() + "\"}";
//			} else {
//				str += ",{\"id\":\"" + jc.getCcpqcode() + "\",\"text\":\""
//						+ jc.getCcpqname() + "\"}";
//			}
//		}
//		return str;
//	}

	/*
	 * 用户密码修改入口
	 * 
	 * author：zhaosy
	 */
	public String upPwdEntry() {

		sysuser = (SysUsers) this.getSession().getAttribute("sysuser");
		username = sysuser.getUsername();
		curpassword=sysuser.getPassword();
		return "success";
	}

	public UserService getUservice() {
		return uservice;
	}

	public void setUservice(UserService uservice) {
		this.uservice = uservice;
	}

	public DmzdService getDmzdservice() {
		return dmzdservice;
	}

	public void setDmzdservice(DmzdService dmzdservice) {
		this.dmzdservice = dmzdservice;
	}

	public RoleService getRservice() {
		return rservice;
	}

	public void setRservice(RoleService rservice) {
		this.rservice = rservice;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List getUser_postprivsc() {
		return user_postprivsc;
	}

	public void setUser_postprivsc(List userPostprivsc) {
		user_postprivsc = userPostprivsc;
	}

	public List getUser_sexsc() {
		return user_sexsc;
	}

	public void setUser_sexsc(List userSexsc) {
		user_sexsc = userSexsc;
	}

	public List getUser_hidebirthsc() {
		return user_hidebirthsc;
	}

	public void setUser_hidebirthsc(List userHidebirthsc) {
		user_hidebirthsc = userHidebirthsc;
	}

	public List getUser_hidemobilesc() {
		return user_hidemobilesc;
	}

	public void setUser_hidemobilesc(List userHidemobilesc) {
		user_hidemobilesc = userHidemobilesc;
	}

	public List getUser_smsonsc() {
		return user_smsonsc;
	}

	public void setUser_smsonsc(List userSmsonsc) {
		user_smsonsc = userSmsonsc;
	}

	public List getUser_statesc() {
		return user_statesc;
	}

	public void setUser_statesc(List userStatesc) {
		user_statesc = userStatesc;
	}

	public List getUser_regionsc() {
		return user_regionsc;
	}

	public void setUser_regionsc(List userRegionsc) {
		user_regionsc = userRegionsc;
	}

	public List getRolelist() {
		return rolelist;
	}

	public void setRolelist(List rolelist) {
		this.rolelist = rolelist;
	}

	public List getCcpqlist() {
		return ccpqlist;
	}

	public void setCcpqlist(List ccpqlist) {
		this.ccpqlist = ccpqlist;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List getUser_dutytypesc() {
		return user_dutytypesc;
	}

	public void setUser_dutytypesc(List user_dutytypesc) {
		this.user_dutytypesc = user_dutytypesc;
	}

	public List getUser_typesc() {
		return user_typesc;
	}

	public void setUser_typesc(List user_typesc) {
		this.user_typesc = user_typesc;
	}

	public String getCurpassword() {
		return curpassword;
	}

	public void setCurpassword(String curpassword) {
		this.curpassword = curpassword;
	}

}
