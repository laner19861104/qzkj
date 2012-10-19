/************************************************************
 * ������WwwConsumptionRecordAction.java
 *
 * ���Struts2 Action
 * ���ܣ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2012-10-19  CFIT-PG   �콭         ����
 *
 * Copyright (c) 2012 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.www.action.WwwConsumptionRecord;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.QueryJson;
import com.bip.www.service.WwwConsumptionRecordService;

/**
 * ���ܣ�
 * ����: zj
 * ���ڣ�2012-10-19
 */
@Controller
public class WwwConsumptionRecordAction extends baseAction{
	private QueryJson queryJson;
public QueryJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(QueryJson queryJson) {
		this.queryJson = queryJson;
	}

@Resource
private WwwConsumptionRecordService wwwConsumptionRecordService;
public String query()
{
	int page = Integer.parseInt(this.getRequest().getParameter("page"));
	int row = Integer.parseInt(this.getRequest().getParameter("rows"));// ���ܲ���page��rows
	String conditions = this.getRequest().getParameter("conditions");
	if (conditions != null)
		try {
			conditions = URLDecoder.decode(
					URLDecoder.decode(conditions, "utf-8"), "utf-8");
		} catch (UnsupportedEncodingException e) {
		
			e.printStackTrace();
		}
	queryJson = (QueryJson) wwwConsumptionRecordService.findPageByQuery(conditions, row,
			(page - 1) * row);
	return "success";
}

public WwwConsumptionRecordService getWwwConsumptionRecordService() {
	return wwwConsumptionRecordService;
}

public void setWwwConsumptionRecordService(
		WwwConsumptionRecordService wwwConsumptionRecordService) {
	this.wwwConsumptionRecordService = wwwConsumptionRecordService;
}
}
