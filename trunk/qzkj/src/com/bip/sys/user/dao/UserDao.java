package com.bip.sys.user.dao;

import com.bip.common.dao.IGenericDao;
import com.bip.sys.user.po.SysUsers;

public interface UserDao extends IGenericDao<SysUsers, Integer> {
	boolean validate(String username, String password);// ��֤��¼

	boolean validate(String username);// ��֤��¼

	SysUsers getUserByUserName(String userName);

	SysUsers getUserByUserid(String userid);
}
