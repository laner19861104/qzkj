package com.bip.common.util.idinfo.service;

/*********************************************
 * <p>Module:IDInfo.java</p>
 * <p>Description:数据库自增字段使用</p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: </p>
 * <p>author: zhaosy zhaosy_1022@163.com </p>
 * <p>version: version 1.0 </p>
 ********************************************/
//self stuff

public interface IdInfoService {

	// here begin the real method

	/**
	 * get a ID for the specified table(object)
	 * 
	 * @param $tableName
	 *            the table name in the database
	 * @param $fieldName
	 *            the ID name in the table DDL
	 * @return A ID allocated
	 * @throws GainIDException
	 */
	long getID(String $tableName, String $fieldName) throws Exception;

	/**
	 * get a group of IDs for the specified table(object)
	 * 
	 * @param $tableName
	 *            the table name in the database
	 * @param $fieldName
	 *            the ID name in the table DDL
	 * @param $range
	 *            the number of IDs needed to allocated
	 * @return 返回一个PairValue对象，这个对象的min域表示此次分配的ID范围最小 可用值，而max域表示此次分配范围最大可用值。
	 * @throws GainIDException
	 */

	PairValue getIDs(String $tableName, String $fieldName, int range)
			throws Exception;
}