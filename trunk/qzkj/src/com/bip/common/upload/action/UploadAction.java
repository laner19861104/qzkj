/************************************************************
 * 类名：UploadAction.java
 *
 * 类别：Struts2 Action
 * 功能：文件上传。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2012-7-21  CFIT-PG   lxt         初版
 *
 * Copyright (c) 2012 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.common.upload.action;

import java.io.File;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.upload.service.UploadService;
import com.bip.common.util.resultMsg;
@Controller
public class UploadAction extends baseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 753712457851140501L;

	private resultMsg msg;
	
	private File file;
	private UploadService uploadService;
	/**
	 * 
	 * 功能：文件上传
	 * @return
	 * author：lxt<br>
	 * 日期：2012-7-23
	 */
	public String upload() {
		String filename = this.getRequest().getParameter("filename");
		System.out.println("文件名称：" + filename);
		String path = ServletActionContext.getServletContext().getRealPath("/upppppppppppppppppppppp");
		uploadService.upload(file, path, UUID.randomUUID().toString());
		JSONObject json = new JSONObject();
		json.put("uuid", "文件UUID");
		
		msg = new resultMsg(true, json.toString());
				
		return null;
	}
	/**
	 * 
	 * 功能：删除已上传文件
	 * @return
	 * author：lxt<br>
	 * 日期：2012-7-23
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
	
	public resultMsg getMsg() {
		return msg;
	}
}
