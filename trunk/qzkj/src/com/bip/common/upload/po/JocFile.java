package com.bip.common.upload.po;

import java.math.BigDecimal;

/**
 * JocFile entity. @author MyEclipse Persistence Tools
 */

public class JocFile implements java.io.Serializable {

	// Fields

	private String uuid;
	private String path;
	private String realname;
	private String url;
	private String name;
	private String suffix;
	private String belongId;
	private BigDecimal size;
	private Long priority;
	private String uploadUser;
	private String uploadDatetime;

	// Constructors

	/** default constructor */
	public JocFile() {
	}

	/** full constructor */
	public JocFile(String path, String realname, String url, String name,
			String suffix, String belongId, BigDecimal size, Long priority,
			String uploadUser, String uploadDatetime) {
		this.path = path;
		this.realname = realname;
		this.url = url;
		this.name = name;
		this.suffix = suffix;
		this.belongId = belongId;
		this.size = size;
		this.priority = priority;
		this.uploadUser = uploadUser;
		this.uploadDatetime = uploadDatetime;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getBelongId() {
		return this.belongId;
	}

	public void setBelongId(String belongId) {
		this.belongId = belongId;
	}

	public BigDecimal getSize() {
		return this.size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public Long getPriority() {
		return this.priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public String getUploadUser() {
		return this.uploadUser;
	}

	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}

	public String getUploadDatetime() {
		return this.uploadDatetime;
	}

	public void setUploadDatetime(String uploadDatetime) {
		this.uploadDatetime = uploadDatetime;
	}

}