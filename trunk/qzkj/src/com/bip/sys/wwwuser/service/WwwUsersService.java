package com.bip.sys.wwwuser.service;

import java.io.Serializable;

import com.bip.common.util.QueryJson;
import com.bip.sys.wwwuser.po.WwwUsers;

public interface WwwUsersService {

	QueryJson findPageByQuery(String conditions, int row, int i);

	WwwUsers get(String id);

	Serializable save(WwwUsers po);

	void update(WwwUsers po);

	void delete(String string);

	/**
	 * 功能：网站登录验证<br>
	 * author：zj<br>
	 * 日期：2012-10-18 <br>
	 * @param account
	 * @param password
	 * @return
	 */
	boolean validate(String account, String password);

}
