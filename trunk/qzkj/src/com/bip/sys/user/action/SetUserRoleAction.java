/************************************************************
 * 类名：EditUserAction.java
 *
 * 类别：Struts2 Action
 * 功能：用户新增、修改、删除。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-30  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.user.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.role.service.RoleService;
import com.bip.sys.user.po.SysUserroles;
import com.bip.sys.user.po.SysUserrolesId;
import com.bip.sys.user.po.SysUsers;
import com.bip.sys.user.service.UserRoleService;
import com.bip.sys.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class SetUserRoleAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private UserService uservice;
	@Resource
	private UserRoleService urservice;
	@Resource
	private RoleService rservice;
	/*
	 * 查询列表使用： 1>ps：查询返回类； 2>pageId：首页判断字段； 3>hql：hibernate查询用sql author：zhaosy
	 */
	private PaginationSupport ps;
	private int pageId = 1;
	private String hql;
	private int startIndex = 0;
	/*
	 * 操作返回信息字段 author：zhaosy
	 */
	private String message;

	/*
	 * 查询条件
	 */
	private String qusername;
	private String qdeptid;
	private String quserxm;

	private List deptlist;
	private List urlist;
	private List rlist;
	private boolean flag;

	private String userid2;
	private String username2;

	/*
	 * 用户角色设置入口
	 * 
	 * author：zhaosy
	 */
	public String setentry() {

		deptlist = (List) this.getSession().getAttribute("deptlist");

		try {
			/*
			 * 用户角色设置入口
			 */
			userid2 = this.getRequest().getParameter("userid2");
			SysUsers curuser = (SysUsers) (uservice.find(" where userid="
					+ userid2)).get(0);
			username2 = curuser.getUsername();
			urlist = urservice.find(" where userid=" + userid2);
			this.getSession().setAttribute("urlist", urlist);
			rlist = rservice.find("");
			flag = true;

		} catch (Exception ex) {
			this.setMessage(UniContant.delerror);
			return "failure";
		}

		/*
		 * 查询
		 */
		if ("01".equals(this.getSysDept().getDepttype()))// 人行 公司
		{
			hql = " where 1=1 ";
		} else if ("02".equals(this.getSysDept().getDepttype()))// 评级 公司
		{
			hql = " where deptid like '" + (this.getSysDept().getDeptno()) + "%'";
		}
		if (this.getPageId() == 0) {
			if (!("%".equals(this.getQdeptid()) || "".equals(this.getQdeptid()) || null == this
					.getQdeptid()))
				hql = hql + " and  deptid =" + this.getQdeptid();
			if (!(this.getQusername() == null || "".equals(this.getQusername())))
				hql = hql + " and username like '%" + this.getQusername()
						+ "%'";
			if (!(this.getQuserxm() == null || "".equals(this.getQuserxm())))
				hql = hql + " and userxm like '" + this.getQuserxm() + "%'";
			hql = hql + " order by userid";
		} else
			hql = this.getHql();
		ps = uservice.findPageByQuery(hql, hql, UniContant.pageSize, this
				.getStartIndex());
		if (ps.getItems().size() == 0 && this.getStartIndex() != 0) {
			ps = uservice.findPageByQuery(hql, hql, UniContant.pageSize, this
					.getStartIndex()
					- UniContant.pageSize);
		}
		return "success";
	}

	/*
	 * 用户角色设置
	 * 
	 * author：zhaosy
	 */
	public String set() {

		deptlist = (List) this.getSession().getAttribute("deptlist");

		try {
			userid2 = this.getRequest().getParameter("userid2");
			/*
			 * 读取list
			 */
			SysUserrolesId surid = new SysUserrolesId();
			SysUserroles sur = new SysUserroles();
			surid.setUserid(Integer.parseInt(userid2));

			String[] checklist = this.getRequest().getParameterValues("checkid2");
			urservice.delete("", " userid=" + userid2);
			if (checklist != null) {
				for (int i = 0; i < checklist.length; i++) {
					/*
					 * 设置权限
					 */
					if (checklist[i] != null || !"".equals(checklist[i])) {
						surid.setRoleid(Integer.parseInt(checklist[i]));
						sur.setId(surid);
						urservice.save(sur);
					}
				}
			}
			flag = false;

		} catch (Exception ex) {
			this.setMessage(UniContant.delerror);
			return "failure";
		}

		/*
		 * 查询
		 */
		if ("01".equals(this.getSysDept().getDepttype()))// 人行 公司
		{
			hql = " where 1=1 ";
		} else if ("02".equals(this.getSysDept().getDepttype()))// 评级 公司
		{
			if (this.getSysDept().getDeptno().length() > 2) {
				hql = " where deptid like '"
						+ (this.getSysDept().getDeptno()).substring(0, 2) + "%'";
			} else
				hql = " where deptid like '" + (this.getSysDept().getDeptno()) + "%'";
		}
		if (this.getPageId() == 0) {
			if (!("%".equals(this.getQdeptid()) || "".equals(this.getQdeptid()) || null == this
					.getQdeptid()))
				hql = hql + " and  deptid =" + this.getQdeptid();
			if (!(this.getQusername() == null || "".equals(this.getQusername())))
				hql = hql + " and username like '%" + this.getQusername()
						+ "%'";
			if (!(this.getQuserxm() == null || "".equals(this.getQuserxm())))
				hql = hql + " and userxm like '" + this.getQuserxm() + "%'";
			hql = hql + " order by userid";
		} else
			hql = this.getHql();
		ps = uservice.findPageByQuery(hql, hql, UniContant.pageSize, this
				.getStartIndex());
		if (ps.getItems().size() == 0 && this.getStartIndex() != 0) {
			ps = uservice.findPageByQuery(hql, hql, UniContant.pageSize, this
					.getStartIndex()
					- UniContant.pageSize);
		}
		return "success";
	}

	/*
	 * 用户角色设置
	 * 
	 * author：zhaosy
	 */
	public String cancelset() {

		deptlist = (List) this.getSession().getAttribute("deptlist");

		try {
			flag = false;

		} catch (Exception ex) {
			this.setMessage(UniContant.delerror);
			return "failure";
		}

		/*
		 * 查询
		 */
		if ("01".equals(this.getSysDept().getDepttype()))// 人行 公司
		{
			hql = " where 1=1 ";
		} else if ("02".equals(this.getSysDept().getDepttype()))// 评级 公司
		{
			if (this.getSysDept().getDeptno().length() > 2) {
				hql = " where deptid like '"
						+ (this.getSysDept().getDeptno()).substring(0, 2) + "%'";
			} else
				hql = " where deptid like '" + (this.getSysDept().getDeptno()) + "%'";
		}
		if (this.getPageId() == 0) {
			if (!("%".equals(this.getQdeptid()) || "".equals(this.getQdeptid()) || null == this
					.getQdeptid()))
				hql = hql + " and  deptid =" + this.getQdeptid();
			if (!(this.getQusername() == null || "".equals(this.getQusername())))
				hql = hql + " and username like '%" + this.getQusername()
						+ "%'";
			if (!(this.getQuserxm() == null || "".equals(this.getQuserxm())))
				hql = hql + " and userxm like '" + this.getQuserxm() + "%'";
			hql = hql + " order by userid";
		} else
			hql = this.getHql();
		ps = uservice.findPageByQuery(hql, hql, UniContant.pageSize, this
				.getStartIndex());
		if (ps.getItems().size() == 0 && this.getStartIndex() != 0) {
			ps = uservice.findPageByQuery(hql, hql, UniContant.pageSize, this
					.getStartIndex()
					- UniContant.pageSize);
		}
		return "success";
	}

	public UserService getUservice() {
		return uservice;
	}

	public void setUservice(UserService uservice) {
		this.uservice = uservice;
	}

	public UserRoleService getUrservice() {
		return urservice;
	}

	public void setUrservice(UserRoleService urservice) {
		this.urservice = urservice;
	}

	public RoleService getRservice() {
		return rservice;
	}

	public void setRservice(RoleService rservice) {
		this.rservice = rservice;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getQusername() {
		return qusername;
	}

	public void setQusername(String qusername) {
		this.qusername = qusername;
	}

	public String getQdeptid() {
		return qdeptid;
	}

	public void setQdeptid(String qdeptid) {
		this.qdeptid = qdeptid;
	}

	public String getQuserxm() {
		return quserxm;
	}

	public void setQuserxm(String quserxm) {
		this.quserxm = quserxm;
	}

	public List getDeptlist() {
		return deptlist;
	}

	public void setDeptlist(List deptlist) {
		this.deptlist = deptlist;
	}

	public List getUrlist() {
		return urlist;
	}

	public void setUrlist(List urlist) {
		this.urlist = urlist;
	}

	public List getRlist() {
		return rlist;
	}

	public void setRlist(List rlist) {
		this.rlist = rlist;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getUserid2() {
		return userid2;
	}

	public void setUserid2(String userid2) {
		this.userid2 = userid2;
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String username2) {
		this.username2 = username2;
	}

}
