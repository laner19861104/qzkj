/**
 * .java
 *
 * 功能：。
 * 类名： 
 *
 *   Ver     変更日        部门           担当者      変更内容
 * ────────────────────────────────────────
 *   V1.00  10-9-12     CFIT－PM         闫如斌      初版
*
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
*/

package com.bip.common.service;

/**
 * @author 闫如斌
 *
 */
public class ServiceContant {
	/**
	 * 公共信息
	 */
//	public static String PUBLIC_ADD_NYZD="PUBLIC_ADD_NYZD";//能源字典
	
	/**
	 * 能耗数据库
	 */
	public static String ENERGY_ADD_COMPANYINFO="ENERGY_ADD_COMPANYINFO";//基本信息表
	public static String ENERGY_UPDATE_COMPANYINFO="ENERGY_UPDATE_COMPANYINFO";//基本信息表 修改
	public static String ENERGY_DELETE_COMPANYINFO="ENERGY_DELETE_COMPANYINFO";//基本信息表 删除
	
	public static String ENERGY_ADD_CONSUMPTIONSTRUCTUR="ENERGY_ADD_CONSUMPTIONSTRUCTUR";//能源消费结构表 
	public static String ENERGY_UPDATE_CONSUMPTIONSTRUCTUR="ENERGY_UPDATE_CONSUMPTIONSTRUCTUR";//能源消费结构表 修改
	public static String ENERGY_DELETE_CONSUMPTIONSTRUCTUR="ENERGY_DELETE_CONSUMPTIONSTRUCTUR";//能源消费结构表 删除
	public static String ENERGY_ADD_UNITPRODUCT="ENERGY_ADD_UNITPRODUCT";//单位产品综合能耗
	public static String ENERGY_UPDATE_UNITPRODUCT="ENERGY_UPDATE_UNITPRODUCT";//单位产品综合能耗 修改
	public static String ENERGY_DELETE_UNITPRODUCT="ENERGY_DELETE_UNITPRODUCT";//单位产品综合能耗 删除
	public static String ENERGY_ADD_JNCOMPLETE="ENERGY_ADD_JNCOMPLETE";//节能目标完成情况
	public static String ENERGY_UPDATE_JNCOMPLETE="ENERGY_UPDATE_JNCOMPLETE";//节能目标完成情况 修改
	public static String ENERGY_DELETE_JNCOMPLETE="ENERGY_DELETE_JNCOMPLETE";//节能目标完成情况 删除
	public static String ENERGY_ADD_JNOPINION="ENERGY_ADD_JNOPINION";//节能目标责任评价考核表
	public static String ENERGY_UPDATE_JNOPINION="ENERGY_UPDATE_JNOPINION";//节能目标责任评价考核表 修改
	public static String ENERGY_DELETE_JNOPINION="ENERGY_DELETE_JNOPINION";//节能目标责任评价考核表 删除
	public static String ENERGY_ADD_FACILITYSTATUS="ENERGY_ADD_FACILITYSTATUS";//主要耗能设备状况表
	public static String ENERGY_UPDATE_FACILITYSTATUS="ENERGY_UPDATE_FACILITYSTATUS";//主要耗能设备状况表 修改
	public static String ENERGY_DELETE_FACILITYSTATUS="ENERGY_DELETE_FACILITYSTATUS";//主要耗能设备状况表 删除
	public static String ENERGY_ADD_COUNTRYSTANDARD="ENERGY_ADD_COUNTRYSTANDARD";//合理用能国家标准执行情况表
	public static String ENERGY_UPDATE_COUNTRYSTANDARD="ENERGY_UPDATE_COUNTRYSTANDARD";//合理用能国家标准执行情况表 修改
	public static String ENERGY_DELETE_COUNTRYSTANDARD="ENERGY_DELETE_COUNTRYSTANDARD";//合理用能国家标准执行情况表 删除
	public static String ENERGY_ADD_TECHNICREBUILD="ENERGY_ADD_TECHNICREBUILD";//规划期节能技术改造项目列表
	public static String ENERGY_UPDATE_TECHNICREBUILD="ENERGY_UPDATE_TECHNICREBUILD";//规划期节能技术改造项目列表 修改
	public static String ENERGY_DELETE_TECHNICREBUILD="ENERGY_DELETE_TECHNICREBUILD";//规划期节能技术改造项目列表 删除
	public static String ENERGY_ADD_TECHNICREBUILDBG="ENERGY_ADD_TECHNICREBUILDBG";//与上年相比节能项目变更情况表
	public static String ENERGY_UPDATE_TECHNICREBUILDBG="ENERGY_UPDATE_TECHNICREBUILDBG";//与上年相比节能项目变更情况表 修改
	public static String ENERGY_DELETE_TECHNICREBUILDBG="ENERGY_DELETE_TECHNICREBUILDBG";//与上年相比节能项目变更情况表 删除
	public static String ENERGY_ADD_TECHNICREBUILDXG="ENERGY_ADD_TECHNICREBUILDXG";//新建改建扩建项目情况
	public static String ENERGY_UPDATE_TECHNICREBUILDXG="ENERGY_UPDATE_TECHNICREBUILDXG";//新建改建扩建项目情况 修改
	public static String ENERGY_DELETE_TECHNICREBUILDXG="ENERGY_DELETE_TECHNICREBUILDXG";//新建改建扩建项目情况 删除
	public static String ENERGY_ADD_ENYCHANGECCAUSE="ENERGY_ADD_ENYCHANGECCAUSE";//影响产品（产值）能耗变化的因素说明
	public static String ENERGY_UPDATE_ENYCHANGECCAUSE="ENERGY_UPDATE_ENYCHANGECCAUSE";//影响产品（产值）能耗变化的因素说明 修改
	public static String ENERGY_DELETE_ENYCHANGECCAUSE="ENERGY_DELETE_ENYCHANGECCAUSE";//影响产品（产值）能耗变化的因素说明 删除
	public static String ENERGY_ADD_WATERSTAT="ENERGY_ADD_WATERSTAT";//企业用水统计表
	public static String ENERGY_UPDATE_WATERSTAT="ENERGY_UPDATE_WATERSTAT";//企业用水统计表 修改
	public static String ENERGY_DELETE_WATERSTAT="ENERGY_DELETE_WATERSTAT";//企业用水统计表 删除
	
