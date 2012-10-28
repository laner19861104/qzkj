package com.bip.common.upload.service;

import com.bip.common.upload.po.JocFile;

public interface JocFileService {
	public JocFile save(JocFile bean);
	public JocFile update(JocFile bean);
	public int delete(JocFile bean);
	public int delete(String uuid);
	public JocFile get(String uuid);
}
