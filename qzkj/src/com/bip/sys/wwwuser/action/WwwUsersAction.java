package com.bip.sys.wwwuser.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.util.ControllerUtil;
import com.bip.common.util.QueryJson;
import com.bip.common.util.SqlUtil;
import com.bip.common.util.UniContant;
import com.bip.common.util.resultMsg;
import com.bip.sys.wwwuser.po.WwwUsers;
import com.bip.sys.wwwuser.service.WwwUsersService;

@Controller
public class WwwUsersAction extends baseAction {

	private WwwUsersService wwwUsersService;
	private WwwUsers instance;
	private resultMsg msg;
	private QueryJson queryJson;

	public QueryJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(QueryJson queryJson) {
		this.queryJson = queryJson;
	}

	public String entry() {
		return "success";
	}

	public String query() {

		int page = Integer.parseInt(this.getRequest().getParameter("page"));
		int row = Integer.parseInt(this.getRequest().getParameter("rows"));// 接受参数page和rows
		String conditions = this.getRequest().getParameter("conditions");
		if (conditions != null)
			try {
				conditions = URLDecoder.decode(
						URLDecoder.decode(conditions, "utf-8"), "utf-8");
			} catch (UnsupportedEncodingException e) {
			
				e.printStackTrace();
			}
		queryJson = (QueryJson) wwwUsersService.findPageByQuery(conditions, row,
				(page - 1) * row);
		return "success";
	}

	public String get() {
		int id = Integer.parseInt(this.getRequest().getParameter("id"));
		instance = this.wwwUsersService.get(id);
		return "success";
	}
	public String add() {
		try {
			/*
			 * 将页面值转换成po对象
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			WwwUsers addpo = new WwwUsers();
			WwwUsers po = (WwwUsers) sqlUtil.getObjByMap(map, addpo);
		
			/*
			 * 执行数据库写入操作，并根据返回值进行成功、失败处理
			 */
			Serializable a = wwwUsersService.save(po);
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
	 * 修改
	 */
	public String update() {
		try {
			/*
			 * 将页面值转换成po对象
			 */
			Map map = new HashMap();
			map = ControllerUtil.getRequestParameterMap(this.getRequest());
			SqlUtil sqlUtil = new SqlUtil();
			WwwUsers addpo = new WwwUsers();
			WwwUsers po = (WwwUsers) sqlUtil.getObjByMap(map, addpo);
			wwwUsersService.update(po);
			msg=new resultMsg(true, UniContant.editok);
		} catch (Exception ex) {
			ex.printStackTrace();
			msg=new resultMsg(true, UniContant.editerror);
			
		}
		return "success";
	}

	/*
	 * 删除
	 */
	public String del() {
		try {
			/*
			 * 删除数据
			 */
			String ids = this.getRequest().getParameter("id");
			wwwUsersService.delete("", " id in (" + ids + ")");
			msg=new resultMsg(true, UniContant.delok);
		} catch (Exception ex) {
			ex.printStackTrace();
			msg=new resultMsg(true, UniContant.delerror);
		}
		return "success";
	}
	public WwwUsers getInstance() {
		return instance;
	}

	public void setInstance(WwwUsers instance) {
		this.instance = instance;
	}

	public resultMsg getMsg() {
		return msg;
	}

	public void setMsg(resultMsg msg) {
		this.msg = msg;
	}

	

	public WwwUsersService getWwwUsersService() {
		return wwwUsersService;
	}

	@Resource
	public void setWwwUsersService(WwwUsersService wwwUsersService) {
		this.wwwUsersService = wwwUsersService;
	}
}
