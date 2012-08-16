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
	 * ���ܣ��ļ��ϴ�
	 * @return
	 * author��lxt<br>
	 * ���ڣ�2012-7-23
	 */
	public String upload() {
		String filename = this.getRequest().getParameter("filename");
		System.out.println("�ļ����ƣ�" + filename);
		String path = ServletActionContext.getServletContext().getRealPath("/upppppppppppppppppppppp");
		uploadService.upload(file, path, UUID.randomUUID().toString());
		JSONObject json = new JSONObject();
		json.put("uuid", "�ļ�UUID");
		
		msg = new resultMsg(true, json.toString());
				
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
	
	public resultMsg getMsg() {
		return msg;
	}
}
