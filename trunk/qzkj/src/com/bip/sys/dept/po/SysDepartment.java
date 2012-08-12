package com.bip.sys.dept.po;

/**
 * SysDepartment entity. @author MyEclipse Persistence Tools
 */

public class SysDepartment implements java.io.Serializable {

	// Fields

	private Integer deptid;
	private String deptname;
	private String deptno;
	private String depttype;
	private String deptlevel;
	private String telno;
	private String faxno;
	private String remark;
	private String relap;
	private String relaptelno;
	private String chargep;
	private String chargeptelno;
	private String res01;
	private String res02;
	private String res03;
	private String res04;
	private Double res05;
	private Double res06;
	private String res10;
	private String res11;
	private String res12;
	private String res13;
	private String res14;
	private String res15;
	private String res16;
	private String res17;
	private String res18;
	private String res19;
	private String res20;
	private String parentid;

	private String cndepttype;
	private String cndeptlevel;

	// Constructors

	/** default constructor */
	public SysDepartment() {
	}

	/** minimal constructor */
	public SysDepartment(Integer deptid, String deptname, String deptno) {
		this.deptid = deptid;
		this.deptname = deptname;
		this.deptno = deptno;
	}

	/** full constructor */
	public SysDepartment(Integer deptid, String deptname, String deptno,
			String depttype, String deptlevel, String telno, String faxno,
			String remark, String relap, String relaptelno, String chargep,
			String chargeptelno, String res01, String res02, String res03,
			String res04, Double res05, Double res06, String res10,
			String res11, String res12, String res13, String res14,
			String res15, String res16, String res17, String res18,
			String res19, String res20, String parentid) {
		this.deptid = deptid;
		this.deptname = deptname;
		this.deptno = deptno;
		this.depttype = depttype;
		this.deptlevel = deptlevel;
		this.telno = telno;
		this.faxno = faxno;
		this.remark = remark;
		this.relap = relap;
		this.relaptelno = relaptelno;
		this.chargep = chargep;
		this.chargeptelno = chargeptelno;
		this.res01 = res01;
		this.res02 = res02;
		this.res03 = res03;
		this.res04 = res04;
		this.res05 = res05;
		this.res06 = res06;
		this.res10 = res10;
		this.res11 = res11;
		this.res12 = res12;
		this.res13 = res13;
		this.res14 = res14;
		this.res15 = res15;
		this.res16 = res16;
		this.res17 = res17;
		this.res18 = res18;
		this.res19 = res19;
		this.res20 = res20;
		this.parentid = parentid;
	}

	// Property accessors

	public Integer getDeptid() {
		return this.deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptno() {
		return this.deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDepttype() {
		return this.depttype;
	}

	public void setDepttype(String depttype) {
		this.depttype = depttype;
	}

	public String getDeptlevel() {
		return this.deptlevel;
	}

	public void setDeptlevel(String deptlevel) {
		this.deptlevel = deptlevel;
	}

	public String getTelno() {
		return this.telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getFaxno() {
		return this.faxno;
	}

	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRelap() {
		return this.relap;
	}

	public void setRelap(String relap) {
		this.relap = relap;
	}

	public String getRelaptelno() {
		return this.relaptelno;
	}

	public void setRelaptelno(String relaptelno) {
		this.relaptelno = relaptelno;
	}

	public String getChargep() {
		return this.chargep;
	}

	public void setChargep(String chargep) {
		this.chargep = chargep;
	}

	public String getChargeptelno() {
		return this.chargeptelno;
	}

	public void setChargeptelno(String chargeptelno) {
		this.chargeptelno = chargeptelno;
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

	public String getRes10() {
		return this.res10;
	}

	public void setRes10(String res10) {
		this.res10 = res10;
	}

	public String getRes11() {
		return this.res11;
	}

	public void setRes11(String res11) {
		this.res11 = res11;
	}

	public String getRes12() {
		return this.res12;
	}

	public void setRes12(String res12) {
		this.res12 = res12;
	}

	public String getRes13() {
		return this.res13;
	}

	public void setRes13(String res13) {
		this.res13 = res13;
	}

	public String getRes14() {
		return this.res14;
	}

	public void setRes14(String res14) {
		this.res14 = res14;
	}

	public String getRes15() {
		return this.res15;
	}

	public void setRes15(String res15) {
		this.res15 = res15;
	}

	public String getRes16() {
		return this.res16;
	}

	public void setRes16(String res16) {
		this.res16 = res16;
	}

	public String getRes17() {
		return this.res17;
	}

	public void setRes17(String res17) {
		this.res17 = res17;
	}

	public String getRes18() {
		return this.res18;
	}

	public void setRes18(String res18) {
		this.res18 = res18;
	}

	public String getRes19() {
		return this.res19;
	}

	public void setRes19(String res19) {
		this.res19 = res19;
	}

	public String getRes20() {
		return this.res20;
	}

	public void setRes20(String res20) {
		this.res20 = res20;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getCndepttype() {
		return cndepttype;
	}

	public void setCndepttype(String cndepttype) {
		this.cndepttype = cndepttype;
	}

	public String getCndeptlevel() {
		return cndeptlevel;
	}

	public void setCndeptlevel(String cndeptlevel) {
		this.cndeptlevel = cndeptlevel;
	}

}