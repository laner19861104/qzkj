package com.bip.sys.codediction.dmzd.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.bip.common.util.PaginationSupport;
import com.bip.sys.codediction.dmzd.po.*;
import com.bip.sys.codediction.util.SysCodeSupport;

public interface DmzdService {
	/**
	 * ��Ӵ����ֵ�
	 * 
	 * @param resource
	 * @return
	 */
	Serializable save(SysDmzd dmzd) throws DataAccessException;

	/**
	 * ���������Ҵ����ֵ�
	 * 
	 * @return
	 */
	SysDmzd get(Integer id);

	List<SysDmzd> find(String queryString);

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
	 * �޸Ĵ����ֵ���Ϣ
	 * 
	 * @param SysDmzd
	 * @return
	 * @throws Exception
	 */
	void update(SysDmzd sysdmzd) throws Exception;

	/**
	 * ɾ�������ֵ�
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysDmzd sysdmzd);

	/**
	 * ��������ɾ�������ֵ�
	 * 
	 * @param id
	 * @return
	 */

	public Boolean delete(String tablename, String where);

	/**
	 * ���ݴ�������ô����ֵ���ϸ��Ϣ
	 * 
	 * @param resource
	 * @return
	 */
	public SysCodeSupport getSysCodeSupport(String lbbh);

	/********** ϵͳ������ʼ **********/
	/**
	 * ��ȡ�����ֵ�
	 * 
	 * @return List(dept_typesc,dept_levelsc)
	 */
	public List findDeptSc(String sql);

	/**
	 * ��ȡ��Դ�ֵ�
	 * 
	 * @return List(resource_typesc)
	 */
	public List findResourceSc();

	/**
	 * ��ȡȨ���ֵ�
	 * 
	 * @return List(permission_actionidsc)
	 */
	public List findPermissionSc();

	/**
	 * ��ȡ��ɫ�ֵ�
	 * 
	 * @return List(role_typesc)
	 */
	public List findRoleSc(String sql);

	/**
	 * ��ȡ�û��ֵ䡣
	 * 
	 * @return 
	 *         List(user_postprivsc,user_sexsc,user_hidebirthsc,user_hidemobilesc
	 *         ,user_smson,user_statesc,user_regionsc)
	 */

	public List findUserSc();

	/********** ϵͳ�������� **********/
	public List findEnterpriseSc() ;
	

}
