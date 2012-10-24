package com.bip.sys.course.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.SqlUtil;
import com.bip.common.util.UniContant;
import com.bip.common.util.resultMsg;
import com.bip.sys.course.po.JocSubject;
import com.bip.sys.course.service.SubjectService;
@Controller
public class EditSubjectAction extends baseAction {
	private resultMsg msg;
	
	private SubjectService subjectService;
	/**
	 * 增
	 */
	public String add() {
		try {
			/*
			 * 将页面值转换成po对象
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			JocSubject addpo = new JocSubject();
			SqlUtil sqlUtil = new SqlUtil();
			addpo = (JocSubject)sqlUtil.getObjByMap(map, addpo);
			
			Serializable a = subjectService.save(addpo);
			if ((Integer) a > 0) {
				msg=new resultMsg(true, UniContant.addok);
			} else {
				msg=new resultMsg(true, UniContant.adderror);
			}
		} catch (Exception e) {
			msg=new resultMsg(true, UniContant.adderror);
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 删
	 */
	public String del() {
		try {
			String ids = super.getRequest().getParameter("ids");
			int count = subjectService.delete(ids);
			msg = new resultMsg(true, count + "条数据" + UniContant.delok);
		} catch (Exception e) {
			msg = new resultMsg(true, UniContant.delerror);
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 改
	 */
	public String edit() {
		try {
			/*
			 * 将页面值转换成po对象
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			JocSubject addpo = new JocSubject();
			SqlUtil sqlUtil = new SqlUtil();
			addpo = (JocSubject)sqlUtil.getObjByMap(map, addpo);
			
			subjectService.update(addpo);
			msg = new resultMsg(true, UniContant.editok);
		} catch (Exception e) {
			msg = new resultMsg(true, UniContant.editerror);
			e.printStackTrace();
		}
		return "success";
	}
	
	
	
	public resultMsg getMsg() {
		return msg;
	}
	public void setMsg(resultMsg msg) {
		this.msg = msg;
	}
	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
}
