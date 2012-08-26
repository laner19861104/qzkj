package com.bip.common.upload.service;

import java.io.File;
import java.util.Map;

public interface UploadService {
	public Map<String, Object> upload(File file, String uploadPath, int floors, String fname, String ftype, String fsize);
}
