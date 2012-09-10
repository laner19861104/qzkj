package com.bip.sys.course.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.util.PaginationSupport;
import com.bip.sys.course.dao.CourseDao;
import com.bip.sys.course.po.JocCourse;
import com.bip.sys.course.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	
	public void delete(JocCourse bean) {
		courseDao.delete(bean);
	}

	
	public int delete(Integer id) {
		JocCourse bean = get(id);
		if (null == bean) {
			return 0;
		}
		delete(bean);
		return 1;
	}

	public int delete(String ids) {
		//
		return 0;
	}
	
	
	public List<JocCourse> find(String queryString) {
		return courseDao.find(queryString);
	}

	
	public PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex) {
		
		return courseDao.findPageByQuery(hql, countHql, pageSize, startIndex);
	}

	
	public JocCourse get(Integer id) {
		return courseDao.get(id);
	}

	
	public Serializable save(JocCourse bean) throws DataAccessException {
		return courseDao.save(bean);
	}

	
	public void update(JocCourse bean) throws Exception {
		courseDao.update(bean);
	}
	
	
	public void saveOrUpdate(JocCourse bean) throws Exception {
		courseDao.saveOrUpdate(bean);
	}

	@Autowired
	private CourseDao courseDao;
}
