package com.bip.common.jqueryeasyui;

import java.util.ArrayList;
import java.util.List;

public class JqueryUtil {
	/**
	 * ����������jquery-easyui��comboTree�õ����²˵�json��,��Ϊ�˺���Ϊѭ�����ã�
	 * ������ɴ���ʽ��response��ҳ��ĵ�jsonstr��һ�£����������ת����
	 * jsonstr="["+JqueryUtil.getComboTreeJson(pid,datalist)+"]"
	 * 
	 * @param pid
	 * @param datalist
	 *            ��TreeVo�����б�
	 * @return {"id":"1","text":"ɽ��","state":"open","children":[]}
	 */
	public static String getComboTreeJson(String pid, List datalist) {
		String str = "";
		/*
		 * �жϸ��ڵ�PID��������
		 */
		if (!getIshaschild(pid, datalist)) {

			return null;
		}
		/*
		 * ��ȡ���ڵ㣽pid�Ľڵ������б�
		 */
		List tlist = new ArrayList();// ���ڵ㣽pid�Ľڵ������б�
		List restlist = new ArrayList();// ʣ��ڵ������б�

		// ��ȡ��ǰ���ࣽpid�������б�
		int k = 0;
		int l = 0;
		for (int i = 0; i < datalist.size(); i++) {
			TreeVo tempt = new TreeVo();
			tempt = (TreeVo) datalist.get(i);
			if (pid.equals(tempt.getPid())) {
				tlist.add(k, tempt);
				k++;
			} else {
				restlist.add(l, tempt);
				l++;
			}
		}

		/*
		 * ������ǰ���ࣽpid�������б����json��
		 */
		for (int i = 0; i < tlist.size(); i++) {
			TreeVo tempt = new TreeVo();
			tempt = (TreeVo) tlist.get(i);
			if (getIshaschild(tempt.getId(), restlist)) {
				str += "{\"id\":\"" + tempt.getId() + "\",\"text\":\""
						+ tempt.getText() + "\",\"state\":\"closed\",";
				str += "\"children\":[";
				str += getComboTreeJson(tempt.getId(), restlist);
				str += "]";
				str += " }";
			} else {
				str += "{\"id\":\"" + tempt.getId() + "\",\"text\":\""
						+ tempt.getText() + "\"";
				str += " }";
			}
			if (i < tlist.size() - 1) {
				str += ",";
			}
		}
		System.out.println("jsonstr is " + str);
		return str;
	}

	/**
	 * 
	 * @param pid
	 * @param datalist
	 *            ��TreeVo�����б�
	 * @param datalist2
	 *            :��ѡ���datalist��{id1,id2,id3������}
	 * @return
	 */
	public static String getComboTreeJsonOfCheck(String pid, List datalist) {

		String str = "";
		/*
		 * �жϸ��ڵ�PID��������
		 */
		if (!getIshaschild(pid, datalist)) {

			return null;
		}
		/*
		 * ��ȡ���ڵ㣽pid�Ľڵ������б�
		 */
		List tlist = new ArrayList();// ���ڵ㣽pid�Ľڵ������б�
		List restlist = new ArrayList();// ʣ��ڵ������б�

		// ��ȡ��ǰ���ࣽpid�������б�
		int k = 0;
		int l = 0;
		for (int i = 0; i < datalist.size(); i++) {
			TreeVo tempt = new TreeVo();
			tempt = (TreeVo) datalist.get(i);
			if (pid.equals(tempt.getPid())) {
				tlist.add(k, tempt);
				k++;
			} else {
				restlist.add(l, tempt);
				l++;
			}
		}

		/*
		 * ������ǰ���ࣽpid�������б����json��
		 */
		for (int i = 0; i < tlist.size(); i++) {
			TreeVo tempt = new TreeVo();
			tempt = (TreeVo) tlist.get(i);
			if (getIshaschild(tempt.getId(), restlist)) {
				if (tempt.getChecked()) {
					str += "{\"id\":\"" + tempt.getId() + "\",\"text\":\""
							+ tempt.getText()
							+ "\",\"state\":\"closed\",\"checked\":\"true\",";
					str += "\"children\":[";
					str += getComboTreeJsonOfCheck(tempt.getId(), restlist);
					str += "]";
					str += " }";
				} else {
					str += "{\"id\":\"" + tempt.getId() + "\",\"text\":\""
							+ tempt.getText() + "\",\"state\":\"closed\",";
					str += "\"children\":[";
					str += getComboTreeJsonOfCheck(tempt.getId(), restlist);
					str += "]";
					str += " }";
				}
			} else {
				if (tempt.getChecked()) {
					str += "{\"id\":\"" + tempt.getId()
							+ "\",\"checked\":\"true\",\"text\":\""
							+ tempt.getText() + "\"";
					str += " }";
				} else {
					str += "{\"id\":\"" + tempt.getId() + "\",\"text\":\""
							+ tempt.getText() + "\"";
					str += " }";
				}
			}
			if (i < tlist.size() - 1) {
				str += ",";
			}
		}
		return str;
	}

	/**
	 * ����������jquery-ztree��dropdownMunu�õ����²˵�json��
	 * 
	 * @param pid
	 * @param datalist
	 *            ��TreeVo�����б�
	 * @return {id:"",pId:"",name:"",open:"true"}
	 */
	public static String getDropDownMenuTreeJson(String pid, List datalist) {

		String str = "";

		/*
		 * ������ǰ���ࣽpid�������б����json��
		 */
		for (int i = 0; i < datalist.size(); i++) {
			TreeVo tempt = new TreeVo();
			tempt = (TreeVo) datalist.get(i);

			if (getIshaschild(tempt.getId(), datalist)) {
				str += "{id:\"" + tempt.getId() + "\",pId:\"" + tempt.getPid()
						+ "\",name:\"" + tempt.getText() + "\",open:\"true\"}";
			} else {
				str += "{id:\"" + tempt.getId() + "\",pId:\"" + tempt.getPid()
						+ "\",name:\"" + tempt.getText() + "\"}";
			}
			if (i < datalist.size() - 1) {
				str += ",";
			}
		}
		return str;
	}

	/**
	 * �������������������˵�json����ȡ
	 * 
	 * @param datalist
	 *            ��TreeVo�����б�
	 * @return ["name","pid","id"]
	 */
	public static String getTwoTreeJson(List datalist) {

		String str = "";
		if (datalist == null || datalist.size() < 1) {
			return str;
		}
		/*
		 * ���������б����json��
		 */
		for (int i = 0; i < datalist.size(); i++) {
			TreeVo tempt = new TreeVo();
			tempt = (TreeVo) datalist.get(i);
			str += "[\"" + tempt.getText() + "\",\"" + tempt.getPid() + "\",\""
					+ tempt.getId() + "\"]";

			if (i < datalist.size() - 1) {
				str += ",";
			}
		}
		return str;
	}

	/**
	 * ������������datalist���ж�����ĸ��ڵ�ΪPID���޽ڵ�����
	 * 
	 * @param pid
	 * @param datalist
	 *            ��TreeVo�����б�
	 * @return
	 */
	public static boolean getIshaschild(String pid, List datalist) {
		if (datalist == null || datalist.size() == 0) {
			return false;
		}
		for (int i = 0; i < datalist.size(); i++) {
			TreeVo tempt = new TreeVo();
			tempt = (TreeVo) datalist.get(i);
			if (pid.equals(tempt.getPid())) {
				return true;
			}
		}
		return false;
	}

}
