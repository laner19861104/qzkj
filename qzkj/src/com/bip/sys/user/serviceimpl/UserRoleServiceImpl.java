package com.bip.sys.user.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bip.common.util.PaginationSupport;
import com.bip.sys.user.service.UserRoleService;
import com.bip.sys.user.po.SysUserroles;
import com.bip.sys.user.po.SysUserrolesId;
import com.bip.sys.user.dao.UserRoleDao;
@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Resource
	private UserRoleDao userroleDao;

	public void setUserroleDao(UserRoleDao userroleDao) {
		this.userroleDao = userroleDao;
	}

	public UserRoleDao getUserroleDao() {
		return userroleDao;
	}


	public UserRoleServiceImpl(){}

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return
	 */
	public Serializable save(SysUserroles t) throws DataAccessException {
		return userroleDao.save(t);
	}

	/**
	 * 按条件查找角色
	 * 
	 * @return
	 */
	public SysUserroles get(SysUserrolesId id) {
		SysUserroles sr = new SysUserroles();
		sr = userroleDao.get(id);
		return sr;
	}

	public List find(String queryString) {
		List rlist = new ArrayList();
		rlist = userroleDao.find("FROM SysUserroles " + queryString);
		return rlist;
	}

	/**
	 * 分页查找
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	public PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex) {
		PaginationSupport ps = new PaginationSupport(null, 0, 0, 0);
		ps = userroleDao.findPageByQuery("FROM SysUserroles " + hql,
				"FROM SysUserroles " + countHql, pageSize, startIndex);
		return ps;
	}

	/**
	 * 修改角色信息
	 * 
	 * @param SysUserroles
	 * @return
	 * @throws Exception
	 */
	
	public int update(final String sql) throws Exception {
		return userroleDao.update(sql);
	}
	/**
	 * 删除角色
	 * 
	 * @param id
	 * @return
	 */

	public Boolean delete(String table, String where) {
		return userroleDao.delete("sys_userroles", where);

	}
	
	
}
