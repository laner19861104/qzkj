package com.bip.sys.codediction.dmzd.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.bip.common.util.PaginationSupport;
import com.bip.sys.codediction.dmzd.po.*;
import com.bip.sys.codediction.util.SysCodeSupport;

public interface DmzdService {
	/**
	 * 添加代码字典
	 * 
	 * @param resource
	 * @return
	 */
	Serializable save(SysDmzd dmzd) throws DataAccessException;

	/**
	 * 按条件查找代码字典
	 * 
	 * @return
	 */
	SysDmzd get(Integer id);

	List<SysDmzd> find(String queryString);

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
	 * 修改代码字典信息
	 * 
	 * @param SysDmzd
	 * @return
	 * @throws Exception
	 */
	void update(SysDmzd sysdmzd) throws Exception;

	/**
	 * 删除代码字典
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysDmzd sysdmzd);

	/**
	 * 用于批量删除代码字典
	 * 
	 * @param id
	 * @return
	 */

	public Boolean delete(String tablename, String where);

	/**
	 * 根据代码类别获得代码字典详细信息
	 * 
	 * @param resource
	 * @return
	 */
	public SysCodeSupport getSysCodeSupport(String lbbh);

	/********** 系统管理－开始 **********/
	/**
	 * 获取部门字典
	 * 
	 * @return List(dept_typesc,dept_levelsc)
	 */
	public List findDeptSc(String sql);

	/**
	 * 获取资源字典
	 * 
	 * @return List(resource_typesc)
	 */
	public List findResourceSc();

	/**
	 * 获取权限字典
	 * 
	 * @return List(permission_actionidsc)
	 */
	public List findPermissionSc();

	/**
	 * 获取角色字典
	 * 
	 * @return List(role_typesc)
	 */
	public List findRoleSc(String sql);

	/**
	 * 获取用户字典。
	 * 
	 * @return 
	 *         List(user_postprivsc,user_sexsc,user_hidebirthsc,user_hidemobilesc
	 *         ,user_smson,user_statesc,user_regionsc)
	 */

	public List findUserSc();

	/********** 系统管理－结束 **********/
	public List findEnterpriseSc() ;
	

}
