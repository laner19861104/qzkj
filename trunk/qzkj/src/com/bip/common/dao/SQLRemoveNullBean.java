package com.bip.common.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.bip.common.util.SqlUtil;

public class SQLRemoveNullBean extends SQLBean {

	public SqlVO getTableInfo(String tablename,Connection db,Map values){
		
		SqlVO vo=super.getTableInfo(tablename, db,values);
		
		List list = vo.getCols();
		List rList = new ArrayList();
		List colname = new ArrayList();
		String key[] = new String[vo.getKeys().size()];
		SqlVO sqlVo = new SqlVO();
		int i = 0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			ColVO col = (ColVO) iterator.next();
			if(col.isKey) {
				key[i] = col.getName();
				i++;

			}else if (values.get(col.getName()) != null ) {
				rList.add(col);
				colname.add(col.getName());
			} 

		}

		sqlVo.setTablename(vo.getTablename());
		sqlVo.setCols(rList);
		sqlVo.setKeys(vo.getKeys());
		sqlVo.setInsertSql(SqlUtil.getInsertSql(tablename, colname));
		sqlVo.setUpdateSql(SqlUtil.getUpdateSql(tablename, colname, key));

		return sqlVo;
		
		
	}
}
