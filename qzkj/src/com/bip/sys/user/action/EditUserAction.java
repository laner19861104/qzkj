/************************************************************
 * 类名：EditUserAction.java
 *
 * 类别：Struts2 Action
 * 功能：用户新增、修改、删除。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-30  CFIT-PM   赵胜运         初版
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
	 * 定义操作 Service
	 */
	@Resource
	private UserService uservice;
	@Resource
	private UserRoleService urservice;
	@Resource
	private IdInfoService idService;

	/*
	 * 操作返回信息字段 author：zhaosy
	 */
	private String message;

	/*
	 * 查询条件
	 */
	private String qusername;
	private String qdeptid;
	private String quserxm;

	/*
	 * 新增
	 * 
	 * author：zhaosy
	 */
	public void add() {
		/******
		 * 新增
		 ******/
		try {
			/*
			 * 将页面值转换成po对象
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysUsers addpo = new SysUsers();
			SysUsers po = (SysUsers) sqlUtil.getObjByMap(map, addpo);

			
			/*
			 * 重复判断
			 */
			List exist=uservice.find(" where username='"+po.getUsername()+"'");
			if (exist.size() > 0) {
				ControllerUtil.responseWriter(ControllerUtil
						.getJsonMsg(false, UniContant.existerror),
						this.getResponse());
				return;
			}
			/*
			 * 取数据表新增需要的自增ID
			 */
			PairValue pv = idService.getIDs("sys_users", "userid", 1);
			long id = pv.max;
			po.setUserid(Integer.valueOf(String.valueOf(id)));
			po.setPassword(Encoding.encodeCmd(po.getPassword()));
			
			/*
			 * 执行数据库写入操作，并根据返回值进行成功、失败处理
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
	 * 修改
	 * 
	 * author：zhaosy
	 */
	public void edit() {
		/******
		 * 修改
		 ******/
		try {
			/*
			 * 将页面值转换成po对象
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			SysUsers addpo = new SysUsers();
			SysUsers po = (SysUsers) sqlUtil.getObjByMap(map, addpo);
			/*
			 * 取数据表的password
			 */
			String userid=this.getRequest().getParameter("userid");
			SysUsers sysuser = (SysUsers) uservice.find(
					" where userid=" + po.getUserid()).get(0);
			po.setPassword(sysuser.getPassword());
			
			/*
			 * 重复判断
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
			 * 执行数据库写入操作，并根据返回值进行成功、失败处理
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
	 * 删除
	 * 
	 * author：zhaosy
	 */
	public void del() {
		/*
		 * 删除
		 */
		try {
			/*
			 * 删除数据
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
	 * 更改密码
	 * 
	 * author：zhaosy
	 */
	public String uppwd() {
		try {
			SysUsers sysuser = (SysUsers) this.getSession().getAttribute("sysuser");
			String oldpassword = this.getRequest().getParameter("oldpassword");
			
			String password = this.getRequest().getParameter("password");
			if(Encoding.encodeCmd(password).equals(sysuser.getPassword())){
				this.setMessage("原密码输入错误！");
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
