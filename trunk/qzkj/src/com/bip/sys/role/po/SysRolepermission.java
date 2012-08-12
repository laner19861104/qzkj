package com.bip.sys.role.po;

/**
 * SysRolepermission entity. @author MyEclipse Persistence Tools
 */

public class SysRolepermission implements java.io.Serializable {

	// Fields

	private SysRolepermissionId id;
	private String rolename;
	private String permissionname;
	private String permissionno;

	// Constructors

	/** default constructor */
	public SysRolepermission() {
	}

	/** full constructor */
	public SysRolepermission(SysRolepermissionId id) {
		this.id = id;
	}

	// Property accessors

	public SysRolepermissionId getId() {
		return this.id;
	}

	public void setId(SysRolepermissionId id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getPermissionname() {
		return permissionname;
	}

	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}

	public String getPermissionno() {
		return permissionno;
	}

	public void setPermissionno(String permissionno) {
		this.permissionno = permissionno;
	}

}