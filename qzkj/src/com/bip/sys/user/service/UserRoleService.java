package com.bip.sys.user.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.bip.common.util.PaginationSupport;
import com.bip.sys.user.po.*;

public interface  UserRoleService {


    /**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	Serializable save(SysUserroles user) throws DataAccessException;
	/**
	 * 按条件查找用户
	 * 
	 * @return
	 */
	SysUserroles get(SysUserrolesId id);

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
	 * @param SysUserroles
	 * @return
	 * @throws Exception
	 */

	int update(String sql) throws Exception;
	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	Boolean delete(String table,String where);
    
}
