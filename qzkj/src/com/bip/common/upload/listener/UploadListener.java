package com.bip.common.upload.listener;

import com.bip.common.upload.vo.UploadFile;

public interface UploadListener {
	public int preUpload();
	public int afterUpload(UploadFile uploadFile);
	public int onUpload();
}
