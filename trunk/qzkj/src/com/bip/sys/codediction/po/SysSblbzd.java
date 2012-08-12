/************************************************************
 * 类名：SysSblbzd.java
 *
 * 类别：Hibernate PO
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2012-2-24  CFIT-PG    刘学堂               初版
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
	 * 设备类别编号
	 */
	private String sblb;

	/**
	 * 类别名称
	 */
	private String lbmc;

	/**
	 * 是否淘汰设备编号
	 */
	private String sfttsb;
	
	/**
	 * 是否淘汰设备文字
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