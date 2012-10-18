package com.bip.www.po;

/**
 * WwwPayRecord entity. @author MyEclipse Persistence Tools
 */

public class WwwPayRecord implements java.io.Serializable {

	// Fields

	private String uuid;
	private String payDate;
	private Double money;
	private String userAccount;
	private String userName;

	// Constructors

	/** default constructor */
	public WwwPayRecord() {
	}

	/** minimal constructor */
	public WwwPayRecord(String uuid) {
		this.uuid = uuid;
	}

	/** full constructor */
	public WwwPayRecord(String uuid, String payDate, Double money,
			String userAccount, String userName) {
		this.uuid = uuid;
		this.payDate = payDate;
		this.money = money;
		this.userAccount = userAccount;
		this.userName = userName;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPayDate() {
		return this.payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}