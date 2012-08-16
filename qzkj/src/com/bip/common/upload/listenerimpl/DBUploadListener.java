package com.bip.common.upload.listenerimpl;

import org.springframework.stereotype.Component;

import com.bip.common.upload.listener.UploadListener;
import com.bip.common.upload.vo.UploadFile;
@Component
public class DBUploadListener implements UploadListener {

	public int afterUpload(UploadFile uploadFile) {
		// 执行到此，说明文件上传成功，根据传过来的参数入库管理
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
