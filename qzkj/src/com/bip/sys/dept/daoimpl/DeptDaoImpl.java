/************************************************************
 * ������DeptDaoImpl.java
 *
 * ���Hibernate DaoImpl
 * ���ܣ����Ź���Hibernateʵ�֡�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-27  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.sys.dept.daoimpl;

import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.sys.dept.dao.*;
import com.bip.sys.dept.po.*;
@Repository
public class DeptDaoImpl extends GenericDao<SysDepartment, Integer> implements
		DeptDao {

}
