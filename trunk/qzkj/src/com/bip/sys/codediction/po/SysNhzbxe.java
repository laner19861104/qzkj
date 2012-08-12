package com.bip.sys.codediction.po;

public class SysNhzbxe implements java.io.Serializable {

	private static final long serialVersionUID = -2557680712470963879L;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 能源指标编号
	 */
	private String nhzbbh;
	/**
	 * 年度
	 */
	private String year;
	/**
	 * 国家限额
	 */
	private Double countryquota;
	/**
	 * 省限额
	 */
	private Double provincequota;

	public SysNhzbxe() {
		super();
	}

	public SysNhzbxe(Integer id) {
		super();
		this.id = id;
	}

	public SysNhzbxe(Integer id, String nhzbbh) {
		super();
		this.id = id;
		this.nhzbbh = nhzbbh;
	}

	public SysNhzbxe(Integer id, String nhzbbh, String year) {
		super();
		this.id = id;
		this.nhzbbh = nhzbbh;
		this.year = year;
	}

	public SysNhzbxe(Integer id, String nhzbbh, String year,
			Double countryquota, Double provincequota) {
		super();
		this.id = id;
		this.nhzbbh = nhzbbh;
		this.year = year;
		this.countryquota = countryquota;
		this.provincequota = provincequota;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNhzbbh() {
		return nhzbbh;
	}

	public void setNhzbbh(String nhzbbh) {
		this.nhzbbh = nhzbbh;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getCountryquota() {
		return countryquota;
	}

	public void setCountryquota(Double countryquota) {
		this.countryquota = countryquota;
	}

	public Double getProvincequota() {
		return provincequota;
	}

	public void setProvincequota(Double provincequota) {
		this.provincequota = provincequota;
	}

}