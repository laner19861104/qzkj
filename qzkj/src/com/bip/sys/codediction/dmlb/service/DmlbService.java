package com.bip.sys.codediction.dmlb.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import com.bip.common.util.PaginationSupport;
import com.bip.sys.codediction.dmlb.po.SysDmlb;

public interface DmlbService {
	/**
	 * 添加代码类别
	 * 
	 * @param resource
	 * @return
	 */
	Serializable save(SysDmlb dmlb) throws DataAccessException;
	/**
	 * 按条件查找代码类别
	 * 
	 * @return
	 */
	SysDmlb get(Integer id);

	List find(String queryString);

	/**
	 * 分页查找
	 * 
	 * @param PaginationSupport
	 * 
	 * @return
	 */
	PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex);

	/**
	 * 修改代码类别信息
	 * 
	 * @param SysDmlb
	 * @return
	 * @throws Exception
	 */
	void update(SysDmlb resource) throws Exception;

	/**
	 * 删除代码类别
	 * 
	 * @param id
	 * @return
	 */
	void delete(SysDmlb resource);
	/**
	 * 用于批量删除代码字典
	 * 
	 * @param id
	 * @return
	 */
	
	public Boolean delete(String tablename, String where);
	
	
}
