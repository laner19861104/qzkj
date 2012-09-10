package com.bip.sys.course.daoimpl;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.sys.course.dao.CourseDao;
import com.bip.sys.course.po.JocCourse;
@Repository
public class CourseDaoImpl extends GenericDao<JocCourse, Integer> implements CourseDao {

}
