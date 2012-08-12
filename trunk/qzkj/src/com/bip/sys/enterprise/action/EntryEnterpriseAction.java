/************************************************************
 * 类名：EntryEnterpriseAction.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2011-12-3  CFIT-PG    赵梅             初版
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.enterprise.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.UniContant;
import com.bip.sys.codediction.dmzd.service.DmzdService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EntryEnterpriseAction extends baseAction {

	/*
	 * 定义常量变量
	 */
	
	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private DmzdService dmzdService;

	public DmzdService getDmzdService() {
		return dmzdService;
	}

	public void setDmzdService(DmzdService dmzdService) {
		this.dmzdService = dmzdService;
	}

	private String message;

	private List ssqysc;// 所属区域
	private List hyflsc;// 行业分类
	private List zdlbsc;// 重点类别
	private List zdlxsc;// 重点类型
	private List typesc;// 单位类别
	private List dwlxsc;// 单位类型
	private List nhfw;// 能耗范围
//	private List xxtypesc;// 新兴企业类型
//	private List gxtypesc;// 高新企业类型

	/**
	 * 入口
	 * 
	 * @return
	 */
	public String enterpriseEntry() {
		try {
			/*
			 * 读取数据字典，并将获取的值放入session中
			 */
			List rlist1 = dmzdService.findEnterpriseSc();
			if (rlist1 == null || rlist1.size() < 6) {
				this.setMessage(UniContant.dmzderror);
				return "failure";
			}

			ssqysc = (List) rlist1.get(0);
			hyflsc = (List) rlist1.get(1);
			zdlbsc = (List) rlist1.get(2);
			zdlxsc = (List) rlist1.get(3);
			typesc = (List) rlist1.get(4);
			dwlxsc = (List) rlist1.get(5);
			nhfw=(List) rlist1.get(6);
			//xxtypesc = (List) rlist1.get(6);
			//gxtypesc = (List) rlist1.get(7);

			this.getSession().setAttribute("ssqysc", ssqysc);
			this.getSession().setAttribute("hyflsc", hyflsc);
			this.getSession().setAttribute("zdlbsc", zdlbsc);
			this.getSession().setAttribute("zdlxsc", zdlxsc);
			this.getSession().setAttribute("typesc", typesc);
			this.getSession().setAttribute("dwlxsc", dwlxsc);
			this.getSession().setAttribute("nhfw", nhfw);
			//session.setAttribute("xxtypesc", xxtypesc);
			//session.setAttribute("gxtypesc", gxtypesc);

			return "success";
		} catch (Exception ex) {
			ex.printStackTrace();
			this.setMessage(UniContant.connerror);
			return "failure";
		}
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List getSsqysc() {
		return ssqysc;
	}

	public void setSsqysc(List ssqysc) {
		this.ssqysc = ssqysc;
	}

	public List getHyflsc() {
		return hyflsc;
	}

	public void setHyflsc(List hyflsc) {
		this.hyflsc = hyflsc;
	}

	public List getZdlbsc() {
		return zdlbsc;
	}

	public void setZdlbsc(List zdlbsc) {
		this.zdlbsc = zdlbsc;
	}

	public List getZdlxsc() {
		return zdlxsc;
	}

	public void setZdlxsc(List zdlxsc) {
		this.zdlxsc = zdlxsc;
	}

	public List getTypesc() {
		return typesc;
	}

	public void setTypesc(List typesc) {
		this.typesc = typesc;
	}

	public List getDwlxsc() {
		return dwlxsc;
	}

	public void setDwlxsc(List dwlxsc) {
		this.dwlxsc = dwlxsc;
	}

}
