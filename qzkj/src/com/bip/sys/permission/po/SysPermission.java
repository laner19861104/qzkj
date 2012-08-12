package com.bip.sys.permission.po;

/**
 * SysPermission entity. @author MyEclipse Persistence Tools
 */

public class SysPermission implements java.io.Serializable {

	// Fields

	private Integer permissionid;
	private String permissionname;
	private String resourceid;
	private String actionid;
	private String permissionno;
	private String ppermissionno;

	private String cnresource;
	private String cnaction;

	// Constructors

	/** default constructor */
	public SysPermission() {
	}

	/** minimal constructor */
	public SysPermission(Integer permissionid, String permissionname,
			String resourceid, String actionid) {
		this.permissionid = permissionid;
		this.permissionname = permissionname;
		this.resourceid = resourceid;
		this.actionid = actionid;
	}

	/** full constructor */
	public SysPermission(Integer permissionid, String permissionname,
			String resourceid, String actionid, String permissionno,
			String ppermissionno) {
		this.permissionid = permissionid;
		this.permissionname = permissionname;
		this.resourceid = resourceid;
		this.actionid = actionid;
		this.permissionno = permissionno;
		this.ppermissionno = ppermissionno;
	}

	// Property accessors

	public Integer getPermissionid() {
		return this.permissionid;
	}

	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}

	public String getPermissionname() {
		return this.permissionname;
	}

	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}

	public String getResourceid() {
		return this.resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public String getActionid() {
		return this.actionid;
	}

	public void setActionid(String actionid) {
		this.actionid = actionid;
	}

	public String getPermissionno() {
		return this.permissionno;
	}

	public void setPermissionno(String permissionno) {
		this.permissionno = permissionno;
	}

	public String getPpermissionno() {
		return this.ppermissionno;
	}

	public void setPpermissionno(String ppermissionno) {
		this.ppermissionno = ppermissionno;
	}

	public String getCnresource() {
		return cnresource;
	}

	public void setCnresource(String cnresource) {
		this.cnresource = cnresource;
	}

	public String getCnaction() {
		return cnaction;
	}

	public void setCnaction(String cnaction) {
		this.cnaction = cnaction;
	}

}