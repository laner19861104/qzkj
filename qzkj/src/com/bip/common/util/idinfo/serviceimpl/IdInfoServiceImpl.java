package com.bip.common.util.idinfo.serviceimpl;

/*********************************************
 * <p>Module:IDInfo.java</p>
 * <p>Description:���ݿ������ֶ�ʹ��</p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: </p>
 * <p>author: zhaosy zhaosy_1022@163.com </p>
 * <p>version: version 1.0 </p>
 ********************************************/

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bip.common.util.idinfo.dao.IdInfoDao;
import com.bip.common.util.idinfo.po.SysIdinfo;
import com.bip.common.util.idinfo.po.SysIdinfoId;
import com.bip.common.util.idinfo.service.*;

//self stuff
@Service
public class IdInfoServiceImpl implements IdInfoService {
	@Resource
	private IdInfoDao idinfoDao;

	public void setIdinfoDao(IdInfoDao idinfoDao) {
		this.idinfoDao = idinfoDao;
	}

	public IdInfoDao getIdinfoDao() {
		return idinfoDao;
	}

	// here begin the real method

	/**
	 * get a ID for the specified table(object)
	 * 
	 * @param $tableName
	 *            the table name in the database the ID name in the table DDL
	 * @return A ID allocated
	 * @throws GainIDException
	 */
	public long getID(String $tableName, String $fieldName) throws Exception {

		PairValue pV = getIDs($tableName, $fieldName, 1);
		if (pV != null)
			return pV.max;
		else
			return -1;
	}

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

	public PairValue getIDs(String $tableName, String $fieldName, int range)
			throws Exception {

		if (range <= 0)
			return null;
		PairValue pairValue = new PairValue();
		List idlist = new ArrayList();

		SysIdinfoId sidinfoid = new SysIdinfoId($tableName, $fieldName);
		SysIdinfo sidinfo = new SysIdinfo(sidinfoid);
		try {
			String where = " where tablename like '" + $tableName
					+ "' and fieldname like '" + $fieldName + "'";
			String sql = "FROM SysIdinfo " + where;
			idlist = idinfoDao.find(sql);
			if (idlist == null || idlist.size() == 0) {
				System.out.println("idlist is null");
				pairValue.min = 1;
				pairValue.max = 100;
				// ��Ӵ����ݱ��ֶε����ݱ���
				sidinfoid.setTablename($tableName);
				sidinfoid.setFieldname($fieldName);
				sidinfo.setCurrentvalue(1);
				sidinfo.setLaststep(1);
				sidinfo.setId(sidinfoid);
				idinfoDao.save(sidinfo);

			} else {
				// ��õ�ǰֵ������1
				pairValue.min = (((SysIdinfo) (idlist.get(0)))
						.getCurrentvalue()).intValue();

				pairValue.max = pairValue.min + range;
				System.out.println("max is " + pairValue.max);
				// ����sys_idinfo��
				sidinfoid.setTablename($tableName);
				sidinfoid.setFieldname($fieldName);
				sidinfo.setCurrentvalue(Integer.parseInt(String.valueOf(pairValue.max)));
				sidinfo.setLaststep(1);
				sidinfo.setId(sidinfoid);
				idinfoDao.update("update sys_idinfo set currentvalue="+pairValue.max+" where tablename='"+$tableName+"' and fieldname='"+$fieldName+"'");
			}
		} catch (java.lang.Exception ex) {
			pairValue = null;
			ex.printStackTrace();
			throw new Exception(ex.toString());
		}

		if (pairValue == null) {
			pairValue.min = 1;
			pairValue.max = 1;
		}

		return pairValue;
	}

}