package com.bip.sys.course.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bip.common.service.BaseService;
import com.bip.common.util.QueryJson;
import com.bip.sys.course.dao.SubjectDao;
import com.bip.sys.course.po.JocSubject;
import com.bip.sys.course.service.SubjectService;
@Service
public class SubjectServiceImpl extends BaseService implements SubjectService {
	
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
		int count = 0;
		ids = ids.replace(" ", "");
		String[] idarr = ids.split(",");
		for (String id : idarr) {
			if (0 < this.delete(new Integer(id))) {
				count++;
			};
		}
		return count;
	}

	
	public List<JocSubject> find(String queryString) {
		return subjectDao.find(queryString);
	}

	
	public QueryJson findPageByQuery(String conditions, int row, int i) {
		return super.PageQuery(subjectDao, null, conditions, row, i);
	}

	
	public JocSubject get(Integer id) {
		return subjectDao.get(id);
	}

	
	public Serializable save(JocSubject bean) throws DataAccessException {
		return subjectDao.save(bean);
	}

	
	public void update(JocSubject bean) throws Exception {
		try {
			subjectDao.update(bean);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void saveOrUpdate(JocSubject bean) throws Exception {
		try {
			subjectDao.saveOrUpdate(bean);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Autowired
	private SubjectDao subjectDao;
}
