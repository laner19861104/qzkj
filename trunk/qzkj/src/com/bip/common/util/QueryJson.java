package com.bip.common.util;

import java.util.List;

public class QueryJson {
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public List getFooter() {
		return footer;
	}
	public void setFooter(List footer) {
		this.footer = footer;
	}
	private Integer total;
	private List rows;
	private List footer;
public QueryJson(Integer total,List rows)
{
	this.total=total;
	this.rows=rows;
}
public QueryJson(Integer total,List rows,List footer)
{
	this.total=total;
	this.rows=rows;
	this.footer=footer;
}
}
