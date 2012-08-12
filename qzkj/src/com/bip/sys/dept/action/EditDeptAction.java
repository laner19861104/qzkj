/************************************************************
 * 类名：EditDeptAction.java
 *
 * 类别：Struts2 Action
 * 功能：部门新增、修改、删除。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-30  CFIT-PM   赵胜运         初版
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.dept.action;

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

import com.opensymphony.xwork2.ActionSupport;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.SqlUtil;
import com.bip.common.util.Tool;
import com.bip.common.util.UniContant;
import com.bip.common.util.idinfo.service.IdInfoService;
import com.bip.common.util.idinfo.service.PairValue;
import com.bip.common.util.idinfo.serviceimpl.IdInfoServiceImpl;
import com.bip.sys.dept.po.SysDepartment;
import com.bip.sys.dept.service.DeptService;
import com.bip.sys.user.po.SysUsers;
@Controller
public class EditDeptAction extends baseAction {

	private static final long serialVersionUID = 1L;
	/*
	 * 定义操作 Service
	 */
	@Resource
	private DeptService dservice;
	/*
	 * 查询列表使用： 1>ps：查询返回类； 2>pageId：首页判断字段； 3>hql：hibernate查询用sql author：zhaosy
	 */
	private PaginationSupport ps;
	private String hql;

	/*
	 * 操作返回信息字段 author：zhaosy
	 */
	private String message;

	private IdInfoService idService = new IdInfoServiceImpl();

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
			SysDepartment addpo = new SysDepartment();
			SysDepartment po = (SysDepartment) sqlUtil.getObjByMap(map, addpo);

			/*
			 * 赋值机构编码:超级管理员建立机构（两位代码），其它下设部门的建立各自子机构
			 */
			if ("admin".equals(this.getUser().getUsername())) {
				if (po.getDeptno().length() != 8) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(
							false, "机构编码不合法，编码必须8位"), this.getResponse());
					return;
				}
				po.setDeptno(po.getDeptno());
			} else {
				if (po.getDeptno().length() != 6) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(
							false, "机构编码不合法，编码必须6位"), this.getResponse());
					return;
				}
				po.setDeptno(po.getDeptno()+this.getSysDept().getDeptno().substring(6));
			}

			/*
			 * 赋值父编码
			 */
			if ("00".equals(po.getDeptno().substring(4,6))) {
				po.setParentid("");
			} else {
				po.setParentid(po.getDeptno().substring(0,
						4)+"00"+po.getDeptno().substring(6));
			}
			/*
			 * 判断是否存在重复记录
			 */
			List existl = dservice.find(" where deptno='" + po.getDeptno()
					+ "' ");
			if (existl != null) {
				if (existl.size() != 0) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(
							false, UniContant.existerror), this.getResponse());
					return;
				}
			}
			/*
			 * 取数据表新增需要的自增ID
			 */
			PairValue pv = idService.getIDs("sys_department", "deptid", 1);
			long id = pv.max;
			po.setDeptid(Integer.parseInt(String.valueOf(id)));
			/*
			 * 执行数据库写入操作，并根据返回值进行成功、失败处理
			 */
			Serializable a = dservice.save(po);

			if ((Integer) a == po.getDeptid()) {
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
			SysDepartment addpo = new SysDepartment();
			SysDepartment po = (SysDepartment) sqlUtil.getObjByMap(map, addpo);
			/*
			 * 执行修改数据库操作
			 */
			/*
			 * 机构编码合法性判断
			 */
			if ("admin".equals(this.getUser().getUsername())) {
				if (po.getDeptno().length() != 8) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(
							false, "机构编码不合法，编码必须8位"), this.getResponse());
					return;
				}
				po.setDeptno(po.getDeptno());
			} else {
				if (po.getDeptno().length() < 8) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(
							false, "机构编码不合法，编码必须8位"), this.getResponse());
					return;
				}  else {
					/*
					 * 判断机构/部门编码的前四位、后两位各自机构的一致
					 */
					if (this.getSysDept().getDeptno().length() == 8) {
						if (!this.getSysDept().getDeptno().substring(0,4).equals(
								po.getDeptno().substring(0,4))) {
							ControllerUtil.responseWriter(ControllerUtil
									.getJsonMsg(false, "机构编码不合法，编码的前4位必须为："
											+ this.getSysDept().getDeptno().substring(0,4)), this.getResponse());
							return;
						}
						if (!this.getSysDept().getDeptno().substring(6).equals(
								po.getDeptno().substring(6))) {
							ControllerUtil.responseWriter(ControllerUtil
									.getJsonMsg(false, "机构编码不合法，编码的后2位必须为："
											+ this.getSysDept().getDeptno().substring(6)), this.getResponse());
							return;
						}
					} else {
						
							ControllerUtil.responseWriter(ControllerUtil
									.getJsonMsg(false, "机构编码不合法，编码必须8位"), this.getResponse());
							return;
						}
					}
				}
			
			/*
			 * 判断是否存在重复记录
			 */
			List existl = dservice.find(" where deptno='" + po.getDeptno()
					+ "' ");
			if (existl != null) {
				if (existl.size() > 0) {
					SysDepartment curdept = (SysDepartment) existl.get(0);
					if (!String.valueOf(curdept.getDeptid()).equals(
							String.valueOf(po.getDeptid()))) {
						ControllerUtil.responseWriter(ControllerUtil
								.getJsonMsg(false, UniContant.existerror),
								this.getResponse());
						return;
					}
				}
			}
			
			/*
			 * 赋值父编码
			 */
			if ("00".equals(po.getDeptno().substring(4,6))) {
				po.setParentid("");
			} else {
				po.setParentid(po.getDeptno().substring(0,
						4)+"00"+po.getDeptno().substring(6));
			}
			dservice.update(po);
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.editok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
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
		try {
			/*
			 * 删除数据
			 */
			String ids = this.getRequest().getParameter("id");
			if (ids == null || "".equals(ids)) {
				ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
						"记录未选中，请刷新后重新选择要删除的记录"), this.getResponse());
				return;
			}
			String[] idlist = Tool.explode(",", ids);
			for (int i = 0; i < idlist.length; i++) {
				String id = (String) idlist[i];
				/*
				 * 判断是否有权限进行删除
				 */
				SysDepartment po = (SysDepartment) dservice.get(Integer
						.parseInt(id));

				if ("admin".equals(this.getUser().getUsername())) {
					
				} else {
					if ("00".equals(this.getSysDept().getDeptno().substring(4,6))) {
						if (!this.getSysDept().getDeptno().substring(6).equals(
								po.getDeptno().substring(6))) {
							ControllerUtil.responseWriter(ControllerUtil
									.getJsonMsg(false, "对不起，您无此记录的删除权限"), this.getResponse());
							return;
						}
					} else {
						ControllerUtil.responseWriter(ControllerUtil
								.getJsonMsg(false, "对不起，您无删除权限"), this.getResponse());
						return;
					}			
				}
			}

			dservice.delete("", " deptid in (" + ids + ")");
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(true,
					UniContant.delok), this.getResponse());
			return;
		} catch (Exception ex) {
			ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
					UniContant.delerror), this.getResponse());
			return;
		}
	}

	public DeptService getDservice() {
		return dservice;
	}

	public void setDservice(DeptService dservice) {
		this.dservice = dservice;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setIdService(IdInfoService idService) {
		this.idService = idService;
	}

	public IdInfoService getIdService() {
		return idService;
	}

	

}
