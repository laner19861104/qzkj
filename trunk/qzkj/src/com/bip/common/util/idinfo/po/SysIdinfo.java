package com.bip.common.util.idinfo.po;

/**
 * SysIdinfo entity. @author MyEclipse Persistence Tools
 */

public class SysIdinfo implements java.io.Serializable {

	// Fields

	private SysIdinfoId id;
	private Integer currentvalue;
	private Integer laststep;

	// Constructors

	/** default constructor */
	public SysIdinfo() {
	}

	/** minimal constructor */
	public SysIdinfo(SysIdinfoId id) {
		this.id = id;
	}

	/** full constructor */
	public SysIdinfo(SysIdinfoId id, Integer currentvalue, Integer laststep) {
		this.id = id;
		this.currentvalue = currentvalue;
		this.laststep = laststep;
	}

	// Property accessors

	public SysIdinfoId getId() {
		return this.id;
	}

	public void setId(SysIdinfoId id) {
		this.id = id;
	}

	public Integer getCurrentvalue() {
		return this.currentvalue;
	}

	public void setCurrentvalue(Integer currentvalue) {
		this.currentvalue = currentvalue;
	}

	public Integer getLaststep() {
		return this.laststep;
	}

	public void setLaststep(Integer laststep) {
		this.laststep = laststep;
	}

}