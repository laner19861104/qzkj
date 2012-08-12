/************************************************************
 * 类名：UniContant.java
 *
 * 类别：基础类
 * 功能：定义系统公共常量。
 * 
 *   Ver     変更日               企业单位            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-12  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.common.util;

import java.util.ResourceBundle;

public class UniContant {
	/*
	 * 定义配置文件
	 */
	public static final String OPTION_FILE_NAME = "sysconfig";
	public static ResourceBundle res = ResourceBundle.getBundle(OPTION_FILE_NAME);
	/*
	 * 定义页面条数
	 */
	public static int pageSize = 15;
	/*
	 * 定义Excel表模板名称
	 */
	public static String exceltemplate;// excel表模板
	public static int exceltemplatenum;// excel表模板

	/* chart图表 */
	public static String CHART_ZHEXIAN;// 折线图
	public static String CHART_ZHUZHUANG;// 柱状图
	/*
	 * 定义SYS系统公用的数据字典
	 */
	public static String SYS_REEGION;// 系统－区域
	public static String SYS_SEX;// 系统－性别
	public static String SYS_POSTPRIV;// 系统－职务
	public static String SYS_EDUCATION;// 系统－学历
	public static String SYS_DEGREE;// 系统－学位
	public static String SYS_TITLE;// 系统－职称
	public static String SYS_NATIONAL;// 系统－民族
	public static String SYS_WFREGION;// 系统－潍坊区域

	public static String SYS_CLASS;// 系统－流程分类
	public static String SYS_STARTMARK;// 系统－启用标志
	public static String SYS_FINSTAT;// 系统－财务表版本

	public static String SYS_TABLE;// 系统－自定义表
	public static String SYS_FIELD;// 系统－自定义表字段
	public static String SYS_FINSTATTABLE;// 系统－自定义财务表
	public static String SYS_FINSTATFIELD;// 系统－自定义财务表字段
	public static String SYS_FIELDTYPE;// 系统－表字段类型

	public static String SYS_GRADE;//
	public static String SYS_JUDGE;//

	/*
	 * 定义部门数据字典
	 */
	public static String DEPT_TYPE;//
	public static String DEPT_LEVEL;//
	/*
	 * 定义资源数据字典
	 */
	public static String RESOURCE_TYPE;//
	/*
	 * 定义权限数据字典
	 */
	public static String PERMISSION_ACTIONID;//
	/*
	 * 定义角色数据字典
	 */
	public static String ROLE_TYPE;//
	/*
	 * 定义用户数据字典
	 */
	public static String USER_POSTPRIV;// SYS_POSTPRIV
	public static String USER_SEX;// SYS_SEX
	public static String USER_HIDEBIRTH;// SYS_STARTMARK
	public static String USER_HIDEMOBILE;// SYS_STARTMARK
	public static String USER_SMSON;// SYS_STARTMARK
	public static String USER_STATE;// 用户_状态
	public static String USER_REGION;// SYS_REGION
	public static String USER_DUTYTYPE;// 用户_职务类型
	public static String USER_TYPE;// 用户_类型

	/*
	 * 定义企业单位数据字典
	 */
	public static String ENTERPRISE_QYSC;// 企业区域
	public static String ENTERPRISE_HYFLSC;// 行业分类
	public static String ENTERPRISE_DWLXSC;// 单位类型：国营、有限责任公司等
	public static String ENTERPRISE_ZDLBSC;// 重点类别：能源重点
	public static String ENTERPRISE_ZDLXSC;// 重点类型：工业重点
	public static String ENTERPRISE_FLAGSC;// 启用标志－统计标志
	public static String ENTERPRISE_TYPESC;// 单位类别：大型、中型、小型
	// 单位其它分类项

	static {
		try {
			
			pageSize = Integer.parseInt((res.getString("pageSize").trim()));
			/*
			 * 获取模板数据
			 */
			exceltemplate = res.getString("exceltemplate").trim();
			exceltemplatenum = Integer.parseInt(res.getString(
					"exceltemplatenum").trim());
			/** chart图表 名称 **/
			CHART_ZHEXIAN = res.getString("CHART_ZHEXIAN").trim();// 折线图
			CHART_ZHUZHUANG = res.getString("CHART_ZHUZHUANG").trim();// 柱状图
			/*
			 * 定义SYS系统公用的数据字典
			 */
			SYS_REEGION = res.getString("SYS_REGION").trim();
			SYS_SEX = res.getString("DEPT_TYPE").trim();
			SYS_POSTPRIV = res.getString("DEPT_TYPE").trim();
			SYS_EDUCATION = res.getString("DEPT_TYPE").trim();
			SYS_DEGREE = res.getString("DEPT_TYPE").trim();
			SYS_TITLE = res.getString("DEPT_TYPE").trim();
			SYS_NATIONAL = res.getString("DEPT_TYPE").trim();
			SYS_WFREGION = res.getString("SYS_WFREGION").trim();

			SYS_TABLE = res.getString("SYS_TABLE").trim();
			SYS_FIELD = res.getString("SYS_FIELD").trim();
			SYS_FINSTATTABLE = res.getString("SYS_FINSTATTABLE").trim();
			SYS_FINSTATFIELD = res.getString("SYS_FINSTATFIELD").trim();
			SYS_FIELDTYPE = res.getString("SYS_FIELDTYPE").trim();

			SYS_CLASS = res.getString("SYS_CLASS").trim();
			SYS_STARTMARK = res.getString("SYS_STARTMARK").trim();
			SYS_FINSTAT = res.getString("SYS_FINSTAT").trim();

			SYS_GRADE = res.getString("SYS_GRADE").trim();
			SYS_JUDGE = res.getString("SYS_JUDGE").trim();

			/*
			 * 部门数据字典定义
			 */
			DEPT_TYPE = res.getString("DEPT_TYPE").trim();
			DEPT_LEVEL = res.getString("DEPT_LEVEL").trim();
			/*
			 * 资源数据字典定义
			 */
			RESOURCE_TYPE = res.getString("RESOURCE_TYPE").trim();
			/*
			 * 权限数据字典定义
			 */
			PERMISSION_ACTIONID = res.getString("PERMISSION_ACTIONID").trim();
			/*
			 * 角色数据字典定义
			 */
			ROLE_TYPE = res.getString("ROLE_TYPE").trim();
			/*
			 * 用户数据字典定义
			 */
			USER_POSTPRIV = res.getString("USER_POSTPRIV").trim();
			USER_SEX = res.getString("USER_SEX").trim();
			USER_HIDEBIRTH = res.getString("USER_HIDEBIRTH").trim();
			USER_HIDEMOBILE = res.getString("USER_HIDEMOBILE").trim();
			USER_SMSON = res.getString("USER_SMSON").trim();
			USER_STATE = res.getString("USER_STATE").trim();
			USER_REGION = res.getString("USER_REGION").trim();
			USER_DUTYTYPE = res.getString("USER_DUTYTYPE").trim();
			USER_TYPE = res.getString("USER_TYPE").trim();
			/*
			 * 企业单位数据字典定义
			 */
			ENTERPRISE_QYSC = res.getString("ENTERPRISE_QYSC").trim();
			ENTERPRISE_HYFLSC = res.getString("ENTERPRISE_HYFLSC").trim();
			ENTERPRISE_DWLXSC = res.getString("ENTERPRISE_DWLXSC").trim();
			ENTERPRISE_ZDLBSC = res.getString("ENTERPRISE_ZDLBSC").trim();
			ENTERPRISE_ZDLXSC = res.getString("ENTERPRISE_ZDLXSC").trim();
			ENTERPRISE_FLAGSC = res.getString("ENTERPRISE_FLAGSC").trim();
			ENTERPRISE_TYPESC = res.getString("ENTERPRISE_TYPESC").trim();

		} catch (Exception ex) {
			ex.printStackTrace();
			pageSize = 15;
			System.out.println("IO读取出错，找不到sysconfig.properties!");
		}
	}

	/*
	 * 定义操作返回码
	 */
	public static final String queryok = "查询成功！";
	public static final String addok = "新增成功！";
	public static final String editok = "修改成功！";
	public static final String delok = "删除成功！";
	public static final String queryerror = "查询失败，请查看日志！";
	public static final String adderror = "新增失败，请查看日志！";
	public static final String editerror = "修改失败，请查看日志！";
	public static final String delerror = "删除失败，请查看日志！";
	public static final String codeerror = "数据字典读取失败，请查看日志！";
	public static final String uppwdok = "密码已成功修改！";
	public static final String cannotdelerror = "权限不足，无法删除！";
	public static final String sessionerror = "session 已失效，请重新登陆！";
	public static final String connerror = "数据库连接失败，请查看网络或重启服务！";
	public static final String existerror = "该记录已存在！";
	public static final String selecterror = "选择记录失败，请确认该记录存在！";
	public static final String exportexcelsuccess = "恭喜，excel导出成功！";
	public static final String exportexcelfailure = "excel导出失败，请查看日志！";
	public static final String dmzderror = "数据字典取值不正确，请检查配置文件！";
	public static final String nopermission = "对不起，您无此操作的权限！";

}
