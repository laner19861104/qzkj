package com.bip.common.upload.vo;

public class UploadFile {
	private String uuid;
	private String path;
	private String name;
	private String size;
	private String uploadUser;
	private String baseURL;
	public UploadFile(String uuid) {
		super();
		this.uuid = uuid;
	}
	public UploadFile(String uuid, String path, String name, String size,
			String uploadUser, String baseURL) {
		super();
		this.uuid = uuid;
		this.path = path;
		this.name = name;
		this.size = size;
		this.uploadUser = uploadUser;
		this.baseURL = baseURL;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}
	public String getBaseURL() {
		return baseURL;
	}
	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}
}
