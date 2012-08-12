package com.bip.sys.codediction.util;

import com.bip.common.util.UniContant;

public class CodedictionUniContant extends UniContant {
	
	/*
	 * 产品
	 */
	/**
	 * 状态
	 */
	public static String CPZD_STARTMARK;
	/**
	 * 产品类别
	 */
	public static String CPZD_CMLB;
	/**
	 * 所属系统
	 */
	public static String CPZD_SYZT;
	/**
	 * 重点类型
	 */
	public static String CPZD_ZDLX;
	/**
	 * 产品单位
	 */
	public static String CPZD_JLDW;
	
	/*
	 * 行业
	 */
	/**
	 * hyzd_hytype
	 */
	public static String HYZD_HYTYPE;
	/**
	 * hyzd_startmark
	 */
	public static String HYZD_STARTMARK;
	/**
	 * hyzd_zdhy
	 */
	public static String HYZD_ZDHY;
	
	/*
	 * 能源
	 */
	/**
	 * 计量单位
	public static String NYZD_JLDW;
	 */
	/**
	 * 区分类型
	 */
	public static String NYZD_SORTTYPE;
	/*
	 * 能耗指标
	 */
	/**
	 * 是否重点
	 */
	public static String NHZBZD_ISIMPORTANT;
	/**
	 * 是否节能指标
	 */
	public static String NHZBZD_ISSAVING;
	/**
	 * 计量单位
	 *//*
	public static String NHZBZD_JLDW;*/
	/*
	 * 设备
	 */
	/**
	 * 是否淘汰设备
	 */
	public static String SBZD_SFTTSB;
	
	static {
		try {
			/*
			 * 产品
			 */
			CPZD_STARTMARK = res.getString("CPZD_STARTMARK").trim();
			CPZD_CMLB = res.getString("CPZD_CMLB").trim();
			CPZD_SYZT = res.getString("CPZD_SYZT").trim();
			CPZD_ZDLX = res.getString("CPZD_ZDLX").trim();
			CPZD_JLDW = res.getString("CPZD_JLDW").trim();
			/*
			 * 行业
			 */
			HYZD_STARTMARK = res.getString("HYZD_STARTMARK").trim();
			HYZD_ZDHY = res.getString("HYZD_ZDHY").trim();
			HYZD_HYTYPE = res.getString("HYZD_HYTYPE").trim();
			/*
			 * 能源
			 */
			/*NYZD_JLDW = res.getString("NYZD_JLDW").trim();*/
			NYZD_SORTTYPE = res.getString("NYZD_SORTTYPE").trim();
			/*
			 * 能耗指标
			 */
			NHZBZD_ISIMPORTANT = res.getString("NHZBZD_ISIMPORTANT").trim();
			NHZBZD_ISSAVING = res.getString("NHZBZD_ISSAVING").trim();
			/*NHZBZD_JLDW = res.getString("NHZBZD_JLDW").trim();*/
			/*
			 * 设备
			 */
			SBZD_SFTTSB = res.getString("SBZD_SFTTSB").trim();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("IO读取出错，找不到sysconfig.properties!");
		}
	}
}
