package com.bip.sys.user.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import com.bip.common.util.PaginationSupport;
import com.bip.sys.user.po.SysUsers;

public interface UserService {
	boolean validate(String username, String password);// 验证登录

	boolean validate(String username);// 验证登录

	SysUsers getUserByUserName(String userName);

	SysUsers getUserByUserid(String userid);

	/**
	 * 添加用户
	 * 
	 * @param dept
	 * @return
	 */
	Serializable save(SysUsers sysuser) throws DataAccessException;

	/**
	 * 按条件查找用户
	 * 
	 * @return
	 */
	SysUsers get(Integer id);

	List find(String queryString);

	/**
	 * 分页查找
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex);

	/**
	 * 修改用户信息
	 * 
	 * @param SysUsers
	 * @return
	 * @throws Exception
	 */
	void update(SysUsers sysuser) throws Exception;

	int update(String sql) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysUsers sysuser);

	Boolean delete(String table, String where);

}
