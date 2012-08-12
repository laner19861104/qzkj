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
package com.bip.sys.user.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.user.service.UserRoleService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class QueryUserRoleAction extends baseAction {

	private static final long serialVersionUID = 1L;

	/*
	 * ������� Service
	 */
	@Resource
	private UserRoleService userroleservice;
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
			 * ����������
			 */
			String userid = this.getRequest().getParameter("userid");
			hql = " where userid=" + userid;
			hql = hql + "  order by userid";
			ps = userroleservice.findPageByQuery(hql, hql, row, (page - 1)
					* row);
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps
					.getTotalCount(), ps.getItems()), this.getResponse());
			return;
			
		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);
			return;
		}
	}

	public UserRoleService getUserroleservice() {
		return userroleservice;
	}

	public void setUserroleservice(UserRoleService userroleservice) {
		this.userroleservice = userroleservice;
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

}
