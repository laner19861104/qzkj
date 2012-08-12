package com.bip.sys.user.po;

/**
 * SysUsers entity. @author MyEclipse Persistence Tools
 */

public class SysUsers implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String userxm;
	private String username;
	private String password;
	private String postpriv;
	private String deptid;
	private String deptname;
	private String sex;
	private String birthday;
	private String ishidebirthday;
	private String addresshome;
	private String ziphome;
	private String telhome;
	private String mobile;
	private String ishidemobile;
	private String email;
	private String oicq;
	private String icq;
	private String msn;
	private String skype;
	private String nickname;
	private String smson;
	private String dutytype;
	private String state;
	private String bindip;
	private String usingkey;
	private String uguid;
	private String ukey;
	private String usetype;
	private String regioncode;
	private String res01;
	private String res02;
	private String res03;
	private String res04;
	private Double res05;
	private Double res06;
	private String ssqy;

	// Constructors

	/** default constructor */
	public SysUsers() {
	}

	/** minimal constructor */
	public SysUsers(Integer userid, String userxm, String username,
			String password) {
		this.userid = userid;
		this.userxm = userxm;
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public SysUsers(Integer userid, String userxm, String username,
			String password, String postpriv, String deptid, String sex,
			String birthday, String ishidebirthday, String addresshome,
			String ziphome, String telhome, String mobile, String ishidemobile,
			String email, String oicq, String icq, String msn, String skype,
			String nickname, String smson, String dutytype, String state,
			String bindip, String usingkey, String uguid, String ukey,
			String usetype, String regioncode, String res01, String res02,
			String res03, String res04, Double res05, Double res06, String ssqy,String deptname) {
		this.userid = userid;
		this.userxm = userxm;
		this.username = username;
		this.password = password;
		this.postpriv = postpriv;
		this.deptid = deptid;
		this.sex = sex;
		this.birthday = birthday;
		this.ishidebirthday = ishidebirthday;
		this.addresshome = addresshome;
		this.ziphome = ziphome;
		this.telhome = telhome;
		this.mobile = mobile;
		this.ishidemobile = ishidemobile;
		this.email = email;
		this.oicq = oicq;
		this.icq = icq;
		this.msn = msn;
		this.skype = skype;
		this.nickname = nickname;
		this.smson = smson;
		this.dutytype = dutytype;
		this.state = state;
		this.bindip = bindip;
		this.usingkey = usingkey;
		this.uguid = uguid;
		this.ukey = ukey;
		this.usetype = usetype;
		this.regioncode = regioncode;
		this.res01 = res01;
		this.res02 = res02;
		this.res03 = res03;
		this.res04 = res04;
		this.res05 = res05;
		this.res06 = res06;
		this.ssqy = ssqy;
		this.deptname=deptname;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUserxm() {
		return this.userxm;
	}

	public void setUserxm(String userxm) {
		this.userxm = userxm;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPostpriv() {
		return this.postpriv;
	}

	public void setPostpriv(String postpriv) {
		this.postpriv = postpriv;
	}

	public String getDeptid() {
		return this.deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
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

	public String getIshidebirthday() {
		return this.ishidebirthday;
	}

	public void setIshidebirthday(String ishidebirthday) {
		this.ishidebirthday = ishidebirthday;
	}

	public String getAddresshome() {
		return this.addresshome;
	}

	public void setAddresshome(String addresshome) {
		this.addresshome = addresshome;
	}

	public String getZiphome() {
		return this.ziphome;
	}

	public void setZiphome(String ziphome) {
		this.ziphome = ziphome;
	}

	public String getTelhome() {
		return this.telhome;
	}

	public void setTelhome(String telhome) {
		this.telhome = telhome;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIshidemobile() {
		return this.ishidemobile;
	}

	public void setIshidemobile(String ishidemobile) {
		this.ishidemobile = ishidemobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOicq() {
		return this.oicq;
	}

	public void setOicq(String oicq) {
		this.oicq = oicq;
	}

	public String getIcq() {
		return this.icq;
	}

	public void setIcq(String icq) {
		this.icq = icq;
	}

	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getSkype() {
		return this.skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSmson() {
		return this.smson;
	}

	public void setSmson(String smson) {
		this.smson = smson;
	}

	public String getDutytype() {
		return this.dutytype;
	}

	public void setDutytype(String dutytype) {
		this.dutytype = dutytype;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBindip() {
		return this.bindip;
	}

	public void setBindip(String bindip) {
		this.bindip = bindip;
	}

	public String getUsingkey() {
		return this.usingkey;
	}

	public void setUsingkey(String usingkey) {
		this.usingkey = usingkey;
	}

	public String getUguid() {
		return this.uguid;
	}

	public void setUguid(String uguid) {
		this.uguid = uguid;
	}

	public String getUkey() {
		return this.ukey;
	}

	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	public String getUsetype() {
		return this.usetype;
	}

	public void setUsetype(String usetype) {
		this.usetype = usetype;
	}

	public String getRegioncode() {
		return this.regioncode;
	}

	public void setRegioncode(String regioncode) {
		this.regioncode = regioncode;
	}

	public String getRes01() {
		return this.res01;
	}

	public void setRes01(String res01) {
		this.res01 = res01;
	}

	public String getRes02() {
		return this.res02;
	}

	public void setRes02(String res02) {
		this.res02 = res02;
	}

	public String getRes03() {
		return this.res03;
	}

	public void setRes03(String res03) {
		this.res03 = res03;
	}

	public String getRes04() {
		return this.res04;
	}

	public void setRes04(String res04) {
		this.res04 = res04;
	}

	public Double getRes05() {
		return this.res05;
	}

	public void setRes05(Double res05) {
		this.res05 = res05;
	}

	public Double getRes06() {
		return this.res06;
	}

	public void setRes06(Double res06) {
		this.res06 = res06;
	}

	public String getSsqy() {
		return this.ssqy;
	}

	public void setSsqy(String ssqy) {
		this.ssqy = ssqy;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}