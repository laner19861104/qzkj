package com.bip.sys.course.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.QueryJson;
import com.bip.sys.course.po.JocSubject;
import com.bip.sys.course.service.SubjectService;
@Controller
public class QuerySubjectAction extends baseAction {
	private String conditions;
	private QueryJson queryJson;
	private JocSubject instance;
	private SubjectService subjectService;
	/**
	 * 查
	 */
	public String query() {
		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		int row = Integer.parseInt(this.getRequest().getParameter("rows"));// 接受参数page和rows
		if (conditions != null) {
			try {
				conditions = URLDecoder.decode(
						URLDecoder.decode(conditions, "utf-8"), "utf-8");
			} catch (UnsupportedEncodingException e) {
			
				e.printStackTrace();
			}
		}
		queryJson = subjectService.findPageByQuery(conditions, row, (page - 1) * row);
		return "success";
	}
	
	public String get() {
		Integer id = Integer.parseInt(this.getRequest().getParameter("id"));
		instance = subjectService.get(id);
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
	public JocSubject getInstance() {
		return instance;
	}
	public void setInstance(JocSubject instance) {
		this.instance = instance;
	}
}
