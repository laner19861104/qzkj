package com.bip.common.excel.util;

public class ExcelStyle {

	// Fields

	private String style_content;
	private Integer rows;
	private Integer column;
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getStyle_content() {
		return style_content;
	}
	public void setStyle_content(String style_content) {
		this.style_content = style_content;
	}
	public ExcelStyle(String style_content, Integer rows, Integer column) {
		super();
		this.style_content = style_content;
		this.rows = rows;
		this.column = column;
	}
	
	



		

}