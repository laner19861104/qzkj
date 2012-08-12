package com.bip.common.enterpinfo.action;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bip.common.enterpinfo.service.EnterpinfoService;

public class InputExcelAction {
	EnterpinfoService enterpinfoService;

	public EnterpinfoService getEnterpinfoService() {
		return enterpinfoService;
	}

	public void setEnterpinfoService(EnterpinfoService enterpinfoService) {
		this.enterpinfoService = enterpinfoService;
	}

	private File uploadImage;// �õ��ϴ����ļ�
	private String uploadImageContentType;// �õ��ļ�������
	private String uploadImageFileName;// �õ��ļ�������

	public String inputExcel() {

		HttpServletRequest request = ServletActionContext.getRequest();
		// HttpServletResponse response = ServletActionContext.getResponse();

		InputStream in = null;

		try {
			if(uploadImage!=null){
			in = new FileInputStream(uploadImage);
			// out = response.getWriter();

			if (enterpinfoService.DataMove(in) == true) {

				request.setAttribute("massge", "1");

			} else{
				request.setAttribute("massge", "2");
			}
			}else{
				request.setAttribute("massge", "2");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		return "success";
	}

	public File getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getUploadImageContentType() {
		return uploadImageContentType;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}

	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}
}
