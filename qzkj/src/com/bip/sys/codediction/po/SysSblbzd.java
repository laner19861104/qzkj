/************************************************************
 * ������SysSblbzd.java
 *
 * ���Hibernate PO
 * ���ܣ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2012-2-24  CFIT-PG    ��ѧ��               ����
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.codediction.po;

public class SysSblbzd implements java.io.Serializable {

	private static final long serialVersionUID = -8178514751393621924L;

	/**
	 * ID
	 */
	private Integer id;
	
	/**
	 * �豸�����
	 */
	private String sblb;

	/**
	 * �������
	 */
	private String lbmc;

	/**
	 * �Ƿ���̭�豸���
	 */
	private String sfttsb;
	
	/**
	 * �Ƿ���̭�豸����
	 */
	private String cnsfttsb;

	public SysSblbzd() {
		super();
	}

	public SysSblbzd(Integer id) {
		super();
		this.id = id;
	}

	public SysSblbzd(Integer id, String sblb) {
		super();
		this.id = id;
		this.sblb = sblb;
	}

	public SysSblbzd(Integer id, String sblb, String lbmc) {
		super();
		this.id = id;
		this.sblb = sblb;
		this.lbmc = lbmc;
	}

	public SysSblbzd(Integer id, String sblb, String lbmc, String sfttsb) {
		super();
		this.id = id;
		this.sblb = sblb;
		this.lbmc = lbmc;
		this.sfttsb = sfttsb;
	}

	public SysSblbzd(Integer id, String sblb, String lbmc, String sfttsb,
			String cnsfttsb) {
		super();
		this.id = id;
		this.sblb = sblb;
		this.lbmc = lbmc;
		this.sfttsb = sfttsb;
		this.cnsfttsb = cnsfttsb;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSblb() {
		return sblb;
	}

	public void setSblb(String sblb) {
		this.sblb = sblb;
	}

	public String getLbmc() {
		return lbmc;
	}

	public void setLbmc(String lbmc) {
		this.lbmc = lbmc;
	}

	public String getSfttsb() {
		return sfttsb;
	}

	public void setSfttsb(String sfttsb) {
		this.sfttsb = sfttsb;
	}

	public String getCnsfttsb() {
		return cnsfttsb;
	}

	public void setCnsfttsb(String cnsfttsb) {
		this.cnsfttsb = cnsfttsb;
	}
	
}