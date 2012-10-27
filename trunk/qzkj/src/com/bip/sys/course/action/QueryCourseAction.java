package com.bip.sys.course.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.QueryJson;
import com.bip.sys.course.po.JocCourse;
import com.bip.sys.course.service.CourseService;
@Controller
public class QueryCourseAction extends baseAction {
	private String conditions;
	private QueryJson queryJson;
	private JocCourse instance;
	private CourseService courseService;
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
		queryJson = courseService.findPageByQuery(conditions, row, (page - 1) * row);
		return "success";
	}
	
	public String get() {
		Integer id = Integer.parseInt(this.getRequest().getParameter("id"));
		instance = courseService.get(id);
		return "success";
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public QueryJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(QueryJson queryJson) {
		this.queryJson = queryJson;
	}

	public JocCourse getInstance() {
		return instance;
	}
	public void setInstance(JocCourse instance) {
		this.instance = instance;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
}
