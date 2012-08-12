package com.bip.sys.login.po;

/**
 * ViewLoginId entity. @author MyEclipse Persistence Tools
 */

public class ViewLoginId implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String username;
	private Integer roleid;
	private Integer permissionid;
	private String resourceid;
	private String resourceno;
	private String presourceno;
	private String resourcename;
	private String link;
	private String remark;
	private String isdelete;
	private String type;
	private String imageurl;
	private String winsize;

	// Constructors

	/** default constructor */
	public ViewLoginId() {
	}

	/** minimal constructor */
	public ViewLoginId(Integer userid, String username, Integer roleid,
			Integer permissionid, String resourceid, String resourceno,
			String presourceno, String resourcename) {
		this.userid = userid;
		this.username = username;
		this.roleid = roleid;
		this.permissionid = permissionid;
		this.resourceid = resourceid;
		this.resourceno = resourceno;
		this.presourceno = presourceno;
		this.resourcename = resourcename;
	}

	/** full constructor */
	public ViewLoginId(Integer userid, String username, Integer roleid,
			Integer permissionid, String resourceid, String resourceno,
			String presourceno, String resourcename, String link,
			String remark, String isdelete, String type, String imageurl,
			String winsize) {
		this.userid = userid;
		this.username = username;
		this.roleid = roleid;
		this.permissionid = permissionid;
		this.resourceid = resourceid;
		this.resourceno = resourceno;
		this.presourceno = presourceno;
		this.resourcename = resourcename;
		this.link = link;
		this.remark = remark;
		this.isdelete = isdelete;
		this.type = type;
		this.imageurl = imageurl;
		this.winsize = winsize;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public String getResourceid() {
		return this.resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public String getResourceno() {
		return this.resourceno;
	}

	public void setResourceno(String resourceno) {
		this.resourceno = resourceno;
	}

	public String getPresourceno() {
		return this.presourceno;
	}

	public void setPresourceno(String presourceno) {
		this.presourceno = presourceno;
	}

	public String getResourcename() {
		return this.resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getWinsize() {
		return this.winsize;
	}

	public void setWinsize(String winsize) {
		this.winsize = winsize;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ViewLoginId))
			return false;
		ViewLoginId castOther = (ViewLoginId) other;

		return ((this.getUserid() == castOther.getUserid()) || (this
				.getUserid() != null
				&& castOther.getUserid() != null && this.getUserid().equals(
				castOther.getUserid())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())))
				&& ((this.getRoleid() == castOther.getRoleid()) || (this
						.getRoleid() != null
						&& castOther.getRoleid() != null && this.getRoleid()
						.equals(castOther.getRoleid())))
				&& ((this.getPermissionid() == castOther.getPermissionid()) || (this
						.getPermissionid() != null
						&& castOther.getPermissionid() != null && this
						.getPermissionid().equals(castOther.getPermissionid())))
				&& ((this.getResourceid() == castOther.getResourceid()) || (this
						.getResourceid() != null
						&& castOther.getResourceid() != null && this
						.getResourceid().equals(castOther.getResourceid())))
				&& ((this.getResourceno() == castOther.getResourceno()) || (this
						.getResourceno() != null
						&& castOther.getResourceno() != null && this
						.getResourceno().equals(castOther.getResourceno())))
				&& ((this.getPresourceno() == castOther.getPresourceno()) || (this
						.getPresourceno() != null
						&& castOther.getPresourceno() != null && this
						.getPresourceno().equals(castOther.getPresourceno())))
				&& ((this.getResourcename() == castOther.getResourcename()) || (this
						.getResourcename() != null
						&& castOther.getResourcename() != null && this
						.getResourcename().equals(castOther.getResourcename())))
				&& ((this.getLink() == castOther.getLink()) || (this.getLink() != null
						&& castOther.getLink() != null && this.getLink()
						.equals(castOther.getLink())))
				&& ((this.getRemark() == castOther.getRemark()) || (this
						.getRemark() != null
						&& castOther.getRemark() != null && this.getRemark()
						.equals(castOther.getRemark())))
				&& ((this.getIsdelete() == castOther.getIsdelete()) || (this
						.getIsdelete() != null
						&& castOther.getIsdelete() != null && this
						.getIsdelete().equals(castOther.getIsdelete())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())))
				&& ((this.getImageurl() == castOther.getImageurl()) || (this
						.getImageurl() != null
						&& castOther.getImageurl() != null && this
						.getImageurl().equals(castOther.getImageurl())))
				&& ((this.getWinsize() == castOther.getWinsize()) || (this
						.getWinsize() != null
						&& castOther.getWinsize() != null && this.getWinsize()
						.equals(castOther.getWinsize())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getRoleid() == null ? 0 : this.getRoleid().hashCode());
		result = 37
				* result
				+ (getPermissionid() == null ? 0 : this.getPermissionid()
						.hashCode());
		result = 37
				* result
				+ (getResourceid() == null ? 0 : this.getResourceid()
						.hashCode());
		result = 37
				* result
				+ (getResourceno() == null ? 0 : this.getResourceno()
						.hashCode());
		result = 37
				* result
				+ (getPresourceno() == null ? 0 : this.getPresourceno()
						.hashCode());
		result = 37
				* result
				+ (getResourcename() == null ? 0 : this.getResourcename()
						.hashCode());
		result = 37 * result
				+ (getLink() == null ? 0 : this.getLink().hashCode());
		result = 37 * result
				+ (getRemark() == null ? 0 : this.getRemark().hashCode());
		result = 37 * result
				+ (getIsdelete() == null ? 0 : this.getIsdelete().hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		result = 37 * result
				+ (getImageurl() == null ? 0 : this.getImageurl().hashCode());
		result = 37 * result
				+ (getWinsize() == null ? 0 : this.getWinsize().hashCode());
		return result;
	}

}