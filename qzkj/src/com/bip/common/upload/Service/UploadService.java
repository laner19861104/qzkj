package com.bip.common.upload.Service;

import java.io.File;

public interface UploadService {
	public Boolean upload(File file, String uploadPath, String filename);
}
