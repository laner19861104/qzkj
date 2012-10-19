/************************************************************
 * 类名：WwwPayRecordAction.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2012-10-19  CFIT-PG   朱江         初版
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
import com.bip.www.service.WwwPayRecordService;

/**
 * 功能：
 * 作者: zj
 * 日期：2012-10-19
 */
@Controller
public class WwwPayRecordAction extends baseAction{
	private QueryJson queryJson;
    @Resource
    private WwwPayRecordService wwwPayRecordService;

    public String query() {

		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		int row = Integer.parseInt(this.getRequest().getParameter("rows"));// 接受参数page和rows
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
		return "success";
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
