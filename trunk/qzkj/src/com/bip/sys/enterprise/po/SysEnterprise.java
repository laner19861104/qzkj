package com.bip.sys.enterprise.po;


/**
 * SysEnterprise entity. @author MyEclipse Persistence Tools
 */

public class SysEnterprise implements java.io.Serializable {

	// Fields

	private int id;
	private String dwbh;
	private String dwmc;
	private String xxdz;
	private String ssqy;
	private String hyfl;
	private String dwlx;
	private String yzbm;
	private String frdb;
	private String zcrq;
	private Double zczj;
	private String email;
	private String description;
	private String zdlb;
	private String res01;
	private String res02;
	private String nhfw;
	private String res04;
	private Double res05;
	private Double res06;
	private String zdlx;
	private String flag;
	private String type;
	private String xxtype;
	private String gxtype;
	private String pxnum;
	private String nd;
	
	private String cnssqy;
	private String cnhyfl;
	private String cndwlx;
	private String cntype;
	private String cnzdlx;
	private String cnzdlb;
	private String cnflag;
	private String cnxxtype;
	private String cnnhfw;
	

	// Constructors

	/** default constructor */
	public SysEnterprise() {
	}

	/** minimal constructor */
	public SysEnterprise(int id) {
		this.id = id;
	}

	// Property accessors

	public SysEnterprise(int id, String dwbh, String dwmc, String xxdz,
			String ssqy, String hyfl, String dwlx, String yzbm, String frdb,
			String zcrq, Double zczj, String email, String description,
			String zdlb, String res01, String res02, String nhfw, String res04,
			Double res05, Double res06, String zdlx, String flag, String type,
			String xxtype, String gxtype, String pxnum, String nd,
			String cnssqy, String cnhyfl, String cndwlx, String cntype,
			String cnzdlx, String cnzdlb, String cnflag, String cnxxtype,
			String cnnhfw) {
		super();
		this.id = id;
		this.dwbh = dwbh;
		this.dwmc = dwmc;
		this.xxdz = xxdz;
		this.ssqy = ssqy;
		this.hyfl = hyfl;
		this.dwlx = dwlx;
		this.yzbm = yzbm;
		this.frdb = frdb;
		this.zcrq = zcrq;
		this.zczj = zczj;
		this.email = email;
		this.description = description;
		this.zdlb = zdlb;
		this.res01 = res01;
		this.res02 = res02;
		this.nhfw = nhfw;
		this.res04 = res04;
		this.res05 = res05;
		this.res06 = res06;
		this.zdlx = zdlx;
		this.flag = flag;
		this.type = type;
		this.xxtype = xxtype;
		this.gxtype = gxtype;
		this.pxnum = pxnum;
		this.nd = nd;
		this.cnssqy = cnssqy;
		this.cnhyfl = cnhyfl;
		this.cndwlx = cndwlx;
		this.cntype = cntype;
		this.cnzdlx = cnzdlx;
		this.cnzdlb = cnzdlb;
		this.cnflag = cnflag;
		this.cnxxtype = cnxxtype;
		this.cnnhfw = cnnhfw;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDwbh() {
		return this.dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	public String getDwmc() {
		return this.dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getXxdz() {
		return this.xxdz;
	}

	public void setXxdz(String xxdz) {
		this.xxdz = xxdz;
	}

	public String getSsqy() {
		return this.ssqy;
	}

	public void setSsqy(String ssqy) {
		this.ssqy = ssqy;
	}

	public String getHyfl() {
		return this.hyfl;
	}

	public void setHyfl(String hyfl) {
		this.hyfl = hyfl;
	}

	public String getDwlx() {
		return this.dwlx;
	}

	public void setDwlx(String dwlx) {
		this.dwlx = dwlx;
	}

	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getFrdb() {
		return this.frdb;
	}

	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}

	public String getZcrq() {
		return this.zcrq;
	}

	public void setZcrq(String zcrq) {
		this.zcrq = zcrq;
	}

	public Double getZczj() {
		return this.zczj;
	}

	public void setZczj(Double zczj) {
		this.zczj = zczj;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getZdlb() {
		return this.zdlb;
	}

	public void setZdlb(String zdlb) {
		this.zdlb = zdlb;
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
	
	public String getRes04() {
		return this.res04;
	}

	public void setRes04(String res04) {
		this.res04 = res04;
	}

	public Double getRes05() {
		return this.res05;
	}

	public void setRes05(Double res05) {
		this.res05 = res05;
	}

	public Double getRes06() {
		return this.res06;
	}

	public void setRes06(Double res06) {
		this.res06 = res06;
	}

	public String getZdlx() {
		return this.zdlx;
	}

	public void setZdlx(String zdlx) {
		this.zdlx = zdlx;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getXxtype() {
		return this.xxtype;
	}

	public void setXxtype(String xxtype) {
		this.xxtype = xxtype;
	}

	public String getGxtype() {
		return this.gxtype;
	}

	public void setGxtype(String gxtype) {
		this.gxtype = gxtype;
	}

	public String getPxnum() {
		return this.pxnum;
	}

	public void setPxnum(String pxnum) {
		this.pxnum = pxnum;
	}

	public String getNd() {
		return this.nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getCnssqy() {
		return cnssqy;
	}

	public void setCnssqy(String cnssqy) {
		this.cnssqy = cnssqy;
	}

	public String getCnhyfl() {
		return cnhyfl;
	}

	public void setCnhyfl(String cnhyfl) {
		this.cnhyfl = cnhyfl;
	}

	public String getCndwlx() {
		return cndwlx;
	}

	public void setCndwlx(String cndwlx) {
		this.cndwlx = cndwlx;
	}

	public String getCntype() {
		return cntype;
	}

	public void setCntype(String cntype) {
		this.cntype = cntype;
	}

	public String getCnzdlx() {
		return cnzdlx;
	}

	public void setCnzdlx(String cnzdlx) {
		this.cnzdlx = cnzdlx;
	}

	public String getCnzdlb() {
		return cnzdlb;
	}

	public void setCnzdlb(String cnzdlb) {
		this.cnzdlb = cnzdlb;
	}

	public String getCnflag() {
		return cnflag;
	}

	public void setCnflag(String cnflag) {
		this.cnflag = cnflag;
	}

	public String getCnxxtype() {
		return cnxxtype;
	}

	public void setCnxxtype(String cnxxtype) {
		this.cnxxtype = cnxxtype;
	}

	public String getNhfw() {
		return nhfw;
	}

	public void setNhfw(String nhfw) {
		this.nhfw = nhfw;
	}

	public String getCnnhfw() {
		return cnnhfw;
	}

	public void setCnnhfw(String cnnhfw) {
		this.cnnhfw = cnnhfw;
	}

}