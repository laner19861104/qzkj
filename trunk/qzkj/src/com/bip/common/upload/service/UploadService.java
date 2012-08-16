package com.bip.common.upload.service;

import java.io.File;

public interface UploadService {
	public Boolean upload(File file, String uploadPath, String filename);
}
