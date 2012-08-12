package com.bip.common.util.idinfo.service;

/*********************************************
 * <p>Module:IDInfo.java</p>
 * <p>Description:���ݿ������ֶ�ʹ��</p>
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
	 * @return ����һ��PairValue������������min���ʾ�˴η����ID��Χ��С ����ֵ����max���ʾ�˴η��䷶Χ������ֵ��
	 * @throws GainIDException
	 */

	PairValue getIDs(String $tableName, String $fieldName, int range)
			throws Exception;
}