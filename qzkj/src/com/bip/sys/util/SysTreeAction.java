/************************************************************
 * ������SysTreeAction.java
 *
 * ��𣺹�����
 * ���ܣ���ȡ���Ͳ˵��ࡣ
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-30  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.jqueryeasyui.JqueryUtil;
import com.bip.common.jqueryeasyui.Tree;
import com.bip.common.jqueryeasyui.TreeVo;
import com.bip.common.util.ControllerUtil;
import com.bip.sys.codediction.dmzd.service.DmzdService;

import com.bip.sys.dept.service.DeptService;
import com.bip.sys.permission.service.PermissionService;
import com.bip.sys.resource.po.SysResource;
import com.bip.sys.resource.service.ResourceService;
@Controller
public class SysTreeAction extends baseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * ������� Service
	 */
	@Resource
	private DeptService deptservice;
	@Resource
	private ResourceService resservice;
	@Resource
	private PermissionService perservice;
	@Resource
	private DmzdService dmzdservice;

	private List<Tree> treelist;
	

	public List<Tree> getTreelist() {
		return treelist;
	}

	public void setTreelist(List<Tree> treelist) {
		this.treelist = treelist;
	}

	/**
	 * ���ܣ���ȡ����comboTree
	 */
	public void getDeptTree() {
		String dsql = "";
		if ("admin".equals(this.getUser().getUsername())) {
			dsql = "where upper(deptlevel)=upper('01')";
		} else {
			dsql = " where depttype ='" + this.getSysDept().getDepttype() + "'";
		}
		List datalist = deptservice.find(dsql);

		List treelist = DatalistToTreelist.fromDeptlistToTreelist(datalist);

		String jsonstr = "[" + JqueryUtil.getComboTreeJson("", treelist) + "]";

		ControllerUtil.responseWriter(jsonstr, this.getResponse());
	}

	/**
	 * ���ܣ����ݲ������ͻ�ȡ����comboTree
	 */
	public void getDeptTreeByType() {
		String depttype = this.getRequest().getParameter("depttype");
		String dsql = " where depttype ='" + depttype + "'";
		List datalist = deptservice.find(dsql);

		List treelist = DatalistToTreelist.fromDeptlistToTreelist(datalist);

		String jsonstr = "[" + JqueryUtil.getComboTreeJson("", treelist) + "]";

		ControllerUtil.responseWriter(jsonstr, this.getResponse());
	}

	/**
	 * ���ܣ����ݲ��ż����ȡ����comboTree
	 */
	public void getDeptTreeByLevel() {
		String deptlevel = this.getRequest().getParameter("deptlevel");
		String dsql = " where deptlevel ='" + deptlevel + "'";
		List datalist = deptservice.find(dsql);

		List treelist = DatalistToTreelist.fromDeptlistToTreelist(datalist);

		String jsonstr = "[" + JqueryUtil.getComboTreeJson("", treelist) + "]";

		ControllerUtil.responseWriter(jsonstr, this.getResponse());
	}

	/**
	 * ���ܣ���ȡ����combogrid
	 */
	public void getDeptGrid() {
		List datalist = deptservice.find("");
		ControllerUtil.responseWriter(ControllerUtil.getJsonString(datalist
				.size(), datalist), this.getResponse());
	}

	/**
	 * ���ܣ���ȡ��ԴcomboTree
	 */
	public void getResourceTree() {
		List datalist = resservice.find("");
		List treelist = DatalistToTreelist.fromResourcelistToTreelist(datalist);
		String jsonstr = "[" + JqueryUtil.getComboTreeJson("0", treelist) + "]";
		this.getResponse().setCharacterEncoding("utf-8");
		ControllerUtil.responseWriter(jsonstr, this.getResponse());
	}

	/**
	 * ���ܣ���ȡ��Դcombogrid
	 */
	public void getResourceGrid() {
		List datalist = resservice.find("");
		ControllerUtil.responseWriter(ControllerUtil.getJsonString(datalist
				.size(), datalist), this.getResponse());
	}

	/**
	 * ���ܣ���ȡȨ��comboTree
	 */
	public void getPermissionTree() {
		String dsql = "";
		List datalist = null;
		if ("admin".equals(this.getUser().getUsername())) {
			datalist = perservice.find("");

		} else {
			datalist = perservice.findPermission(this.getUser().getUserid());
		}

		List treelist = DatalistToTreelist
				.fromPermissionlistToTreelist(datalist);
		String jsonstr = "[" + JqueryUtil.getComboTreeJson("0", treelist) + "]";
		ControllerUtil.responseWriter(jsonstr, this.getResponse());
	}

	/**
	 * ���ܣ���ȡȨ��comboTree:������ѡ����Ȩ��
	 */
	public void getPermissionTreeOfCheck() {
		/*
		 * ѡ����ɫ(roleid)��Ȩ���б�
		 */
		String roleid = (String) this.getRequest().getParameter("roleid");
		if (roleid == null || "".equals(roleid)) {
			System.out.println("roleid is null !");
			return;
		}
		int checkroleid = Integer.parseInt(roleid);
		List checkdatalist = null;
		checkdatalist = perservice.findPermissionByRoleid(checkroleid);
		/*
		 * ��½�û���Ȩ���б�
		 */
		String dsql = "";
		List datalist = null;
		if ("admin".equals(this.getUser().getUsername())) {
			datalist = perservice.find("");

		} else {
			datalist = perservice.findPermission(this.getUser().getUserid());
		}
		/*
		 * ��½�û�Ȩ����
		 */
		List treelist = DatalistToTreelist
				.fromPermissionlistToTreelist(datalist);
		/*
		 * ѡ����ɫ��Ȩ����
		 */
		List checktreelist = null;
		if (checkdatalist == null || checkdatalist.size() == 0) {
			checktreelist = null;
		} else {
			checktreelist = DatalistToTreelist
					.fromPermissionlistToTreelist(checkdatalist);
		}
		/*
		 * ����comboxtree������ѡ����ɫ��Ȩ���������û�Ȩ������checked�ֶθ�ֵfalse��true
		 */
		List combotreelist = new ArrayList();
		String jsonstr = "";
		if (checktreelist == null || checktreelist.size() == 0) {
			System.out.println("0");
			combotreelist = treelist;
			jsonstr = "[" + JqueryUtil.getComboTreeJson("0", combotreelist)
					+ "]";
		} else {
			for (int i = 0; i < treelist.size(); i++) {
				TreeVo tempt = new TreeVo();
				tempt = (TreeVo) treelist.get(i);
				tempt.setChecked(false);
				TreeVo temptc = new TreeVo();
				for (int j = 0; j < checktreelist.size(); j++) {
					temptc = (TreeVo) checktreelist.get(j);
					if (tempt.getId().equals(temptc.getId())) {
						tempt.setChecked(true);
						break;
					}
				}
				combotreelist.add(i, tempt);
			}
			jsonstr = "["
					+ JqueryUtil.getComboTreeJsonOfCheck("0", combotreelist)
					+ "]";
		}
		this.getResponse().setCharacterEncoding("utf-8");
		ControllerUtil.responseWriter(jsonstr, this.getResponse());
	}

	/**
	 * ���ܣ���ȡȨ��combogrid
	 */
	public void getPermissionGrid() {
		List datalist = perservice.find("");
		ControllerUtil.responseWriter(ControllerUtil.getJsonString(datalist
				.size(), datalist), this.getResponse());
	}

	/**
	 * ���ܣ���ȡ����comboTree
	 */
	public void getRegionTree() {
		String sql = "where upper(lbbh)=upper('sys_region') ";
		if ("admin".equals(this.getUser().getUsername())) {
			// sql+=" and deptlevel='01'";
		}
		List datalist = dmzdservice.find(sql);
		List treelist = DatalistToTreelist.fromSysDmzdlistToTreelist(datalist);
		String jsonstr = "[" + JqueryUtil.getComboTreeJson("0", treelist) + "]";

		ControllerUtil.responseWriter(jsonstr, this.getResponse());
	}

	/**
	 * ���ܣ���ȡ����comboTree
	 */
	public void getWfRegionTree() {
		String sql = "where upper(lbbh)=upper('sys_wfregion') ";
		if ("admin".equals(this.getUser().getUsername())) {
			// sql+=" and deptlevel='01'";
		}
		List datalist = dmzdservice.find(sql);
		List treelist = DatalistToTreelist.fromSysDmzdlistToTreelist(datalist);
		String jsonstr = "[" + JqueryUtil.getComboTreeJson("0", treelist) + "]";

		ControllerUtil.responseWriter(jsonstr, this.getResponse());
	}

	/**
	 * ���ܣ���ȡ����combogrid
	 */
	public void getRegionGrid() {
		List datalist = dmzdservice
				.find(" where upper(lbbh) =upper('sys_region') ");
		ControllerUtil.responseWriter(ControllerUtil.getJsonString(datalist
				.size(), datalist), this.getResponse());
	}

	/**
	 * ���ܣ���ȡ�����ֵ�comboTree
	 */
	public void getSysDmzdTree() {
		String lbbh = this.getRequest().getParameter("lbbh");
		String sql = "where upper(lbbh)=upper('" + lbbh + "') ";

		List datalist = dmzdservice.find(sql);
		List treelist = DatalistToTreelist.fromSysDmzdlistToTreelist(datalist);
		String jsonstr = "[" + JqueryUtil.getComboTreeJson("0", treelist) + "]";

		ControllerUtil.responseWriter(jsonstr, this.getResponse());
	}

	
	/**
	 * ���ܣ���ȡ��ҵcomboTree
	 */
	public void getWfhyTree() {
		String sql = "where upper(lbbh)=upper('enterprise_xxtype') ";
		if ("admin".equals(this.getUser().getUsername())) {
			// sql+=" and deptlevel='01'";
		}
		List datalist = dmzdservice.find(sql);
		List treelist = DatalistToTreelist.fromSysDmzdlistToTreelist(datalist);
		String jsonstr = "[" + JqueryUtil.getComboTreeJson("0", treelist) + "]";

		ControllerUtil.responseWriter(jsonstr, this.getResponse());
	}
	public String getLeftResourceTree()
	{
		String resourceid=this.getRequest().getParameter("resourceid");
		if(resourceid==null)
		{
		List<SysResource> resList=(List)this.getSession().getAttribute("reslist");
		for(SysResource obj : resList)
		{
			if(obj.getPresourceno().equals("0"))
			{
				resourceid=obj.getResourceno();
				break;
			}
		}
		}
		treelist=this.resservice.getRsourceListByResPid(resourceid,super.getUser().getUserid());
		return "success";
	}
	public DeptService getDeptservice() {
		return deptservice;
	}

	public void setDeptservice(DeptService deptservice) {
		this.deptservice = deptservice;
	}

	public ResourceService getResservice() {
		return resservice;
	}

	public void setResservice(ResourceService resservice) {
		this.resservice = resservice;
	}

	public PermissionService getPerservice() {
		return perservice;
	}

	public void setPerservice(PermissionService perservice) {
		this.perservice = perservice;
	}

	public DmzdService getDmzdservice() {
		return dmzdservice;
	}

	public void setDmzdservice(DmzdService dmzdservice) {
		this.dmzdservice = dmzdservice;
	}



}
