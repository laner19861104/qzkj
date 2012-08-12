package com.bip.sys.user.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.bip.common.util.PaginationSupport;
import com.bip.sys.user.po.*;

public interface  UserRoleService {


    /**
	 * ����û�
	 * 
	 * @param user
	 * @return
	 */
	Serializable save(SysUserroles user) throws DataAccessException;
	/**
	 * �����������û�
	 * 
	 * @return
	 */
	SysUserroles get(SysUserrolesId id);

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
	 * @param SysUserroles
	 * @return
	 * @throws Exception
	 */

	int update(String sql) throws Exception;
	/**
	 * ɾ���û�
	 * 
	 * @param id
	 * @return
	 */
	Boolean delete(String table,String where);
    
}
