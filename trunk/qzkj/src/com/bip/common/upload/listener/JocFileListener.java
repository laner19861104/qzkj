package com.bip.common.upload.listener;

import com.bip.common.upload.po.JocFile;

public interface JocFileListener {
	public int preDelete(JocFile bean);
	public int afterDelete();
	public int onDelete();
}
