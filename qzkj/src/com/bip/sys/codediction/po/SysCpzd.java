package com.bip.sys.codediction.po;

/**
 * SysCpzd entity. @author MyEclipse Persistence Tools
 */

public class SysCpzd implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4242350709049512035L;
	private Integer id;
	private String cpbh;
	private String cpmc;
	private String jldw;
	private String dm;
	private String hybh;
	private String remark;
	private String startmark;
	private String zdlx;
	private String res02;
	private String res03;
	private String res04;
	private String cmlb;
	private String syzt;
	private String res01;

	private String cpstartmark;
	private String cpcmlb;
	private String cpsyzt;
	private String cpzdlx;
	private String cpjldw;

	// Constructors

	/** default constructor */
	public SysCpzd() {
	}

	/** minimal constructor */
	public SysCpzd(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SysCpzd(Integer id, String cpbh, String cpmc, String jldw,
			String dm, String hybh, String remark, String startmark,
			String zdlx, String res02, String res03, String res04, String cmlb,
			String syzt, String res01) {
		this.id = id;
		this.cpbh = cpbh;
		this.cpmc = cpmc;
		this.jldw = jldw;
		this.dm = dm;
		this.hybh = hybh;
		this.remark = remark;
		this.startmark = startmark;
		this.zdlx = zdlx;
		this.res02 = res02;
		this.res03 = res03;
		this.res04 = res04;
		this.cmlb = cmlb;
		this.syzt = syzt;
		this.res01 = res01;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpbh() {
		return this.cpbh;
	}

	public void setCpbh(String cpbh) {
		this.cpbh = cpbh;
	}

	public String getCpmc() {
		return this.cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	public String getJldw() {
		return this.jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	public String getDm() {
		return this.dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getHybh() {
		return this.hybh;
	}

	public void setHybh(String hybh) {
		this.hybh = hybh;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStartmark() {
		return this.startmark;
	}

	public void setStartmark(String startmark) {
		this.startmark = startmark;
	}

	public String getZdlx() {
		return this.zdlx;
	}

	public void setZdlx(String zdlx) {
		this.zdlx = zdlx;
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

	public String getCmlb() {
		return this.cmlb;
	}

	public void setCmlb(String cmlb) {
		this.cmlb = cmlb;
	}

	public String getSyzt() {
		return this.syzt;
	}

	public void setSyzt(String syzt) {
		this.syzt = syzt;
	}

	public String getRes01() {
		return this.res01;
	}

	public void setRes01(String res01) {
		this.res01 = res01;
	}

	public String getCpstartmark() {
		return cpstartmark;
	}

	public void setCpstartmark(String cpstartmark) {
		this.cpstartmark = cpstartmark;
	}

	public String getCpcmlb() {
		return cpcmlb;
	}

	public void setCpcmlb(String cpcmlb) {
		this.cpcmlb = cpcmlb;
	}

	public String getCpsyzt() {
		return cpsyzt;
	}

	public void setCpsyzt(String cpsyzt) {
		this.cpsyzt = cpsyzt;
	}

	public String getCpzdlx() {
		return cpzdlx;
	}

	public void setCpzdlx(String cpzdlx) {
		this.cpzdlx = cpzdlx;
	}

	public String getCpjldw() {
		return cpjldw;
	}

	public void setCpjldw(String cpjldw) {
		this.cpjldw = cpjldw;
	}

}