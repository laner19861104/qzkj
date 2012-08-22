/************************************************************
 * 类名：IGenericDao.java
 *
 * 类别：通用类
 * 功能：通用HibernateDao接口类
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2011-5-20  CFIT-PM   赵胜运         初版
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
	 * 功能：获取对象<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param id 实体ID
	 * @return PO
	 * @throws DataAccessException
	 */
	public T load(ID id) throws DataAccessException;
	/**
	 * 
	 * 功能：获取实体<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
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
	 * 功能：保存<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param t
	 * @return 
	 * @throws DataAccessException
	 */
	public Serializable save(T t) throws DataAccessException;
	/**
	 * 
	 * 功能：存储或更新，主键不为空时更新<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param t
	 * @throws DataAccessException
	 */
	public void saveOrUpdate(T t) throws DataAccessException;
	/**
	 * 
	 * 功能：批量更新<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param entities
	 * @throws DataAccessException
	 */
	public void saveOrUpdateAll(Collection<T> entities)
			throws DataAccessException;
	/**
	 * 
	 * 功能：更新<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param t
	 * @param lockMode
	 * @throws DataAccessException
	 */
	public void update(T t, LockMode lockMode) throws DataAccessException;
	/**
	 * 
	 * 功能：更新<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param t
	 * @param lockMode
	 * @throws DataAccessException
	 */
	public void update(T t) throws DataAccessException;
	/**
	 * 
	 * 功能：删除<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param t
	 * @param lockMode
	 * @throws DataAccessException
	 */
	public void delete(T t, LockMode lockMode) throws DataAccessException;
	/**
	 * 
	 * 功能：更新<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param t
	 * @param lockMode
	 * @throws DataAccessException
	 */
	public void delete(T t) throws DataAccessException;
	/**
	 * 
	 * 功能：批量删除<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
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
	 * 功能：HQL<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param queryString
	 * @return
	 * @throws DataAccessException
	 */
	public List<T> find(String queryString) throws DataAccessException;
	/**
	 * 
	 * 功能：加载当前表所有数据<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @return
	 * @throws DataAccessException
	 */
	public List<T> list() throws DataAccessException;
	public QueryJson findPageByQuery(Class voClazz, List conList,
			int pageSize, int startIndex);
	/**
	 * 
	 * 功能：分页，原生sql查询<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param sql 查询sql
	 * @param countSql 统计sql
	 * @param voClazz VO
	 * @param conList 查询条件集合
	 * @param pageSize
	 * @param startIndex
	 * @return 返回VOList
	 */
	public QueryJson findPageByQuery(String sql, String countSql,
			Class voClazz, List conList, int pageSize, int startIndex);
	/**
	 * 
	 * 功能：分页，HQL查询<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
	 * @param hql 必须有VO参与查询，否则前台无法获取数据
	 * @param countHql 统计sql
	 * @param conList 分切过的sql查询条件
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	public QueryJson findPageByQuery(String hql, String countHql, List conList,
			int pageSize, int startIndex);
	/**
	 * 
	 * 功能：返回集合的原生sql查询<br>
	 * author：zj<br>
	 * 日期：2012-7-9 <br>
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
	
	
	////////////////////////////////////////////////////过时方法
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