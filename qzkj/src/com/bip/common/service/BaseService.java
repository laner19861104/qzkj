
package com.bip.common.service;

import java.util.ArrayList;
import java.util.List;
import com.bip.common.dao.IGenericDao;
import com.bip.common.util.QueryJson;

public class BaseService{
	/**
	 * 
	 * 功能：通用单表查询<br>
	 * author：zj<br>
	 * 日期：2012-7-7 <br>
	 * @param entryDao 实现泛型DAO接口的对象
	 * @param VoClazz VO.class
	 * @param conditions 查询条件字符串
	 * @param pageSize 
	 * @param startIndex 
	 * @return QueryJson对象，包含total，以及数据列表，若VoClazz为null,则返回PO集合
	 */
	public QueryJson PageQuery(IGenericDao entryDao,Class VoClazz,String conditions, int pageSize, int startIndex) {
		List conList=this.splitConditon(conditions);
		QueryJson qj = entryDao.findPageByQuery(VoClazz,conList,pageSize, startIndex);
		return qj;
	}
	/**
	 * 
	 * 功能：通用原生sql查询<br>
	 * author：zj<br>
	 * 日期：2012-7-7 <br>
	 * @param sql 例：select rownum as ROWNO,p.id as id from job_enterprise p where 1=1 
	 * @param countSql select count(*) from job_enterprise p where 1=1
	 * @param entryDao 实现泛型DAO接口的对象
	 * @param VoClazz  VO.clazz
	 * @param conditions 查询条件字符串
	 * @param pageSize
	 * @param startIndex
	 * @return QueryJson对象，包含total，以及数据列表，若VoClazz为null,则返回MAP集合
	 */
	public QueryJson PageQueryBySql(String sql,String countSql,IGenericDao entryDao,Class VoClazz,
			String conditions, int pageSize, int startIndex) {
		List conList=this.splitConditon(conditions);
		QueryJson qj = entryDao.findPageByQuery(sql,countSql,VoClazz,conList,pageSize, startIndex);
		return qj;
	}
	/**
	 * 
	 * 功能：通用HQL查询<br>
	 * author：zj<br>
	 * 日期：2012-7-7 <br>
	 * @param hql 例：SELECT new com.bip.sys.enterprise.po.VoSysEnterprise(p.id,p.dwbh,p.dwmc,p.xxdz) 
	   From SysEnterprise p where 1=1
	 * @param countHql SELECT count(*) from SysEnterprise p where 1=1
	 * @param entryDao 实现泛型DAO接口的对象
	 * @param conditions  查询条件字符串
	 * @param pageSize
	 * @param startIndex
	 * @return QueryJson对象，包含total，以及数据列表，若VoClazz为null,则返回MAP集合
	 */
	public QueryJson PageQueryByHql(String hql,String countHql,IGenericDao entryDao,String conditions, 
			int pageSize, int startIndex) {
		List conList=this.splitConditon(conditions);
		QueryJson qj = entryDao.findPageByQuery(hql,countHql,conList,pageSize, startIndex);
		return qj;
	}
	/**
	 * 
	 * 功能：原生sql列表查询，返回VO集合<br>
	 * author：zj<br>
	 * 日期：2012-7-7 <br>
	 * @param sql
	 * @param entryDao
	 * @param VoClazz
	 * @return
	 */
	public List QueryBySql(String sql,IGenericDao entryDao,Class VoClazz) {
		return entryDao.queryBySql(sql,VoClazz);
	}
	/**
	 * 
	 * 功能：分解conditions转化为字符串数组<br>
	 * author：zj<br>
	 * 日期：2012-7-7 <br>
	 * @param conditions
	 * @return
	 */
	private List<String[]> splitConditon(String conditions)
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
