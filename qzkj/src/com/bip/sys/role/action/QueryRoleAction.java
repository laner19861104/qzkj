/************************************************************
 * ������QueryRoleAction.java
 *
 * ���Struts2 Action
 * ���ܣ���ɫ��ѯ��
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-30  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.role.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.role.service.RoleService;
import com.bip.sys.user.po.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class QueryRoleAction extends baseAction {

	private static final long serialVersionUID = 1L;
	/*
	 * ������� Service
	 */
	@Resource
	private RoleService rservice;
	/*
	 * ��ѯ�б�ʹ�ã� 1>ps����ѯ�����ࣻ 2>pageId����ҳ�ж��ֶΣ� 3>hql��hibernate��ѯ��sql author��zhaosy
	 */
	private PaginationSupport ps;
	private String hql = "";
	/*
	 * ����������Ϣ�ֶ� author��zhaosy
	 */
	private String message;

	/*
	 * ��ѯ����
	 */
	private String qrolename = "";
	private String qtype = "";

	/*
	 * ��Դ��ѯ
	 * 
	 * author��zhaosy
	 */
	public void query() {
		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		int row = Integer.parseInt(this.getRequest().getParameter("rows"));// ���ܲ���page��rows

		/*
		 * ��������ȡ�����б�
		 */
		try {
			/*
			 * ��Ȩ�޲���
			 */
			if ("admin".equals(this.getUser().getUsername())) {
				hql = " where 1=1 ";
			} else {
				hql = " where  rolename not like '��������Ա%' and (deptno like '%"
						+ (this.getSysDept().getDeptno().substring(6)) + "' or deptno='') ";
			}

			/*
			 * ����������
			 */

			if (!(this.getQtype() == null || "".equals(this.getQtype()) || "%"
					.equals(this.getQtype()))) {
				hql = hql + " and type like '" + this.getQtype() + "'";
			}

			if (!(this.getQrolename() == null || "".equals(this.getQrolename()
					.trim())))
				hql = hql + " and rolename like '%" + this.getQrolename()
						+ "%'";
			hql = hql + "  order by roleid";

			ps = rservice.findPageByQuery(hql, hql, row, (page - 1) * row);
			this.getResponse().setCharacterEncoding("utf-8");
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps
					.getTotalCount(), ps.getItems()), this.getResponse());
		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);
		}
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

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getQrolename() {
		return qrolename;
	}

	public void setQrolename(String qrolename) {
		this.qrolename = qrolename;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

}
