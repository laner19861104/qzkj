package com.bip.sys.course.service;

import java.io.Serializable;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bip.common.util.PaginationSupport;
import com.bip.sys.course.po.JocCourse;


public interface CourseService {
	Serializable save(JocCourse bean) throws DataAccessException;
	
	JocCourse get(Integer id);
	List<JocCourse> find(String queryString);
	PaginationSupport findPageByQuery(String hql, String countHql, int pageSize, int startIndex);

	void update(JocCourse bean) throws Exception;
	void saveOrUpdate(JocCourse bean) throws Exception;

	void delete(JocCourse bean);
	public int delete(Integer id);
	/**
	 * ÅúÉ¾
	 * @param ids Èç£º"1,3,6,8"
	 * @return
	 */
	public int delete(String ids);
}
