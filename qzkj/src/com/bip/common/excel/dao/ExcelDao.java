package com.bip.common.excel.dao;

import java.util.List;

public interface ExcelDao {
	public List addBatch(final List values, final String tablename);
	public List addBatchByUuid(final List values, final String tablename);
}
