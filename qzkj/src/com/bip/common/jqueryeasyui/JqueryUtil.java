package com.bip.common.jqueryeasyui;

import java.util.ArrayList;
import java.util.List;

public class JqueryUtil {
	/**
	 * 功能描述：jquery-easyui的comboTree得到树下菜单json串,因为此函数为循环调用，
	 * 因此生成串格式与response到页面的的jsonstr不一致，需进行如下转换：
	 * jsonstr="["+JqueryUtil.getComboTreeJson(pid,datalist)+"]"
	 * 
	 * @param pid
	 * @param datalist
	 *            ：TreeVo对象列表
	 * @return {"id":"1","text":"山东","state":"open","children":[]}
	 */
	public static String getComboTreeJson(String pid, List datalist) {
		String str = "";
		/*
		 * 判断父节点PID有无数据
		 */
		if (!getIshaschild(pid, datalist)) {

			return null;
		}
		/*
		 * 获取父节点＝pid的节点数据列表
		 */
		List tlist = new ArrayList();// 父节点＝pid的节点数据列表
		List restlist = new ArrayList();// 剩余节点数据列表

		// 获取当前父类＝pid的数据列表
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
		 * 解析当前父类＝pid的数据列表，组成json串
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
	 *            ：TreeVo对象列表
	 * @param datalist2
	 *            :已选择的datalist：{id1,id2,id3、、、}
	 * @return
	 */
	public static String getComboTreeJsonOfCheck(String pid, List datalist) {

		String str = "";
		/*
		 * 判断父节点PID有无数据
		 */
		if (!getIshaschild(pid, datalist)) {

			return null;
		}
		/*
		 * 获取父节点＝pid的节点数据列表
		 */
		List tlist = new ArrayList();// 父节点＝pid的节点数据列表
		List restlist = new ArrayList();// 剩余节点数据列表

		// 获取当前父类＝pid的数据列表
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
		 * 解析当前父类＝pid的数据列表，组成json串
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
	 * 功能描述：jquery-ztree的dropdownMunu得到树下菜单json串
	 * 
	 * @param pid
	 * @param datalist
	 *            ：TreeVo对象列表
	 * @return {id:"",pId:"",name:"",open:"true"}
	 */
	public static String getDropDownMenuTreeJson(String pid, List datalist) {

		String str = "";

		/*
		 * 解析当前父类＝pid的数据列表，组成json串
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
	 * 功能描述：二级联动菜单json串获取
	 * 
	 * @param datalist
	 *            ：TreeVo对象列表
	 * @return ["name","pid","id"]
	 */
	public static String getTwoTreeJson(List datalist) {

		String str = "";
		if (datalist == null || datalist.size() < 1) {
			return str;
		}
		/*
		 * 解析数据列表，组成json串
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
	 * 功能描述：从datalist中判断输入的父节点为PID有无节点数据
	 * 
	 * @param pid
	 * @param datalist
	 *            ：TreeVo对象列表
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
