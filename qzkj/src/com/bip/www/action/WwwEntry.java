package com.bip.www.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.QueryJson;
import com.bip.sys.course.po.JocSubject;
import com.bip.sys.course.service.CourseService;
import com.bip.sys.course.service.SubjectService;

@Controller
public class WwwEntry extends baseAction {
	public String index() {
		try {
			List subjectlist = subjectService.find("from JocSubject");
			super.getRequest().setAttribute("subjectlist", subjectlist);
			return "success";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	public String list() {
		try {
			Object subjectcode = super.getRequest().getParameter("subject");
			int i = (null == super.getRequest().getParameter("i")) ? 0 : new Integer(super.getRequest().getParameter("i").toString()).intValue();
			List subjectlist = subjectService.find("from JocSubject");
			String conditions = "1|1" + ((null == subjectcode) ? "" : ("$subjectCode|"+subjectcode.toString()));
			QueryJson queryjson = courseService.findPageByQuery(conditions, 20, i);
			JocSubject subject = null;
			if (null != subjectlist) {
				if (null == subjectcode) {
					subject = (JocSubject)subjectlist.get(0);
				} else {
					subject = subjectService.find("from JocSubject where code='"+subjectcode.toString()+"'").get(0);
				}
			}
			super.getRequest().setAttribute("subjectlist", subjectlist);
			super.getRequest().setAttribute("queryjson", queryjson);
			super.getRequest().setAttribute("subject", subject);
			return "success";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private SubjectService subjectService;
}
