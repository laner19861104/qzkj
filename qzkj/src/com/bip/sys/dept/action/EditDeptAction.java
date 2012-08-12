/************************************************************
 * ������EditDeptAction.java
 *
 * ���Struts2 Action
 * ���ܣ������������޸ġ�ɾ����
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-30  CFIT-PM   ��ʤ��         ����
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
	 * ������� Service
	 */
	@Resource
	private DeptService dservice;
	/*
	 * ��ѯ�б�ʹ�ã� 1>ps����ѯ�����ࣻ 2>pageId����ҳ�ж��ֶΣ� 3>hql��hibernate��ѯ��sql author��zhaosy
	 */
	private PaginationSupport ps;
	private String hql;

	/*
	 * ����������Ϣ�ֶ� author��zhaosy
	 */
	private String message;

	private IdInfoService idService = new IdInfoServiceImpl();

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
			SysDepartment addpo = new SysDepartment();
			SysDepartment po = (SysDepartment) sqlUtil.getObjByMap(map, addpo);

			/*
			 * ��ֵ��������:��������Ա������������λ���룩���������貿�ŵĽ��������ӻ���
			 */
			if ("admin".equals(this.getUser().getUsername())) {
				if (po.getDeptno().length() != 8) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(
							false, "�������벻�Ϸ����������8λ"), this.getResponse());
					return;
				}
				po.setDeptno(po.getDeptno());
			} else {
				if (po.getDeptno().length() != 6) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(
							false, "�������벻�Ϸ����������6λ"), this.getResponse());
					return;
				}
				po.setDeptno(po.getDeptno()+this.getSysDept().getDeptno().substring(6));
			}

			/*
			 * ��ֵ������
			 */
			if ("00".equals(po.getDeptno().substring(4,6))) {
				po.setParentid("");
			} else {
				po.setParentid(po.getDeptno().substring(0,
						4)+"00"+po.getDeptno().substring(6));
			}
			/*
			 * �ж��Ƿ�����ظ���¼
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
			 * ȡ���ݱ�������Ҫ������ID
			 */
			PairValue pv = idService.getIDs("sys_department", "deptid", 1);
			long id = pv.max;
			po.setDeptid(Integer.parseInt(String.valueOf(id)));
			/*
			 * ִ�����ݿ�д������������ݷ���ֵ���гɹ���ʧ�ܴ���
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
			SysDepartment addpo = new SysDepartment();
			SysDepartment po = (SysDepartment) sqlUtil.getObjByMap(map, addpo);
			/*
			 * ִ���޸����ݿ����
			 */
			/*
			 * ��������Ϸ����ж�
			 */
			if ("admin".equals(this.getUser().getUsername())) {
				if (po.getDeptno().length() != 8) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(
							false, "�������벻�Ϸ����������8λ"), this.getResponse());
					return;
				}
				po.setDeptno(po.getDeptno());
			} else {
				if (po.getDeptno().length() < 8) {
					ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(
							false, "�������벻�Ϸ����������8λ"), this.getResponse());
					return;
				}  else {
					/*
					 * �жϻ���/���ű����ǰ��λ������λ���Ի�����һ��
					 */
					if (this.getSysDept().getDeptno().length() == 8) {
						if (!this.getSysDept().getDeptno().substring(0,4).equals(
								po.getDeptno().substring(0,4))) {
							ControllerUtil.responseWriter(ControllerUtil
									.getJsonMsg(false, "�������벻�Ϸ��������ǰ4λ����Ϊ��"
											+ this.getSysDept().getDeptno().substring(0,4)), this.getResponse());
							return;
						}
						if (!this.getSysDept().getDeptno().substring(6).equals(
								po.getDeptno().substring(6))) {
							ControllerUtil.responseWriter(ControllerUtil
									.getJsonMsg(false, "�������벻�Ϸ�������ĺ�2λ����Ϊ��"
											+ this.getSysDept().getDeptno().substring(6)), this.getResponse());
							return;
						}
					} else {
						
							ControllerUtil.responseWriter(ControllerUtil
									.getJsonMsg(false, "�������벻�Ϸ����������8λ"), this.getResponse());
							return;
						}
					}
				}
			
			/*
			 * �ж��Ƿ�����ظ���¼
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
			 * ��ֵ������
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
	 * ɾ��
	 * 
	 * author��zhaosy
	 */
	public void del() {
		try {
			/*
			 * ɾ������
			 */
			String ids = this.getRequest().getParameter("id");
			if (ids == null || "".equals(ids)) {
				ControllerUtil.responseWriter(ControllerUtil.getJsonMsg(false,
						"��¼δѡ�У���ˢ�º�����ѡ��Ҫɾ���ļ�¼"), this.getResponse());
				return;
			}
			String[] idlist = Tool.explode(",", ids);
			for (int i = 0; i < idlist.length; i++) {
				String id = (String) idlist[i];
				/*
				 * �ж��Ƿ���Ȩ�޽���ɾ��
				 */
				SysDepartment po = (SysDepartment) dservice.get(Integer
						.parseInt(id));

				if ("admin".equals(this.getUser().getUsername())) {
					
				} else {
					if ("00".equals(this.getSysDept().getDeptno().substring(4,6))) {
						if (!this.getSysDept().getDeptno().substring(6).equals(
								po.getDeptno().substring(6))) {
							ControllerUtil.responseWriter(ControllerUtil
									.getJsonMsg(false, "�Բ������޴˼�¼��ɾ��Ȩ��"), this.getResponse());
							return;
						}
					} else {
						ControllerUtil.responseWriter(ControllerUtil
								.getJsonMsg(false, "�Բ�������ɾ��Ȩ��"), this.getResponse());
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
