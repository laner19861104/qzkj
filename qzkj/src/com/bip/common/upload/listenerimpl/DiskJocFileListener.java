package com.bip.common.upload.listenerimpl;

import org.springframework.stereotype.Component;

import com.bip.common.upload.listener.JocFileListener;
import com.bip.common.upload.po.JocFile;

@Component
public class DiskJocFileListener implements JocFileListener {

	public int afterDelete() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int onDelete() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int preDelete(JocFile bean) {
		// TODO Auto-generated method stub
		return 0;
	}
}
