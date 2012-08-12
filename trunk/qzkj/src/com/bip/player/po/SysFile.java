package com.bip.player.po;

import java.sql.Blob;

/**
 * SysFile entity. @author MyEclipse Persistence Tools
 */

public class SysFile implements java.io.Serializable {

	// Fields

	private String uuid;
	private Blob content;
	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	private String name;

	// Constructors

	/** default constructor */
	public SysFile() {
	}

	/** full constructor */
	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}