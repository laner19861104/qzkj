package com.bip.common.upload.listenerimpl;

import org.springframework.stereotype.Component;

import com.bip.common.upload.listener.UploadListener;
import com.bip.common.upload.vo.UploadFile;
@Component
public class DBUploadListener implements UploadListener {

	public int afterUpload(UploadFile uploadFile) {
		// ִ�е��ˣ�˵���ļ��ϴ��ɹ������ݴ������Ĳ���������
		return 0;
	}

	public int onUpload() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int preUpload() {
		// TODO Auto-generated method stub
		return 0;
	}

}
