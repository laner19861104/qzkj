/************************************************************
 * ������EditUserAction.java
 *
 * ���Struts2 Action
 * ���ܣ��û��������޸ġ�ɾ����
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-30  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.user.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.Encoding;
import com.bip.common.util.SqlUtil;
import com.bip.common.util.UniContant;
import com.bip.common.util.idinfo.service.IdInfoService;
import com.bip.common.util.idinfo.service.PairValue;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.user.po.SysUsers;
import com.bip.sys.user.service.UserRoleService;
import com.bip.sys.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class EditUserAction extends baseAction {
	
	private static final long serialVersionUID = 1L;
	/*
	 * ������� Service
	 */
	@Resource
	private UserService uservice;
	@Resource
	private UserRoleService urservice;
	@Resource
	private IdInfoService idService;

	/*
	 * ����������Ϣ�ֶ� author��zhaosy
	 */
	private String message;

	/*
	 * ��ѯ����
	 */
	private String qusername;
	private String qdeptid;
	private String quserxm;

	/*
	 * ����
	 * 
	 * author��zhaosy
	 */
	public void add() {
		/******
		 * ����
		 ******/
		try {
			/*
			 * ��ҳ��ֵת����po����
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysUsers addpo = new SysUsers();
			SysUsers po = (SysUsers) sqlUtil.getObjByMap(map, addpo);

			
			/*
			 * �ظ��ж�
			 */
			List exist=uservice.find(" where username='"+po.getUsername()+"'");
			if (exist.size() > 0) {
				ControllerUtil.responseWriter(ControllerUtil
						.getJsonMsg(false, UniContant.existerror),
						this.getResponse());
				return;
			}
			/*
			 * ȡ���ݱ�������Ҫ������ID
			 */
			PairValue pv = idService.getIDs("sys_users", "userid", 1);
			long id = pv.max;
			po.setUserid(Integer.valueOf(String.valueOf(id)));
			po.setPassword(Encoding.encodeCmd(po.getPassword()));
			
			/*
			 * ִ�����ݿ�д������������ݷ���ֵ���гɹ���ʧ�ܴ���
			 */
			Serializable a = uservice.save(po);
			if ((Integer) a == po.getUserid()) {
				ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
						UniContant.addok), this.getResponse());
				return;
			} else {
				ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
						UniContant.adderror), this.getResponse());
				return;
			}
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.adderror), this.getResponse());
			return;
		}

	}

	/*
	 * �޸�
	 * 
	 * author��zhaosy
	 */
	public void edit() {
		/******
		 * �޸�
		 ******/
		try {
			/*
			 * ��ҳ��ֵת����po����
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysUsers addpo = new SysUsers();
			SysUsers po = (SysUsers) sqlUtil.getObjByMap(map, addpo);
			/*
			 * ȡ���ݱ��password
			 */
			String userid=this.getRequest().getParameter("userid");
			SysUsers sysuser = (SysUsers) uservice.find(
					" where userid=" + po.getUserid()).get(0);
			po.setPassword(sysuser.getPassword());
			
			/*
			 * �ظ��ж�
			 */
			
			List exist=uservice.find(" where username='"+po.getUsername()+"'");
			if (exist.size() > 0) {
				SysUsers user=(SysUsers) exist.get(0);
				if(user.getUserid().compareTo(po.getUserid())!=0){
					ControllerUtil.responseWriter(ControllerUtil
							.getJsonMsgToIso(false, UniContant.existerror),
							this.getResponse());
					return;
				}
			}
			/*
			 * ִ�����ݿ�д������������ݷ���ֵ���гɹ���ʧ�ܴ���
			 */
			uservice.update(po);
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsgToIso(true,
					UniContant.editok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsgToIso(false,
					UniContant.editerror), this.getResponse());
			return;
		}

	}

	/*
	 * ɾ��
	 * 
	 * author��zhaosy
	 */
	public void del() {
		/*
		 * ɾ��
		 */
		try {
			/*
			 * ɾ������
			 */
			String ids = this.getRequest().getParameter("id");
		
			uservice.delete("", " userid in (" + ids + ")");
			urservice.delete("", " roleid in (" + ids + ")");

			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}

	}

	/*
	 * ��������
	 * 
	 * author��zhaosy
	 */
	public String uppwd() {
		try {
			SysUsers sysuser = (SysUsers) this.getSession().getAttribute("sysuser");
			String oldpassword = this.getRequest().getParameter("oldpassword");
			
			String password = this.getRequest().getParameter("password");
			if(Encoding.encodeCmd(password).equals(sysuser.getPassword())){
				this.setMessage("ԭ�����������");
				return "failure";
			}
			String password2 = this.getRequest().getParameter("password2");
			String username = sysuser.getUsername();
			if (password.equals(password2)) {
				sysuser.setPassword(Encoding.encodeCmd(password));
				uservice.update(sysuser);
			}
		} catch (Exception ex) {
			this.setMessage(UniContant.editerror);
			return "failure";
		}
		this.setMessage(UniContant.uppwdok);
		return "success";
	}

	public UserService getUservice() {
		return uservice;
	}

	public void setUservice(UserService uservice) {
		this.uservice = uservice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getQusername() {
		return qusername;
	}

	public void setQusername(String qusername) {
		this.qusername = qusername;
	}

	public String getQdeptid() {
		return qdeptid;
	}

	public void setQdeptid(String qdeptid) {
		this.qdeptid = qdeptid;
	}

	public String getQuserxm() {
		return quserxm;
	}

	public void setQuserxm(String quserxm) {
		this.quserxm = quserxm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserRoleService getUrservice() {
		return urservice;
	}

	public void setUrservice(UserRoleService urservice) {
		this.urservice = urservice;
	}

	public IdInfoService getIdService() {
		return idService;
	}

	public void setIdService(IdInfoService idService) {
		this.idService = idService;
	}

}
