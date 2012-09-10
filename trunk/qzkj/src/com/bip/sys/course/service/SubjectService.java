package com.bip.sys.course.service;

import java.io.Serializable;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.PaginationSupport;
import com.bip.sys.course.po.JocSubject;


public interface SubjectService {
	Serializable save(JocSubject bean) throws DataAccessException;
	
	JocSubject get(Integer id);
	List<JocSubject> find(String queryString);
	PaginationSupport findPageByQuery(String hql, String countHql, int pageSize, int startIndex);

	void update(JocSubject bean) throws Exception;
	void saveOrUpdate(JocSubject bean) throws Exception;

	void delete(JocSubject bean);
	public int delete(Integer id);
	/**
	 * ÅúÉ¾
	 * @param ids Èç£º"1,3,6,8"
	 * @return
	 */
	public int delete(String ids);
}
