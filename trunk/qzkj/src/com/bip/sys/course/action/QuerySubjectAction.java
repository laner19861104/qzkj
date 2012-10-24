package com.bip.sys.course.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.QueryJson;
import com.bip.sys.course.service.SubjectService;
@Controller
public class QuerySubjectAction extends baseAction {
	private String conditions;
	private QueryJson queryJson;
	
	private SubjectService subjectService;
	/**
	 * 查
	 */
	public String query() {
		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		int row = Integer.parseInt(this.getRequest().getParameter("rows"));// 接受参数page和rows

//		subjectService.findPageByQuery(hql, countHql, pageSize, startIndex);
		return "success";
	}
	
	
	
	public String getConditions() {
		return conditions;
	}
	public QueryJson getQueryJson() {
		return queryJson;
	}
	public SubjectService getSubjectService() {
		return subjectService;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public void setQueryJson(QueryJson queryJson) {
		this.queryJson = queryJson;
	}
	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
}