	public static String ENERGY_ADD_UNITPRODUCTCONSUME="ENERGY_ADD_UNITPRODUCTCONSUME";//重点用能工业企业单位产品能源消耗情况 添加
	public static String ENERGY_UPDATE_UNITPRODUCTCONSUME="ENERGY_UPDATE_UNITPRODUCTCONSUME";//重点用能工业企业单位产品能源消耗情况 修改
	public static String ENERGY_DELETE_UNITPRODUCTCONSUME="ENERGY_DELETE_UNITPRODUCTCONSUME";//重点用能工业企业单位产品能源消耗情况 删除
	
	public static String ENERGY_ADD_ENERGYSWPH="ENERGY_ADD_ENERGYSWPH";//重点用能单位能源实物平衡明细表
	public static String ENERGY_UPDATE_ENERGYSWPH="ENERGY_UPDATE_ENERGYSWPH";//重点用能单位能源实物平衡明细表
	public static String ENERGY_DELETE_ENERGYSWPH="ENERGY_DELETE_ENERGYSWPH";//重点用能单位能源实物平衡明细表
	/**
	 * 工业经济运行
	 */
	public static String GYJJYX_ADD_JOBQYSBBINFO="GYJJYX_ADD_JOBQYSBBINFO";//企业上报表
	public static String GYJJYX_ADD_JOBCXZZINFO="GYJJYX_ADD_JOBCXZZINFO";//添加工业产销总值表
	public static String GYJJYX_UPDATE_JOBCXZZINFO="GYJJYX_UPDATE_JOBCXZZINFO";//更新工业产销总值表
	public static String GYJJYX_DELETE_JOBCXZZINFO="GYJJYX_DELETE_JOBCXZZINFO";//删除工业产销总值表
	public static String GYJJYX_ADD_JOBJJZBINFO="GYJJYX_ADD_JOBJJZBINFO";//经济指标表
	public static String GYJJYX_UPDATE_JOBJJZBINFO="GYJJYX_UPDATE_JOBJJZBINFO";//更新经济指标表
	public static String GYJJYX_DELETE_JOBJJZBINFO="GYJJYX_DELETE_JOBJJZBINFO";//删除经济指标表
	public static String GYJJYX_ADD_JOBPRODUCTPRICE="GYJJYX_ADD_JOBPRODUCTPRICE";//产品价格明细表
	public static String GYJJYX_UPDATE_JOBPRODUCTPRICE="GYJJYX_UPDATE_JOBPRODUCTPRICE";//更新产品价格明细表
	public static String GYJJYX_DELETE_JOBPRODUCTPRICE="GYJJYX_DELETE_JOBPRODUCTPRICE";//删除产品价格明细表
	
	
	

	
	
	/**
	 * 系统管理
	 */
	public static String SYS_ADD_DMZD="SYS_ADD_DMZD";//添加代码典
	public static String SYS_DELETE_DMZD="SYS_DELETE_DMZD";//删除代码典
	public static String SYS_UPDATE_DMZD="SYS_UPDATE_DMZD";//修改代码典
	
	public static String SYS_ADD_CPZD="SYS_ADD_CPZD";//添加产品字典
	public static String SYS_DELETE_CPZD="SYS_DELETE_CPZD";//删除产品字典
	public static String SYS_UPDATE_CPZD="SYS_UPDATE_CPZD";//修改产品字典
	
	public static String SYS_ADD_NYZD="SYS_ADD_NYZD";//添加能源字典
	public static String SYS_ADD_NHZBZD="SYS_ADD_NHZBZD";//添加能耗指标字典
	
	public static String SYS_ADD_SBZD="SYS_ADD_SBZD";//添加设备字典
	public static String SYS_DELETE_SBZD="SYS_DELETE_SBZD";//删除设备字典
	public static String SYS_UPDATE_SBZD="SYS_UPDATE_SBZD";//修改设备字典
	
	public static String SYS_ADD_JJZBZD="SYS_ADD_JJZBZD";//添加经济指标字典
	public static String SYS_ADD_CXZZZD="SYS_ADD_CXZZZD";//添加产销总值字典
	public static String SYS_ADD_ENTERPRISE="SYS_ADD_ENTERPRISE";//添加企业信息
	public static String SYS_DELETE_ENTERPRISE="SYS_DELETE_ENTERPRISE";//删除企业信息
	public static String SYS_UPDATE_ENTERPRISE="SYS_UPDATE_ENTERPRISE";//修改企业信息
	
	public static String JOB_ADD_ENTERCPZD = "JOB_ADD_ENTERCPZD"; //添加企业产品信息对应表
	public static String JOB_UPDATE_ENTERCPZD = "JOB_UPDATE_ENTERCPZD"; //修改企业产品信息对应表
	public static String JOB_DELETE_ENTERCPZD = "JOB_DELETE_ENTERCPZD"; //删除企业产品信息对应表
	
	
}
