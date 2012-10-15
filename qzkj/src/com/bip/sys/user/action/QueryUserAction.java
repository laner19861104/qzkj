/************************************************************
 * ������QueryUserAction.java
 *
 * ���Struts2 Action
 * ���ܣ��û���ѯ��
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-30  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.user.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.UniContant;
import com.bip.sys.user.service.UserService;

@Controller
public class QueryUserAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * ������� Service
	 */
	@Resource
	private UserService uservice;
	/*
	 * ��ѯ�б�ʹ�ã� 1>ps����ѯ�����ࣻ 2>pageId����ҳ�ж��ֶΣ� 3>hql��hibernate��ѯ��sql author��zhaosy
	 */
	private PaginationSupport ps;
	private int pageId = 1;
	private String hql = "";
	private int startIndex = 0;
	/*
	 * ����������Ϣ�ֶ� author��zhaosy
	 */
	private String message;

	/*
	 * ��ѯ����
	 */
	private String qusername;
	private String qdeptid;
	private String quserxm;

	private List deptlist;

	/*
	 * ��ѯ
	 * 
	 * author��zhaosy
	 */
	public void query() {
		/*
		 * ��������ȡ�����б�
		 */
		try {
			if ("admin".equals(this.getUser().getUsername())) {
				hql = " where 1=1 ";
			} else {			
					hql = " where deptid like '%" + (this.getSysDept().getDeptno().substring(6))
							+ "' and username<>'admin' ";
			}

			hql = hql + " order by deptid,username";
			ps = uservice.findPageByQuery(hql, hql, UniContant.pageSize, this
					.getStartIndex());
			ControllerUtil.responseWriter(ControllerUtil.getJsonString(ps
					.getTotalCount(), ps.getItems()), this.getResponse());
		} catch (Exception ex) {
			this.setMessage(UniContant.queryerror);
		}
	}

	public void setQusername(String qusername) {
		this.qusername = qusername;
	}

	public String getQusername() {
		return qusername;
	}

	public void setQdeptid(String qdeptid) {
		this.qdeptid = qdeptid;
	}

	public String getQdeptid() {
		return qdeptid;
	}

	public void setQuserxm(String quserxm) {
		this.quserxm = quserxm;
	}

	public String getQuserxm() {
		return quserxm;
	}

	public void setUservice(UserService uservice) {
		this.uservice = uservice;
	}

	public UserService getUservice() {
		return uservice;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public String getHql() {
		return hql;
	}

	public void setDeptlist(List deptlist) {
		this.deptlist = deptlist;
	}

	public List getDeptlist() {
		return deptlist;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
