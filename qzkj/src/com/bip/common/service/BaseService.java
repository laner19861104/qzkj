
package com.bip.common.service;

import java.util.ArrayList;
import java.util.List;
import com.bip.common.dao.IGenericDao;
import com.bip.common.util.QueryJson;

public class BaseService{
	/**
	 * 
	 * ���ܣ�ͨ�õ����ѯ<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-7 <br>
	 * @param entryDao ʵ�ַ���DAO�ӿڵĶ���
	 * @param VoClazz VO.class
	 * @param conditions ��ѯ�����ַ���
	 * @param pageSize 
	 * @param startIndex 
	 * @return QueryJson���󣬰���total���Լ������б���VoClazzΪnull,�򷵻�PO����
	 */
	public QueryJson PageQuery(IGenericDao entryDao,Class VoClazz,String conditions, int pageSize, int startIndex) {
		List conList=this.splitConditon(conditions);
		QueryJson qj = entryDao.findPageByQuery(VoClazz,conList,pageSize, startIndex);
		return qj;
	}
	/**
	 * 
	 * ���ܣ�ͨ��ԭ��sql��ѯ<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-7 <br>
	 * @param sql ����select rownum as ROWNO,p.id as id from job_enterprise p where 1=1 
	 * @param countSql select count(*) from job_enterprise p where 1=1
	 * @param entryDao ʵ�ַ���DAO�ӿڵĶ���
	 * @param VoClazz  VO.clazz
	 * @param conditions ��ѯ�����ַ���
	 * @param pageSize
	 * @param startIndex
	 * @return QueryJson���󣬰���total���Լ������б���VoClazzΪnull,�򷵻�MAP����
	 */
	public QueryJson PageQueryBySql(String sql,String countSql,IGenericDao entryDao,Class VoClazz,
			String conditions, int pageSize, int startIndex) {
		List conList=this.splitConditon(conditions);
		QueryJson qj = entryDao.findPageByQuery(sql,countSql,VoClazz,conList,pageSize, startIndex);
		return qj;
	}
	/**
	 * 
	 * ���ܣ�ͨ��HQL��ѯ<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-7 <br>
	 * @param hql ����SELECT new com.bip.sys.enterprise.po.VoSysEnterprise(p.id,p.dwbh,p.dwmc,p.xxdz) 
	   From SysEnterprise p where 1=1
	 * @param countHql SELECT count(*) from SysEnterprise p where 1=1
	 * @param entryDao ʵ�ַ���DAO�ӿڵĶ���
	 * @param conditions  ��ѯ�����ַ���
	 * @param pageSize
	 * @param startIndex
	 * @return QueryJson���󣬰���total���Լ������б���VoClazzΪnull,�򷵻�MAP����
	 */
	public QueryJson PageQueryByHql(String hql,String countHql,IGenericDao entryDao,String conditions, 
			int pageSize, int startIndex) {
		List conList=this.splitConditon(conditions);
		QueryJson qj = entryDao.findPageByQuery(hql,countHql,conList,pageSize, startIndex);
		return qj;
	}
	/**
	 * 
	 * ���ܣ�ԭ��sql�б��ѯ������VO����<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-7 <br>
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
	 * ���ܣ��ֽ�conditionsת��Ϊ�ַ�������<br>
	 * author��zj<br>
	 * ���ڣ�2012-7-7 <br>
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
