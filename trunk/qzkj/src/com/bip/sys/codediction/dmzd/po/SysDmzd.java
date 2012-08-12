package com.bip.sys.codediction.dmzd.po;

/**
 * SysDmzd entity. @author MyEclipse Persistence Tools
 */

public class SysDmzd implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bh;
	private String mc;
	private String lbbh;
	private Double jsxs;
	private String className;
	private String sscy;
	private String sjbh;
	private String zdlx;
	private String startmark;
	private String remark;
	private String ssxt;
	private String qzgy;
	private String items;
	private String pclassName;

	private String cnstartmark;

	// Constructors

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	/** default constructor */
	public SysDmzd() {
	}

	/** minimal constructor */
	public SysDmzd(Integer id, String bh) {
		this.id = id;
		this.bh = bh;
	}

	/** full constructor */
	public SysDmzd(Integer id, String bh, String mc, String lbbh, Double jsxs) {
		this.id = id;
		this.bh = bh;
		this.mc = mc;
		this.lbbh = lbbh;
		this.jsxs = jsxs;
	}

	// Property accessors

	public String getBh() {
		return this.bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	public String getMc() {
		return this.mc;
	}

	public String getPclassName() {
		return pclassName;
	}

	public void setPclassName(String pclassName) {
		this.pclassName = pclassName;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getLbbh() {
		return this.lbbh;
	}

	public void setLbbh(String lbbh) {
		this.lbbh = lbbh;
	}

	public Double getJsxs() {
		return this.jsxs;
	}

	public void setJsxs(Double jsxs) {
		this.jsxs = jsxs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSjbh() {
		return sjbh;
	}

	public void setSjbh(String sjbh) {
		this.sjbh = sjbh;
	}

	public String getSscy() {
		return sscy;
	}

	public void setSscy(String sscy) {
		this.sscy = sscy;
	}

	public String getStartmark() {
		return startmark;
	}

	public void setStartmark(String startmark) {
		this.startmark = startmark;
	}

	public String getZdlx() {
		return zdlx;
	}

	public void setZdlx(String zdlx) {
		this.zdlx = zdlx;
	}

	public String getQzgy() {
		return qzgy;
	}

	public void setQzgy(String qzgy) {
		this.qzgy = qzgy;
	}

	public String getSsxt() {
		return ssxt;
	}

	public void setSsxt(String ssxt) {
		this.ssxt = ssxt;
	}

	public String getCnstartmark() {
		return cnstartmark;
	}

	public void setCnstartmark(String cnstartmark) {
		this.cnstartmark = cnstartmark;
	}

}