package com.bip.common.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

public interface IBaseDAO {
	
	 public boolean create(Object entity) ;
	  public Session openSession(); 
	  public Query getQuery(String sql) ;
	  public Criteria getCriteria(Class clazz) ;
	  public boolean update(Object entity) ;
	  public boolean delete(Object entity) ;
	  public boolean deleteAll(Class clazz) ;
	  public boolean deleteAll(Collection entities) ;
	  public List LoadAll(Class clazz);
	  public Object loadByKey(Class clazz, String keyName, Object keyValue) ;
	  public Object getByPk(Class clazz, Integer id) ;
	  public Object getByPk(Class clazz, Long id) ;
	  public Object getByPk(Class clazz, String id) ;
	  public List find(String queryString) ;
	  public List find(String queryString, Object param) ;
	  public List find(String queryString, Object[] params) ;
	  public List ListDeptInfor(DetachedCriteria dc);
	  public List findByPage(DetachedCriteria dc,int start,int end);
	  public List query(final String sql);
}
