package com.bip.sys.codediction.util;

import com.bip.common.util.UniContant;

public class CodedictionUniContant extends UniContant {
	
	/*
	 * ��Ʒ
	 */
	/**
	 * ״̬
	 */
	public static String CPZD_STARTMARK;
	/**
	 * ��Ʒ���
	 */
	public static String CPZD_CMLB;
	/**
	 * ����ϵͳ
	 */
	public static String CPZD_SYZT;
	/**
	 * �ص�����
	 */
	public static String CPZD_ZDLX;
	/**
	 * ��Ʒ��λ
	 */
	public static String CPZD_JLDW;
	
	/*
	 * ��ҵ
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
	 * ��Դ
	 */
	/**
	 * ������λ
	public static String NYZD_JLDW;
	 */
	/**
	 * ��������
	 */
	public static String NYZD_SORTTYPE;
	/*
	 * �ܺ�ָ��
	 */
	/**
	 * �Ƿ��ص�
	 */
	public static String NHZBZD_ISIMPORTANT;
	/**
	 * �Ƿ����ָ��
	 */
	public static String NHZBZD_ISSAVING;
	/**
	 * ������λ
	 *//*
	public static String NHZBZD_JLDW;*/
	/*
	 * �豸
	 */
	/**
	 * �Ƿ���̭�豸
	 */
	public static String SBZD_SFTTSB;
	
	static {
		try {
			/*
			 * ��Ʒ
			 */
			CPZD_STARTMARK = res.getString("CPZD_STARTMARK").trim();
			CPZD_CMLB = res.getString("CPZD_CMLB").trim();
			CPZD_SYZT = res.getString("CPZD_SYZT").trim();
			CPZD_ZDLX = res.getString("CPZD_ZDLX").trim();
			CPZD_JLDW = res.getString("CPZD_JLDW").trim();
			/*
			 * ��ҵ
			 */
			HYZD_STARTMARK = res.getString("HYZD_STARTMARK").trim();
			HYZD_ZDHY = res.getString("HYZD_ZDHY").trim();
			HYZD_HYTYPE = res.getString("HYZD_HYTYPE").trim();
			/*
			 * ��Դ
			 */
			/*NYZD_JLDW = res.getString("NYZD_JLDW").trim();*/
			NYZD_SORTTYPE = res.getString("NYZD_SORTTYPE").trim();
			/*
			 * �ܺ�ָ��
			 */
			NHZBZD_ISIMPORTANT = res.getString("NHZBZD_ISIMPORTANT").trim();
			NHZBZD_ISSAVING = res.getString("NHZBZD_ISSAVING").trim();
			/*NHZBZD_JLDW = res.getString("NHZBZD_JLDW").trim();*/
			/*
			 * �豸
			 */
			SBZD_SFTTSB = res.getString("SBZD_SFTTSB").trim();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("IO��ȡ�����Ҳ���sysconfig.properties!");
		}
	}
}
