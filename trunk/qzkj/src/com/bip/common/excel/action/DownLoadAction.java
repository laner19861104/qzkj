package com.bip.common.excel.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport {

	private final static String DOWNLOADFILEPATH = "/templates/systplexcel/"; // 下载文件原始存放路径
	private String fileName; // 文件名参数变量
	InputStream downloadFile;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// 从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadFile() {
		return ServletActionContext.getServletContext().getResourceAsStream(
				DOWNLOADFILEPATH + fileName);
	}

	// 如果下载文件名为中文，进行字符编码转换
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