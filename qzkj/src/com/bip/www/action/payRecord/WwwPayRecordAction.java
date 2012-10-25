/************************************************************
 * ������WwwPayRecordAction.java
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
package com.bip.www.action.payRecord;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.QueryJson;
import com.bip.common.util.resultMsg;
import com.bip.www.service.WwwPayRecordService;

/**
 * ���ܣ�
 * ����: zj
 * ���ڣ�2012-10-19
 */
@Controller
public class WwwPayRecordAction extends baseAction{
	private QueryJson queryJson;
	private resultMsg msg;
    public resultMsg getMsg() {
		return msg;
	}
	public void setMsg(resultMsg msg) {
		this.msg = msg;
	}

	@Resource
    private WwwPayRecordService wwwPayRecordService;

    public String query() {
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
		queryJson = (QueryJson) wwwPayRecordService.findPageByQuery(conditions, row,
				(page - 1) * row);
		queryJson.setRow(row);
		queryJson.setPage(page);
		return "success";
	}
    public String pay()
    {
    	double money=Double.parseDouble(this.getRequest().getParameter("money"));
    	boolean flag=this.wwwPayRecordService.pay(money,this.getWwwUser());
    	if(flag)
    	{
    		msg=new resultMsg(true,"�ɷѳɹ�!");
    		return "success";
    	}
    	else
    	{
    		msg=new resultMsg(true,"�ɷ�ʧ��!");
    		return "failure";
    	}
    }

public WwwPayRecordService getWwwPayRecordService() {
	return wwwPayRecordService;
}

public void setWwwPayRecordService(WwwPayRecordService wwwPayRecordService) {
	this.wwwPayRecordService = wwwPayRecordService;
}
public QueryJson getQueryJson() {
	return queryJson;
}

public void setQueryJson(QueryJson queryJson) {
	this.queryJson = queryJson;
}

}