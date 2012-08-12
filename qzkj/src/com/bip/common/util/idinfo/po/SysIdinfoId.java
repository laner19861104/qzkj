package com.bip.common.util.idinfo.po;

/**
 * SysIdinfoId entity. @author MyEclipse Persistence Tools
 */

public class SysIdinfoId implements java.io.Serializable {

	// Fields

	private String tablename;
	private String fieldname;

	// Constructors

	/** default constructor */
	public SysIdinfoId() {
	}

	/** full constructor */
	public SysIdinfoId(String tablename, String fieldname) {
		this.tablename = tablename;
		this.fieldname = fieldname;
	}

	// Property accessors

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getFieldname() {
		return this.fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SysIdinfoId))
			return false;
		SysIdinfoId castOther = (SysIdinfoId) other;

		return ((this.getTablename() == castOther.getTablename()) || (this
				.getTablename() != null
				&& castOther.getTablename() != null && this.getTablename()
				.equals(castOther.getTablename())))
				&& ((this.getFieldname() == castOther.getFieldname()) || (this
						.getFieldname() != null
						&& castOther.getFieldname() != null && this
						.getFieldname().equals(castOther.getFieldname())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTablename() == null ? 0 : this.getTablename().hashCode());
		result = 37 * result
				+ (getFieldname() == null ? 0 : this.getFieldname().hashCode());
		return result;
	}

}