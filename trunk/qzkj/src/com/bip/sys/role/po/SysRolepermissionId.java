package com.bip.sys.role.po;

/**
 * SysRolepermissionId entity. @author MyEclipse Persistence Tools
 */

public class SysRolepermissionId implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private Integer permissionid;
	

	// Constructors

	/** default constructor */
	public SysRolepermissionId() {
	}

	/** full constructor */
	public SysRolepermissionId(Integer roleid, Integer permissionid) {
		this.roleid = roleid;
		this.permissionid = permissionid;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getPermissionid() {
		return this.permissionid;
	}

	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SysRolepermissionId))
			return false;
		SysRolepermissionId castOther = (SysRolepermissionId) other;

		return ((this.getRoleid() == castOther.getRoleid()) || (this
				.getRoleid() != null
				&& castOther.getRoleid() != null && this.getRoleid().equals(
				castOther.getRoleid())))
				&& ((this.getPermissionid() == castOther.getPermissionid()) || (this
						.getPermissionid() != null
						&& castOther.getPermissionid() != null && this
						.getPermissionid().equals(castOther.getPermissionid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRoleid() == null ? 0 : this.getRoleid().hashCode());
		result = 37
				* result
				+ (getPermissionid() == null ? 0 : this.getPermissionid()
						.hashCode());
		return result;
	}

}