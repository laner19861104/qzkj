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
	 * ���ܣ���վ��¼��֤<br>
	 * author��zj<br>
	 * ���ڣ�2012-10-18 <br>
	 * @param account
	 * @param password
	 * @return
	 */
	boolean validate(String account, String password);

	/**
	 * ���ܣ������˻���ȡ�˻���Ϣ<br>
	 * author��zj<br>
	 * ���ڣ�2012-10-20 <br>
	 * @param account
	 * @return
	 */
	WwwUsers getUserbyAccount(String account);

}
