package com.bip.common.util;

public class resultMsg {
public boolean success;
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public String info;
public resultMsg(boolean isSuccess,String info)
{
	this.success=isSuccess;
	this.info=info;
}
}
