/************************************************************
 * ������WwwPayRecordDaoImpl.java
 *
 * ���Struts2 Action
 * ���ܣ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2012-10-18  CFIT-PG   �콭         ����
 *
 * Copyright (c) 2012 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
package com.bip.www.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.bip.common.dao.GenericDao;
import com.bip.www.dao.WwwPayRecordDao;
import com.bip.www.po.WwwPayRecord;

/**
 * ���ܣ�
 * ����: zj
 * ���ڣ�2012-10-18
 */
@Repository
public class WwwPayRecordDaoImpl extends GenericDao<WwwPayRecord,String> implements WwwPayRecordDao{

	/* (non-Javadoc)
	 * @see com.bip.www.dao.WwwPayRecordDao#executeHQL(java.lang.String)
	 */
	@Override
	public String executeHQL(final String hql) {
		String total=this.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				Object obj=arg0.createQuery(hql).uniqueResult();
				return obj==null?"0":obj.toString();
			}
		}).toString();
		return total;
	}

}
