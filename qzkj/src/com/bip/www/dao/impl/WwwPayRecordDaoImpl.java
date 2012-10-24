/************************************************************
 * 类名：WwwPayRecordDaoImpl.java
 *
 * 类别：Struts2 Action
 * 功能：
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2012-10-18  CFIT-PG   朱江         初版
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
 * 功能：
 * 作者: zj
 * 日期：2012-10-18
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
