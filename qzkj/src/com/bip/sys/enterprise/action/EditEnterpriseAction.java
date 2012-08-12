
package com.bip.sys.enterprise.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.sys.enterprise.po.SysEnterprise;
import com.bip.sys.enterprise.service.EnterpriseService;
import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.SqlUtil;
import com.bip.common.util.UniContant;
import com.bip.common.util.resultMsg;
import com.bip.common.util.idinfo.service.IdInfoService;
import com.bip.common.util.idinfo.service.PairValue;
import com.bip.common.util.idinfo.serviceimpl.IdInfoServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EditEnterpriseAction extends baseAction {

	
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private IdInfoService idService;
	private resultMsg msg;
	
	/*
	 * ���
	 */
	public String add() {
		try {
			/*
			 * ��ҳ��ֵת����po����
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysEnterprise addpo = new SysEnterprise();
			SysEnterprise po = (SysEnterprise) sqlUtil.getObjByMap(map, addpo);
			/*
			 * ȡ���ݱ�������Ҫ������ID
			 */
			PairValue pv = idService.getIDs("job_enterprise", "id", 1);
			long id = pv.max;
			po.setId(Integer.parseInt(id+""));
			/*
			 * ִ�����ݿ�д������������ݷ���ֵ���гɹ���ʧ�ܴ���
			 */
			Serializable a = enterpriseService.save(po);
			if ((Integer) a > 0) {
				msg=new resultMsg(true, UniContant.addok);
			} else {
				msg=new resultMsg(true, UniContant.adderror);
			}
		} catch (Exception ex) {
				msg=new resultMsg(true, UniContant.adderror);
		}
		return "success";

	}

	/*
	 * �޸�
	 */
	public String update() {
		try {
			/*
			 * ��ҳ��ֵת����po����
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysEnterprise addpo = new SysEnterprise();
			SysEnterprise po = (SysEnterprise) sqlUtil.getObjByMap(map, addpo);
			enterpriseService.update(po);
			msg=new resultMsg(true, UniContant.editok);
		} catch (Exception ex) {
			ex.printStackTrace();
			msg=new resultMsg(true, UniContant.editerror);
			
		}
		return "success";
	}

	/*
	 * ɾ��
	 */
	public String del() {
		try {
			/*
			 * ɾ������
			 */
			String ids = this.getRequest().getParameter("id");
			enterpriseService.delete("", " id in (" + ids + ")");
			msg=new resultMsg(true, UniContant.delok);
		} catch (Exception ex) {
			ex.printStackTrace();
			msg=new resultMsg(true, UniContant.delerror);
		}
		return "success";
	}

	public EnterpriseService getEnterpriseService() {
		return enterpriseService;
	}

	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	public IdInfoService getIdService() {
		return idService;
	}

	public void setIdService(IdInfoService idService) {
		this.idService = idService;
	}
	public resultMsg getMsg() {
		return msg;
	}

	public void setMsg(resultMsg msg) {
		this.msg = msg;
	}

}
