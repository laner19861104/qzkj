/************************************************************
 * ������UploadAction.java
 *
 * ���Struts2 Action
 * ���ܣ��ļ��ϴ���
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2012-7-21  CFIT-PG   lxt         ����
 *
 * Copyright (c) 2012 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.common.upload.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.upload.service.UploadService;
import com.bip.common.util.ControllerUtil;
@Controller
public class UploadAction extends baseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 753712457851140501L;

	private File file;
	private UploadService uploadService;
	/**
	 * 
	 * ���ܣ��ļ��ϴ�
	 * @return
	 * author��lxt<br>
	 * ���ڣ�2012-7-23
	 * @throws UnsupportedEncodingException 
	 */
	public String upload() throws UnsupportedEncodingException {
		String fname = this.getRequest().getParameter("fname");
		String fsize = this.getRequest().getParameter("fsize");
		String ftype = this.getRequest().getParameter("ftype");
		fname = URLDecoder.decode(URLDecoder.decode(fname, "utf-8"), "utf-8");
		String path = ServletActionContext.getServletContext().getRealPath("/views");
		Map<String, Object> map = uploadService.upload(file, path, 1, fname, ftype, fsize);
		
		ControllerUtil.responseWriter(JSONObject.fromObject(map).toString(), this.getResponse());
		return null;
	}
	/**
	 * 
	 * ���ܣ�ɾ�����ϴ��ļ�
	 * @return
	 * author��lxt<br>
	 * ���ڣ�2012-7-23
	 */
	public String unupload() {
		
		return "success";
	}

	public void setFile(File file) {
		this.file = file;
	}
	@Autowired
	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}
}
