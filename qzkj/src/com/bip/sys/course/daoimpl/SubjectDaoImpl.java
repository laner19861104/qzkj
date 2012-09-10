package com.bip.sys.course.daoimpl;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.sys.course.dao.SubjectDao;
import com.bip.sys.course.po.JocSubject;
@Repository
public class SubjectDaoImpl extends GenericDao<JocSubject, Integer> implements SubjectDao {

}
