package com.bip.common.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bip.common.dao.IGenericDao;
import com.bip.common.util.PaginationSupport;
import com.bip.common.util.QueryJson;

public class BaseService{
	/**
	 * 通用查询，单表查询 
	 * @param entryDao
	 * @param VoClazz
	 * @param conditions
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	public QueryJson PageQuery(IGenericDao entryDao,Class VoClazz,String conditions, int pageSize, int startIndex) {
		List conList=this.splitConditon(conditions);
		QueryJson qj = entryDao.findPageByQuery(VoClazz,conList,pageSize, startIndex);
		return qj;
	}
	/**
	 *  通用原生sql查询。
	 * @param sql
	 * @param countSql
	 * @param entryDao
	 * @param VoClazz
	 * @param conditions
	 * @param pageSize
	 * @param startIndex
	 * @return
	 */
	public QueryJson PageQueryBySql(String sql,String countSql,IGenericDao entryDao,Class VoClazz,String conditions, int pageSize, int startIndex) {
		List conList=this.splitConditon(conditions);
		QueryJson qj = entryDao.findPageByQuery(sql,countSql,VoClazz,conList,pageSize, startIndex);
		return qj;
	}
	public QueryJson PageQueryByHql(String hql,String countHql,IGenericDao entryDao,String conditions, int pageSize, int startIndex) {
		List conList=this.splitConditon(conditions);
		QueryJson qj = entryDao.findPageByQuery(hql,countHql,conList,pageSize, startIndex);
		return qj;
	}
	public List QueryBySql(String sql,IGenericDao entryDao,Class VoClazz) {
		return entryDao.queryBySql(sql,VoClazz);
	}
	public List<String[]> splitConditon(String conditions)
	{
		List<String[]> list=new ArrayList<String[]>();
		if(conditions==null)
			return list;
		String [] temp=conditions.split("\\$");
		if(temp.length>0)
		{
			for(String str:temp)
			{
				String [] t=str.split("\\|");
				list.add(t);
			}
		}
		return list;
	}
}
