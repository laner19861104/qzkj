/************************************************************
 * ������DatalistToTreelist.java
 *
 * ��𣺹�����
 * ���ܣ�ת�������Ͳ˵��ࡣ
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

import com.bip.common.jqueryeasyui.TreeVo;
import com.bip.sys.codediction.dmzd.po.SysDmzd;
import com.bip.sys.codediction.po.SysHyzd;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.permission.po.SysPermission;
import com.bip.sys.resource.po.SysResource;

public class DatalistToTreelist {
	/**
	 * ��������������Դ�б�ת��ΪTreeVo�б�
	 * 
	 * @param datalist
	 * @return
	 */
	public static List fromResourcelistToTreelist(List datalist) {
		List treelist = new ArrayList();

		if (datalist == null || datalist.size() == 0) {
			return null;
		}

		for (int i = 0; i < datalist.size(); i++) {
			SysResource respo = new SysResource();
			respo = (SysResource) datalist.get(i);
			TreeVo treevo = new TreeVo();
			treevo.setId(respo.getResourceno());
			treevo.setText(respo.getResourcename());
			treevo.setPid(respo.getPresourceno());
			treelist.add(i, treevo);
		}

		return treelist;
	}

	/**
	 * ������������Ȩ���б�ת��ΪTreeVo�б�
	 * 
	 * @param datalist
	 * @return
	 */
	public static List fromPermissionlistToTreelist(List datalist) {
		List treelist = new ArrayList();

		if (datalist == null || datalist.size() == 0) {
			return null;
		}

		for (int i = 0; i < datalist.size(); i++) {
			SysPermission respo = new SysPermission();
			respo = (SysPermission) datalist.get(i);
			TreeVo treevo = new TreeVo();
			treevo.setId(respo.getPermissionno());
			treevo.setText(respo.getPermissionname());
			treevo.setPid(respo.getPpermissionno());
			treelist.add(i, treevo);
		}

		return treelist;
	}

	/**
	 * �����������������б�ת��ΪTreeVo�б�
	 * 
	 * @param datalist
	 * @return
	 */
	public static List fromDeptlistToTreelist(List datalist) {
		List treelist = new ArrayList();

		if (datalist == null || datalist.size() == 0) {
			return null;
		}
		for (int i = 0; i < datalist.size(); i++) {
			SysDepartment respo = new SysDepartment();
			respo = (SysDepartment) datalist.get(i);
			TreeVo treevo = new TreeVo();
			treevo.setId(respo.getDeptno());
			treevo.setText(respo.getDeptname());
			if (respo.getParentid() == null)
				treevo.setPid("");
			else
				treevo.setPid(respo.getParentid());
			treelist.add(i, treevo);
		}
		return treelist;
	}

	/**
	 * �����������������ֵ��б�ת��ΪTreeVo�б�
	 * 
	 * @param datalist
	 * @return
	 */
	public static List fromSysDmzdlistToTreelist(List datalist) {
		List treelist = new ArrayList();

		if (datalist == null || datalist.size() == 0) {
			return null;
		}
		for (int i = 0; i < datalist.size(); i++) {
			SysDmzd respo = new SysDmzd();
			respo = (SysDmzd) datalist.get(i);
			TreeVo treevo = new TreeVo();
			treevo.setId(respo.getBh());
			treevo.setText(respo.getMc());
			if (respo.getSjbh() == null)
				treevo.setPid("");
			else
				treevo.setPid(respo.getSjbh());
			treelist.add(i, treevo);
		}
		return treelist;
	}

	/**
	 * ��������������ҵ�ֵ��б�ת��ΪTreeVo�б�
	 * 
	 * @param datalist
	 * @return
	 */
	public static List fromHyzdlistToTreelist(List datalist) {
		List treelist = new ArrayList();

		if (datalist == null || datalist.size() == 0) {
			return null;
		}
		for (int i = 0; i < datalist.size(); i++) {
			SysHyzd respo = new SysHyzd();
			respo = (SysHyzd) datalist.get(i);
			TreeVo treevo = new TreeVo();
			treevo.setId(respo.getHybh());
			treevo.setText(respo.getHymc());
			if (respo.getSjbh() == null)
				treevo.setPid("");
			else
				treevo.setPid(respo.getSjbh());
			treelist.add(i, treevo);
		}
		return treelist;
	}
	
}
