package com.bip.sys.codediction.dmlb.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import com.bip.common.util.PaginationSupport;
import com.bip.sys.codediction.dmlb.po.SysDmlb;

public interface DmlbService {
	/**
	 * ��Ӵ������
	 * 
	 * @param resource
	 * @return
	 */
	Serializable save(SysDmlb dmlb) throws DataAccessException;
	/**
	 * ���������Ҵ������
	 * 
	 * @return
	 */
	SysDmlb get(Integer id);

	List find(String queryString);

	/**
	 * ��ҳ����
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex);

	/**
	 * �޸Ĵ��������Ϣ
	 * 
	 * @param SysDmlb
	 * @return
	 * @throws Exception
	 */
	void update(SysDmlb resource) throws Exception;

	/**
	 * ɾ���������
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysDmlb resource);
	/**
	 * ��������ɾ�������ֵ�
	 * 
	 * @param id
	 * @return
	 */
	
	public Boolean delete(String tablename, String where);
	
	
}
