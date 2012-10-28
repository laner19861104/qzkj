/************************************************************
 * ������UploadServiceImpl.java
 *
 * ���Struts2 Action
 * ���ܣ�
 * 
 *   Ver     �����     ����    ������  �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00 2011-11-25 CFIT-PM   rcl     ����
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
		boolean haslisteners = true;//�Ƿ������˼���
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
		String uuid = UUID.randomUUID().toString();//bean��id,Ҳ�������ļ����ļ���
		String name = fname.replace(ftype, "");//������ʾ���ļ���
		String filename = uuid + ftype;//�����Ժ���Ӻ�׺
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
	 * fileΪ�ļ���uploadPathΪ�������˴���ļ���Ŀ¼��filenameΪ�ļ���(�����ļ���ʽ)
	 * 
	 * @see com.bip.common.upload.Service.UploadService#upload(java.io.File,
	 *      java.lang.String)
	 */
	public Boolean excuteUpload(File file, String uploadPath, String filename) {
		try {
			InputStream is = new FileInputStream(file);// �����ϴ��ļ����������
			String dir = uploadPath + "/" + filename; // �ļ���ȫ·��
			/*
			 * �жϷ�������·���Ƿ���ڣ�
			 * 1�����ڣ��жϸ��ļ��Ƿ��Ѵ��ڣ�������ɾ���ļ����ں�������д��
			 * 2�������ڣ�����·�������ж��Ƿ񴴽��ɹ�
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
			OutputStream os = new FileOutputStream(dir);// ָ���������ַ
			/*
			 * ���ļ�д��ָ����ַ
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
