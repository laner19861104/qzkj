package com.bip.common.util;

import com.bip.common.util.idinfo.service.IdInfoService;
import com.bip.common.util.idinfo.service.PairValue;

public class IdInfo {
	PairValue pairValue = new PairValue();
	private IdInfoService idService;
	public void setIdService(IdInfoService idService) {
		this.idService = idService;
	}
	public IdInfoService getIdService() {
		return idService;
	}

	public  PairValue getIDs(String $tableName, String $fieldName, int range)
			throws Exception {
//		System.out.println("idinfo begin......");
		pairValue = idService.getIDs($tableName, $fieldName, range);
		return pairValue;
	}
}
