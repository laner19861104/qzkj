package com.bip.common.upload.listenerimpl;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bip.common.upload.listener.UploadListener;
import com.bip.common.upload.po.JocFile;
import com.bip.common.upload.service.JocFileService;
import com.bip.common.upload.vo.UploadFile;
@Component
public class DBUploadListener implements UploadListener {

	private JocFileService jocFileService;
	public int afterUpload(UploadFile uploadFile) {
		// 执行到此，说明文件上传成功，根据传过来的参数入库管理
		JocFile bean = new JocFile();
		bean.setUuid(uploadFile.getUuid());
		bean.setName(uploadFile.getUuid());
		bean.setPath(uploadFile.getPath());
		bean.setRealname(uploadFile.getName());
		bean.setSize(new BigDecimal(uploadFile.getSize()));
		bean.setSuffix(".rmvb");
//		bean.setBelongId(belongId);
//		bean.setUrl(url);
		bean.setUploadDatetime(Calendar.getInstance().getTime().toString());
		try {
			jocFileService.save(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	public int onUpload() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int preUpload() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Autowired
	public void setJocFileService(JocFileService jocFileService) {
		this.jocFileService = jocFileService;
	}

}
