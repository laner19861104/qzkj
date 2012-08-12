package com.bip.common.dao;

public class ReferentDicInfo {
	String tablename;
	String type = null;
	String referentColName;
	String byName;
	String colname;

	public String getColname() {
		return colname;
	}

	public void setColname(String colname) {
		this.colname = colname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void referentColName(String referentColName) {
		int index = referentColName.lastIndexOf(' ');
		if (index != -1) {
			this.referentColName = referentColName.substring(index + 1);

		} else {
			this.referentColName = referentColName;

		}

	}

	public ReferentDicInfo(String tablename, String referentColName,
			String byName, String type) {
		this.tablename = tablename;
		this.byName = byName;
		referentColName(referentColName);
		this.type = type;
	}

	public ReferentDicInfo(String tablename, String referentColName,
			String byName) {
		this.tablename = tablename;
		referentColName(referentColName);
		this.byName = byName;

	}

	public ReferentDicInfo(String tablename, String referentColName) {
		this.tablename = tablename;
		referentColName(referentColName);
		this.byName = referentColName;

	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getReferentColName() {
		return referentColName;
	}

	public void setReferentColName(String referentColName) {
		referentColName(referentColName);
	}

	public String getByName() {
		return byName;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}

}
