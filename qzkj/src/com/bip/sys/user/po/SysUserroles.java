package com.bip.sys.user.po;

/**
 * SysUserroles entity. @author MyEclipse Persistence Tools
 */

public class SysUserroles implements java.io.Serializable {

	// Fields

	private SysUserrolesId id;
	private String rolename;

	public SysUserroles() {

	}

	public SysUserroles(SysUserrolesId id, String rolename) {
		super();
		this.id = id;
		this.rolename = rolename;
	}

	public SysUserrolesId getId() {
		return id;
	}

	public void setId(SysUserrolesId id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}