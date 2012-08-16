package com.bip.common.upload.vo;

public class UploadFile {
	private String uuid;
	private String name;
	private String path;
	
	public UploadFile() {
		super();
	}
	public UploadFile(String uuid, String name, String path) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.path = path;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
