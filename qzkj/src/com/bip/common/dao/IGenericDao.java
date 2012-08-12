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
import com.bip.sys.codediction.util.SysCodeSupport;

public interface IGenericDao<T, ID extends Serializable> {
	public T load(ID id) throws DataAccessException;

	public T get(ID id) throws DataAccessException;

	public boolean contains(T t) throws DataAccessException;

	public void refresh(T t, LockMode lockMode) throws DataAccessException;

	public void refresh(T t) throws DataAccessException;

	public Serializable save(T t) throws DataAccessException;

	public void saveOrUpdate(T t) throws DataAccessException;

	public void saveOrUpdateAll(Collection<T> entities)
			throws DataAccessException;

	public void update(T t, LockMode lockMode) throws DataAccessException;

	public void update(T t) throws DataAccessException;

	public void delete(T t, LockMode lockMode) throws DataAccessException;

	public void delete(T t) throws DataAccessException;

	public void deleteAll(Collection<T> entities) throws DataAccessException;

	public List<T> find(String queryString, Object value)
			throws DataAccessException;

	public List<T> find(String queryString, Object[] values)
			throws DataAccessException;

	public List<T> find(String queryString) throws DataAccessException;

	public List<T> list() throws DataAccessException;

	public List<T> findByNamedQuery(String queryName)
			throws DataAccessException;

	public List<T> findByNamedQuery(String queryName, Object value)
			throws DataAccessException;

	public List<T> findByNamedQuery(String queryName, Object[] values)
			throws DataAccessException;

	public PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria, final int pageSize,
			final int startIndex);

	public PaginationSupport findPageByQuery(final String hql,
			final String countHql, final int pageSize, final int startIndex);

	public Boolean delete(String tablename, String where);

	public int update(final String sql);

	public SysCodeSupport getSysCodeSupport(final String lbbh);

	public Map getSysCodeSupportMap(final String lbbh);
	
	public String getLsh(String tablename,String zdmc,String sjdm);
	
	public String getMbnrlsh(String tablename,String zdmc,String sjdm);

	public List query(final String sql) ;

	public QueryJson findPageByQuery(Class voClazz, List conList,
			int pageSize, int startIndex);

	public QueryJson findPageByQuery(String sql, String countSql,
			Class voClazz, List conList, int pageSize, int startIndex);

	public QueryJson findPageByQuery(String hql, String countHql, List conList,
			int pageSize, int startIndex);

	public List queryBySql(String sql, Class voClazz);
}