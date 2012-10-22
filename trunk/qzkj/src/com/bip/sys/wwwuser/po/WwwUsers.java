package com.bip.sys.wwwuser.po;

/**
 * WwwUsers entity. @author MyEclipse Persistence Tools
 */

public class WwwUsers implements java.io.Serializable {

	// Fields

	private String uuid;
	private String account;
	private String password;
	private String username;
	private String tel;
	private String email;
	private String qq;
	private String pwdquestion;
	private String answer;
	private String sex;
	private String birthday;
	private String edulv;
	private String proSkill;
	private String workFor;
	private String postAddress;
	private String postNo;
	private String id;
	private String state;
	private String crDate;
	private Double money;
	private String cnstate;
	private String city;
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	private String province;
	// Constructors

	public String getCnstate() {
		return cnstate;
	}

	public void setCnstate(String cnstate) {
		this.cnstate = cnstate;
	}

	/** default constructor */
	public WwwUsers() {
	}

	/** minimal constructor */
	public WwwUsers(String account, String password) {
		this.account = account;
		this.password = password;
	}

	/** full constructor */
	public WwwUsers(String account, String password, String username,
			String tel, String email, String qq, String pwdquestion,
			String answer, String sex, String birthday, String address,
			String edulv, String proSkill, String workFor, String postAddress,
			String postNo, String id, String state, String crDate, Double money) {
		this.account = account;
		this.password = password;
		this.username = username;
		this.tel = tel;
		this.email = email;
		this.qq = qq;
		this.pwdquestion = pwdquestion;
		this.answer = answer;
		this.sex = sex;
		this.birthday = birthday;
		this.edulv = edulv;
		this.proSkill = proSkill;
		this.workFor = workFor;
		this.postAddress = postAddress;
		this.postNo = postNo;
		this.id = id;
		this.state = state;
		this.crDate = crDate;
		this.money = money;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPwdquestion() {
		return this.pwdquestion;
	}

	public void setPwdquestion(String pwdquestion) {
		this.pwdquestion = pwdquestion;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getEdulv() {
		return this.edulv;
	}

	public void setEdulv(String edulv) {
		this.edulv = edulv;
	}

	public String getProSkill() {
		return this.proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	public String getWorkFor() {
		return this.workFor;
	}

	public void setWorkFor(String workFor) {
		this.workFor = workFor;
	}

	public String getPostAddress() {
		return this.postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getPostNo() {
		return this.postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
		if(state==null||state.equals("0"))
			cnstate="∆Ù”√";
		else
			cnstate="Õ£”√";
			
	}

	public String getCrDate() {
		return this.crDate;
	}

	public void setCrDate(String crDate) {
		this.crDate = crDate;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}