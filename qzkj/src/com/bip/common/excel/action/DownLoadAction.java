package com.bip.common.excel.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport {

	private final static String DOWNLOADFILEPATH = "/templates/systplexcel/"; // �����ļ�ԭʼ���·��
	private String fileName; // �ļ�����������
	InputStream downloadFile;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// �������ļ�ԭʼ���·����ȡ�õ��ļ������
	public InputStream getDownloadFile() {
		return ServletActionContext.getServletContext().getResourceAsStream(
				DOWNLOADFILEPATH + fileName);
	}

	// ��������ļ���Ϊ���ģ������ַ�����ת��
	public String getDownloadChineseFileName() {
		String downloadChineseFileName = fileName;
		try {
			downloadChineseFileName = new String(downloadChineseFileName
					.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return downloadChineseFileName;
	}

	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			String fname = request.getParameter("filename");

			this.setFileName(new String(fname.getBytes("ISO-8859-1"), "GBK")
					+ ".xls");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}

}