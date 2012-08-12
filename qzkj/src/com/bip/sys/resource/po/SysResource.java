package com.bip.sys.resource.po;

/**
 * SysResource entity. @author MyEclipse Persistence Tools
 */

public class SysResource implements java.io.Serializable {

	// Fields

	private Integer resourceid;
	private String resourceno;
	private String presourceno;
	private String resourcename;
	private String link;
	private String remark;
	private String isdelete;
	private String type;
	private String imageurl;
	private String winsize;
	
	private String cnresourcetype;

	// Constructors

	/** default constructor */
	public SysResource() {
	}

	/** minimal constructor */
	public SysResource(Integer resourceid, String resourceno,
			String presourceno, String resourcename) {
		this.resourceid = resourceid;
		this.resourceno = resourceno;
		this.presourceno = presourceno;
		this.resourcename = resourcename;
	}

	/** full constructor */
	public SysResource(Integer resourceid, String resourceno,
			String presourceno, String resourcename, String link,
			String remark, String isdelete, String type, String imageurl,
			String winsize) {
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

	public Integer getResourceid() {
		return this.resourceid;
	}

	public void setResourceid(Integer resourceid) {
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

	public String getCnresourcetype() {
		return cnresourcetype;
	}

	public void setCnresourcetype(String cnresourcetype) {
		this.cnresourcetype = cnresourcetype;
	}

}