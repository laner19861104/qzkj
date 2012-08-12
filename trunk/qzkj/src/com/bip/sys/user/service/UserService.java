package com.bip.sys.user.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import com.bip.common.util.PaginationSupport;
import com.bip.sys.user.po.SysUsers;

public interface UserService {
	boolean validate(String username, String password);// ��֤��¼

	boolean validate(String username);// ��֤��¼

	SysUsers getUserByUserName(String userName);

	SysUsers getUserByUserid(String userid);

	/**
	 * ����û�
	 * 
	 * @param dept
	 * @return
	 */
	Serializable save(SysUsers sysuser) throws DataAccessException;

	/**
	 * �����������û�
	 * 
	 * @return
	 */
	SysUsers get(Integer id);

	List find(String queryString);

	/**
	 * ��ҳ����
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex);

	/**
	 * �޸��û���Ϣ
	 * 
	 * @param SysUsers
	 * @return
	 * @throws Exception
	 */
	void update(SysUsers sysuser) throws Exception;

	int update(String sql) throws Exception;

	/**
	 * ɾ���û�
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysUsers sysuser);

	Boolean delete(String table, String where);

}
