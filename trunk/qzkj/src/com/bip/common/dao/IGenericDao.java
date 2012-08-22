/************************************************************
 * ������IGenericDao.java
 *
 * ���ͨ����
 * ���ܣ�ͨ��HibernateDao�ӿ���
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2011-5-20  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.common.dao;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

import com.bip.common.util.PaginationSupport;
import com.bip.common.util.QueryJson;

public interface IGenericDao<T, ID extends Serializable> {
	/**
	 * 
	 * ���ܣ���ȡ����<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param id ʵ��ID
	 * @return PO
	 * @throws DataAccessException
	 */
	public T load(ID id) throws DataAccessException;
	/**
	 * 
	 * ���ܣ���ȡʵ��<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public T get(ID id) throws DataAccessException;
	
	public boolean contains(T t) throws DataAccessException;

	public void refresh(T t, LockMode lockMode) throws DataAccessException;

	public void refresh(T t) throws DataAccessException;
	/**
	 * 
	 * ���ܣ�����<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param t
	 * @return 
	 * @throws DataAccessException
	 */
	public Serializable save(T t) throws DataAccessException;
	/**
	 * 
	 * ���ܣ��洢����£�������Ϊ��ʱ����<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param t
	 * @throws DataAccessException
	 */
	public void saveOrUpdate(T t) throws DataAccessException;
	/**
	 * 
	 * ���ܣ���������<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param entities
	 * @throws DataAccessException
	 */
	public void saveOrUpdateAll(Collection<T> entities)
			throws DataAccessException;
	/**
	 * 
	 * ���ܣ�����<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param t
	 * @param lockMode
	 * @throws DataAccessException
	 */
	public void update(T t, LockMode lockMode) throws DataAccessException;
	/**
	 * 
	 * ���ܣ�����<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param t
	 * @param lockMode
	 * @throws DataAccessException
	 */
	public void update(T t) throws DataAccessException;
	/**
	 * 
	 * ���ܣ�ɾ��<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param t
	 * @param lockMode
	 * @throws DataAccessException
	 */
	public void delete(T t, LockMode lockMode) throws DataAccessException;
	/**
	 * 
	 * ���ܣ�����<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param t
	 * @param lockMode
	 * @throws DataAccessException
	 */
	public void delete(T t) throws DataAccessException;
	/**
	 * 
	 * ���ܣ�����ɾ��<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param entities
	 * @throws DataAccessException
	 */
	public void deleteAll(Collection<T> entities) throws DataAccessException;

	public List<T> find(String queryString, Object value)
			throws DataAccessException;

	public List<T> find(String queryString, Object[] values)
			throws DataAccessException;
	/**
	 * 
	 * ���ܣ�HQL<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param queryString
	 * @return
	 * @throws DataAccessException
	 */
	public List<T> find(String queryString) throws DataAccessException;
	/**
	 * 
	 * ���ܣ����ص�ǰ����������<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @return
	 * @throws DataAccessException
	 */
	public List<T> list() throws DataAccessException;
	public QueryJson findPageByQuery(Class voClazz, List conList,
			int pageSize, int startIndex);
	/**
	 * 
	 * ���ܣ���ҳ��ԭ��sql��ѯ<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param sql ��ѯsql
	 * @param countSql ͳ��sql
	 * @param voClazz VO
	 * @param conList ��ѯ��������
	 * @param pageSize
	 * @param startIndex
	 * @return ����VOList
	 */
	public QueryJson findPageByQuery(String sql, String countSql,
			Class voClazz, List conList, int pageSize, int startIndex);
	/**
	 * 
	 * ���ܣ���ҳ��HQL��ѯ<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param hql ������VO�����ѯ������ǰ̨�޷���ȡ����
	 * @param countHql ͳ��sql
	 * @param conList ���й���sql��ѯ����
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	public QueryJson findPageByQuery(String hql, String countHql, List conList,
			int pageSize, int startIndex);
	/**
	 * 
	 * ���ܣ����ؼ��ϵ�ԭ��sql��ѯ<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-9 <br>
	 * @param sql
	 * @param voClazz
	 * @return
	 */
	public List queryBySql(String sql, Class voClazz);
	
	public List<T> findByNamedQuery(String queryName)
			throws DataAccessException;

	public List<T> findByNamedQuery(String queryName, Object value)
			throws DataAccessException;

	public List<T> findByNamedQuery(String queryName, Object[] values)
			throws DataAccessException;

	public PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria, final int pageSize,
			final int startIndex);
	public List query(final String sql) ;
	
	
	////////////////////////////////////////////////////��ʱ����
	@Deprecated
	public PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex);
	@Deprecated
	public Boolean delete(String tablename, String where);
	@Deprecated
	public int update(final String sql);
	@Deprecated
	public String getMbnrlsh(String tablename,String zdmc,String sjdm) ;
	@Deprecated
	public String getLsh(String tablename,String zdmc,String sjdm);
	
}