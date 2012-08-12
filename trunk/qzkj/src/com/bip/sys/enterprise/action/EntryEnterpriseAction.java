/************************************************************
 * ������EntryEnterpriseAction.java
 *
 * ���Struts2 Action
 * ���ܣ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2011-12-3  CFIT-PG    ��÷             ����
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
	 * ���峣������
	 */
	
	private static final long serialVersionUID = 1L;
	/*
	 * ������� Service
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

	private List ssqysc;// ��������
	private List hyflsc;// ��ҵ����
	private List zdlbsc;// �ص����
	private List zdlxsc;// �ص�����
	private List typesc;// ��λ���
	private List dwlxsc;// ��λ����
	private List nhfw;// �ܺķ�Χ
//	private List xxtypesc;// ������ҵ����
//	private List gxtypesc;// ������ҵ����

	/**
	 * ���
	 * 
	 * @return
	 */
	public String enterpriseEntry() {
		try {
			/*
			 * ��ȡ�����ֵ䣬������ȡ��ֵ����session��
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
