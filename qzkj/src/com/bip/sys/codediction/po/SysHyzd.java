package com.bip.sys.codediction.po;

/**
 * SysHyzd entity. @author MyEclipse Persistence Tools
 */

public class SysHyzd implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6075784614384493678L;
	private Integer id;
	private String hybh;
	private String hymc;
	private String lbbh;
	private String sjbh;
	private String zdhy;
	private String hytype;
	private String startmark;
	private String remark;
	private String res01;
	private String res02;
	private String res03;
	private String res04;
	private String res05;
	private String res06;
	private String pclassName;

	private String cnzdhy;
	private String cnhytype;
	private String cnstartmark;

	// Constructors

	/** default constructor */
	public SysHyzd() {
	}

	/** minimal constructor */

	/** full constructor */
	public SysHyzd(Integer id, String hybh, String hymc, String lbbh,
			String sjbh, String zdhy, String hytype, String startmark,
			String remark, String res01, String res02, String res03,
			String res04, String res05, String res06) {
		this.id = id;
		this.hybh = hybh;
		this.hymc = hymc;
		this.lbbh = lbbh;
		this.sjbh = sjbh;
		this.zdhy = zdhy;
		this.hytype = hytype;
		this.startmark = startmark;
		this.remark = remark;
		this.res01 = res01;
		this.res02 = res02;
		this.res03 = res03;
		this.res04 = res04;
		this.res05 = res05;
		this.res06 = res06;
	}

	// Property accessors

	public String getHybh() {
		return this.hybh;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setHybh(String hybh) {
		this.hybh = hybh;
	}

	public String getHymc() {
		return this.hymc;
	}

	public void setHymc(String hymc) {
		this.hymc = hymc;
	}

	public String getLbbh() {
		return this.lbbh;
	}

	public void setLbbh(String lbbh) {
		this.lbbh = lbbh;
	}

	public String getSjbh() {
		return this.sjbh;
	}

	public void setSjbh(String sjbh) {
		this.sjbh = sjbh;
	}

	public String getZdhy() {
		return this.zdhy;
	}

	public void setZdhy(String zdhy) {
		this.zdhy = zdhy;
	}

	public String getHytype() {
		return this.hytype;
	}

	public void setHytype(String hytype) {
		this.hytype = hytype;
	}

	public String getStartmark() {
		return this.startmark;
	}

	public void setStartmark(String startmark) {
		this.startmark = startmark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getRes06() {
		return this.res06;
	}

	public void setRes06(String res06) {
		this.res06 = res06;
	}

	public String getPclassName() {
		return pclassName;
	}

	public void setPclassName(String pclassName) {
		this.pclassName = pclassName;
	}

	public String getCnzdhy() {
		return cnzdhy;
	}

	public void setCnzdhy(String cnzdhy) {
		this.cnzdhy = cnzdhy;
	}

	public String getCnhytype() {
		return cnhytype;
	}

	public void setCnhytype(String cnhytype) {
		this.cnhytype = cnhytype;
	}

	public String getCnstartmark() {
		return cnstartmark;
	}

	public void setCnstartmark(String cnstartmark) {
		this.cnstartmark = cnstartmark;
	}

}