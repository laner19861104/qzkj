package com.bip.sys.course.action;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
@Controller
public class CourseEntryAction extends baseAction {
	public String courseEntry() {
		try {
			return "success";
		} catch (Exception ex) {
			return "failure";
		}
	}
	public String subjectEntry() {
		try {
			return "success";
		} catch (Exception ex) {
			return "failure";
		}
	}
}
