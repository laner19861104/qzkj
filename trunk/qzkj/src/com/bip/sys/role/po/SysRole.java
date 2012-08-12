package com.bip.sys.role.po;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String rolename;
	private String title;
	private String description;
	private String type;
	private String deptno;
	private String cntype;
	private String deptname;

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(Integer roleid, String rolename, String title,
			String description, String type) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.title = title;
		this.description = description;
		this.type = type;
	}

	/** full constructor */
	public SysRole(Integer roleid, String rolename, String title,
			String description, String type, String deptno) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.title = title;
		this.description = description;
		this.type = type;
		this.deptno = deptno;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeptno() {
		return this.deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getCntype() {
		return cntype;
	}

	public void setCntype(String cntype) {
		this.cntype = cntype;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}