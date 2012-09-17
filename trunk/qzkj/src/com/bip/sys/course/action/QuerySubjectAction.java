package com.bip.sys.course.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.bip.common.action.baseAction;
import com.bip.common.util.QueryJson;
import com.bip.sys.course.service.SubjectService;

public class QuerySubjectAction extends baseAction {
	private String conditions;
	private QueryJson queryJson;
	
	private SubjectService subjectService;
	/**
	 * ²é
	 */
	public String query() {
		//subjectService.findPageByQuery(hql, countHql, pageSize, startIndex);
		return "success";
	}
	
	
	
	public String getConditions() {
		return conditions;
	}
	public QueryJson getQueryJson() {
		return queryJson;
	}
	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
}
