package com.bip.sys.codediction.po;

import java.math.BigDecimal;

/**
 * JobCpzd entity. @author MyEclipse Persistence Tools
 */

public class JobCpzd implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String dwbh;
	private String cpbh;
	private String dwmc;
	private String cpmc;
	private String ssxt;
	private String zdlx;
	private String startmark;
	private String res01;
	private String res02;
	private String res03;
	private String res04;
	private String res05;

	// Constructors

	/** default constructor */
	public JobCpzd() {
	}

	/** minimal constructor */
	public JobCpzd(BigDecimal id) {
		this.id = id;
	}

	/** full constructor */
	public JobCpzd(BigDecimal id, String dwbh, String cpbh, String dwmc,
			String cpmc, String ssxt, String zdlx, String startmark,
			String res01, String res02, String res03, String res04, String res05) {
		this.id = id;
		this.dwbh = dwbh;
		this.cpbh = cpbh;
		this.dwmc = dwmc;
		this.cpmc = cpmc;
		this.ssxt = ssxt;
		this.zdlx = zdlx;
		this.startmark = startmark;
		this.res01 = res01;
		this.res02 = res02;
		this.res03 = res03;
		this.res04 = res04;
		this.res05 = res05;
	}

	// Property accessors

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getDwbh() {
		return this.dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	public String getCpbh() {
		return this.cpbh;
	}

	public void setCpbh(String cpbh) {
		this.cpbh = cpbh;
	}

	public String getDwmc() {
		return this.dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getCpmc() {
		return this.cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	public String getSsxt() {
		return this.ssxt;
	}

	public void setSsxt(String ssxt) {
		this.ssxt = ssxt;
	}

	public String getZdlx() {
		return this.zdlx;
	}

	public void setZdlx(String zdlx) {
		this.zdlx = zdlx;
	}

	public String getStartmark() {
		return this.startmark;
	}

	public void setStartmark(String startmark) {
		this.startmark = startmark;
	}

	public String getRes01() {
		return this.res01;
	}

	public void setRes01(String res01) {
		this.res01 = res01;
	}

	public String getRes02() {
		return this.res02;
	}

	public void setRes02(String res02) {
		this.res02 = res02;
	}

	public String getRes03() {
		return this.res03;
	}

	public void setRes03(String res03) {
		this.res03 = res03;
	}

	public String getRes04() {
		return this.res04;
	}

	public void setRes04(String res04) {
		this.res04 = res04;
	}

	public String getRes05() {
		return this.res05;
	}

	public void setRes05(String res05) {
		this.res05 = res05;
	}

}