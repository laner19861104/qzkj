/************************************************************
 * 类名：UploadServiceImpl.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日     部门    担当者  変更内容
 * ──────────────────────────────────────────────
 *   V1.00 2011-11-25 CFIT-PM   rcl     初版
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.common.upload.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bip.common.upload.listener.UploadListener;
import com.bip.common.upload.service.UploadService;
import com.bip.common.upload.vo.UploadFile;
@Service
public class UploadServiceImpl implements UploadService {

	private List<UploadListener> listeners;
	
	public Map<String, Object> upload(File file, String fpath, int floors, String fname, String ftype, String fsize) {
		boolean haslisteners = true;//是否配置了监听
		if (null == listeners || 0 == listeners.size()) {
			haslisteners = false;
		}
		
		if (haslisteners) {
			for (UploadListener l : this.listeners) {
				l.preUpload();
			}
		}
		if (haslisteners) {
			for (UploadListener l : this.listeners) {
				l.onUpload();
			}
		}
		String uuid = UUID.randomUUID().toString();//bean的id,也是物理文件的文件名
		String name = fname.replace(ftype, "");//用于显示的文件名
		String filename = uuid + ftype;//便于以后添加后缀
		String filepath = fpath;
//		if (0 < floors) {
//			for (int i = floors; i > 0; i--) {
//				filepath = filepath + "/" + UUID.randomUUID();
//			}
//		}
		String path = filepath + "/" + filename;
		boolean ius = this.excuteUpload(file, filepath, filename);
		
		if (!ius) {
			return null;
		}
		
		if (haslisteners) {
			for (UploadListener l : this.listeners) {
				l.afterUpload(new UploadFile(uuid, path, name, fsize, null, null));
			}
		}
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("uuid", uuid);
		rmap.put("name", fname);
		rmap.put("size", fsize);
		return rmap;
	}
	
	
	/*
	 * file为文件，uploadPath为服务器端存放文件的目录，filename为文件名(包括文件格式)
	 * 
	 * @see com.bip.common.upload.Service.UploadService#upload(java.io.File,
	 *      java.lang.String)
	 */
	public Boolean excuteUpload(File file, String uploadPath, String filename) {
		try {
			InputStream is = new FileInputStream(file);// 根据上传文件获得输入流
			String dir = uploadPath + "/" + filename; // 文件的全路径
			/*
			 * 判断服务器端路径是否存在：
			 * 1、存在，判断该文件是否已存在，若存在删除文件，在后面重新写入
			 * 2、不存在，创建路径，并判断是否创建成功
			 */
			File filepath = new File(uploadPath);
			if (!filepath.exists()) {
				if (!filepath.mkdirs()) {
					return false;
				}
			} else {
				File f = new File(dir);
				if (f.exists()) {
					f.delete();
				}
			}
			OutputStream os = new FileOutputStream(dir);// 指定输出流地址
			/*
			 * 将文件写到指定地址
			 */
			byte buffer[] = new byte[1024];
			int count = 0;
			while ((count = is.read(buffer)) > 0) {
				os.write(buffer, 0, count);
			}
			os.close();
			is.close();
			File f = new File(dir);
			if (f.exists()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	@Autowired
	public void setListeners(List<UploadListener> listeners) {
		this.listeners = listeners;
	}
}
