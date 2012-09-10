package com.bip.sys.course.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.util.PaginationSupport;
import com.bip.sys.course.dao.SubjectDao;
import com.bip.sys.course.po.JocSubject;
import com.bip.sys.course.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {
	
	public void delete(JocSubject bean) {
		subjectDao.delete(bean);
	}

	
	public int delete(Integer id) {
		JocSubject bean = get(id);
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

	
	public List<JocSubject> find(String queryString) {
		return subjectDao.find(queryString);
	}

	
	public PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex) {
		return subjectDao.findPageByQuery(hql, countHql, pageSize, startIndex);
	}

	
	public JocSubject get(Integer id) {
		return subjectDao.get(id);
	}

	
	public Serializable save(JocSubject bean) throws DataAccessException {
		return subjectDao.save(bean);
	}

	
	public void update(JocSubject bean) throws Exception {
		subjectDao.update(bean);
	}
	
	public void saveOrUpdate(JocSubject bean) throws Exception {
		subjectDao.saveOrUpdate(bean);
	}
	
	@Autowired
	private SubjectDao subjectDao;
}
