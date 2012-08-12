/************************************************************
 * ������UniContant.java
 *
 * ��𣺻�����
 * ���ܣ�����ϵͳ����������
 * 
 *   Ver     �����               ��ҵ��λ            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-12  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.common.util;

import java.util.ResourceBundle;

public class UniContant {
	/*
	 * ���������ļ�
	 */
	public static final String OPTION_FILE_NAME = "sysconfig";
	public static ResourceBundle res = ResourceBundle.getBundle(OPTION_FILE_NAME);
	/*
	 * ����ҳ������
	 */
	public static int pageSize = 15;
	/*
	 * ����Excel��ģ������
	 */
	public static String exceltemplate;// excel��ģ��
	public static int exceltemplatenum;// excel��ģ��

	/* chartͼ�� */
	public static String CHART_ZHEXIAN;// ����ͼ
	public static String CHART_ZHUZHUANG;// ��״ͼ
	/*
	 * ����SYSϵͳ���õ������ֵ�
	 */
	public static String SYS_REEGION;// ϵͳ������
	public static String SYS_SEX;// ϵͳ���Ա�
	public static String SYS_POSTPRIV;// ϵͳ��ְ��
	public static String SYS_EDUCATION;// ϵͳ��ѧ��
	public static String SYS_DEGREE;// ϵͳ��ѧλ
	public static String SYS_TITLE;// ϵͳ��ְ��
	public static String SYS_NATIONAL;// ϵͳ������
	public static String SYS_WFREGION;// ϵͳ��Ϋ������

	public static String SYS_CLASS;// ϵͳ�����̷���
	public static String SYS_STARTMARK;// ϵͳ�����ñ�־
	public static String SYS_FINSTAT;// ϵͳ�������汾

	public static String SYS_TABLE;// ϵͳ���Զ����
	public static String SYS_FIELD;// ϵͳ���Զ�����ֶ�
	public static String SYS_FINSTATTABLE;// ϵͳ���Զ�������
	public static String SYS_FINSTATFIELD;// ϵͳ���Զ��������ֶ�
	public static String SYS_FIELDTYPE;// ϵͳ�����ֶ�����

	public static String SYS_GRADE;//
	public static String SYS_JUDGE;//

	/*
	 * ���岿�������ֵ�
	 */
	public static String DEPT_TYPE;//
	public static String DEPT_LEVEL;//
	/*
	 * ������Դ�����ֵ�
	 */
	public static String RESOURCE_TYPE;//
	/*
	 * ����Ȩ�������ֵ�
	 */
	public static String PERMISSION_ACTIONID;//
	/*
	 * �����ɫ�����ֵ�
	 */
	public static String ROLE_TYPE;//
	/*
	 * �����û������ֵ�
	 */
	public static String USER_POSTPRIV;// SYS_POSTPRIV
	public static String USER_SEX;// SYS_SEX
	public static String USER_HIDEBIRTH;// SYS_STARTMARK
	public static String USER_HIDEMOBILE;// SYS_STARTMARK
	public static String USER_SMSON;// SYS_STARTMARK
	public static String USER_STATE;// �û�_״̬
	public static String USER_REGION;// SYS_REGION
	public static String USER_DUTYTYPE;// �û�_ְ������
	public static String USER_TYPE;// �û�_����

	/*
	 * ������ҵ��λ�����ֵ�
	 */
	public static String ENTERPRISE_QYSC;// ��ҵ����
	public static String ENTERPRISE_HYFLSC;// ��ҵ����
	public static String ENTERPRISE_DWLXSC;// ��λ���ͣ���Ӫ���������ι�˾��
	public static String ENTERPRISE_ZDLBSC;// �ص������Դ�ص�
	public static String ENTERPRISE_ZDLXSC;// �ص����ͣ���ҵ�ص�
	public static String ENTERPRISE_FLAGSC;// ���ñ�־��ͳ�Ʊ�־
	public static String ENTERPRISE_TYPESC;// ��λ��𣺴��͡����͡�С��
	// ��λ����������

	static {
		try {
			
			pageSize = Integer.parseInt((res.getString("pageSize").trim()));
			/*
			 * ��ȡģ������
			 */
			exceltemplate = res.getString("exceltemplate").trim();
			exceltemplatenum = Integer.parseInt(res.getString(
					"exceltemplatenum").trim());
			/** chartͼ�� ���� **/
			CHART_ZHEXIAN = res.getString("CHART_ZHEXIAN").trim();// ����ͼ
			CHART_ZHUZHUANG = res.getString("CHART_ZHUZHUANG").trim();// ��״ͼ
			/*
			 * ����SYSϵͳ���õ������ֵ�
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
			 * ���������ֵ䶨��
			 */
			DEPT_TYPE = res.getString("DEPT_TYPE").trim();
			DEPT_LEVEL = res.getString("DEPT_LEVEL").trim();
			/*
			 * ��Դ�����ֵ䶨��
			 */
			RESOURCE_TYPE = res.getString("RESOURCE_TYPE").trim();
			/*
			 * Ȩ�������ֵ䶨��
			 */
			PERMISSION_ACTIONID = res.getString("PERMISSION_ACTIONID").trim();
			/*
			 * ��ɫ�����ֵ䶨��
			 */
			ROLE_TYPE = res.getString("ROLE_TYPE").trim();
			/*
			 * �û������ֵ䶨��
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
			 * ��ҵ��λ�����ֵ䶨��
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
			System.out.println("IO��ȡ�����Ҳ���sysconfig.properties!");
		}
	}

	/*
	 * �������������
	 */
	public static final String queryok = "��ѯ�ɹ���";
	public static final String addok = "�����ɹ���";
	public static final String editok = "�޸ĳɹ���";
	public static final String delok = "ɾ���ɹ���";
	public static final String queryerror = "��ѯʧ�ܣ���鿴��־��";
	public static final String adderror = "����ʧ�ܣ���鿴��־��";
	public static final String editerror = "�޸�ʧ�ܣ���鿴��־��";
	public static final String delerror = "ɾ��ʧ�ܣ���鿴��־��";
	public static final String codeerror = "�����ֵ��ȡʧ�ܣ���鿴��־��";
	public static final String uppwdok = "�����ѳɹ��޸ģ�";
	public static final String cannotdelerror = "Ȩ�޲��㣬�޷�ɾ����";
	public static final String sessionerror = "session ��ʧЧ�������µ�½��";
	public static final String connerror = "���ݿ�����ʧ�ܣ���鿴�������������";
	public static final String existerror = "�ü�¼�Ѵ��ڣ�";
	public static final String selecterror = "ѡ���¼ʧ�ܣ���ȷ�ϸü�¼���ڣ�";
	public static final String exportexcelsuccess = "��ϲ��excel�����ɹ���";
	public static final String exportexcelfailure = "excel����ʧ�ܣ���鿴��־��";
	public static final String dmzderror = "�����ֵ�ȡֵ����ȷ�����������ļ���";
	public static final String nopermission = "�Բ������޴˲�����Ȩ�ޣ�";

}
