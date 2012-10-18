package com.bip.www.po;

/**
 * WwwConsumptionRecord entity. @author MyEclipse Persistence Tools
 */

public class WwwConsumptionRecord implements java.io.Serializable {

	// Fields

	private String uuid;
	private String conDate;
	private Float money;
	private String conType;
	private String comment;
	private String userAccount;
	private String username;
	private String typeid;
	private String typename;

	// Constructors

	/** default constructor */
	public WwwConsumptionRecord() {
	}

	/** minimal constructor */
	public WwwConsumptionRecord(String uuid) {
		this.uuid = uuid;
	}

	/** full constructor */
	public WwwConsumptionRecord(String uuid, String conDate, Float money,
			String conType, String comment, String userAccount,
			String username, String typeid, String typename) {
		this.uuid = uuid;
		this.conDate = conDate;
		this.money = money;
		this.conType = conType;
		this.comment = comment;
		this.userAccount = userAccount;
		this.username = username;
		this.typeid = typeid;
		this.typename = typename;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getConDate() {
		return this.conDate;
	}

	public void setConDate(String conDate) {
		this.conDate = conDate;
	}

	public Float getMoney() {
		return this.money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public String getConType() {
		return this.conType;
	}

	public void setConType(String conType) {
		this.conType = conType;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTypeid() {
		return this.typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}