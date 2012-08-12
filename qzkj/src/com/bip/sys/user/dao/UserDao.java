package com.bip.sys.user.dao;

import com.bip.common.dao.IGenericDao;
import com.bip.sys.user.po.SysUsers;

public interface UserDao extends IGenericDao<SysUsers, Integer> {
	boolean validate(String username, String password);// 验证登录

	boolean validate(String username);// 验证登录

	SysUsers getUserByUserName(String userName);

	SysUsers getUserByUserid(String userid);
}
