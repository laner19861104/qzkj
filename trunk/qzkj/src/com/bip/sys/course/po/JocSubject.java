package com.bip.sys.course.po;

public class JocSubject implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4773320764979801269L;
	private Integer id;
	private String name;
	private Integer cost;
	private String titleimage;
	private String discription;
	public JocSubject(Integer id) {
		super();
		this.id = id;
	}
	public JocSubject(Integer id, String name, Integer cost, String titleimage,
			String discription) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.titleimage = titleimage;
		this.discription = discription;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getTitleimage() {
		return titleimage;
	}
	public void setTitleimage(String titleimage) {
		this.titleimage = titleimage;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
}