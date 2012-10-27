package com.bip.sys.course.po;

public class JocCourse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4869989997155893851L;
	private Integer id;
	private String code;
	private String video1;
	private String subjectCode;
	private String video3;
	private String video2;
	private String name;
	private Integer cost;
	private String titleimage;
	private String discription;
	
	private String subjectName;
	public JocCourse() {
		super();
	}
	public JocCourse(Integer id) {
		super();
		this.id = id;
	}
	public String getVideo1() {
		return video1;
	}
	public void setVideo1(String video1) {
		this.video1 = video1;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getVideo3() {
		return video3;
	}
	public void setVideo3(String video3) {
		this.video3 = video3;
	}
	public String getVideo2() {
		return video2;
	}
	public void setVideo2(String video2) {
		this.video2 = video2;
	}
	public JocCourse(Integer id, String code, String video1,
			String subjectCode, String video3, String video2, String name,
			Integer cost, String titleimage, String discription) {
		super();
		this.id = id;
		this.code = code;
		this.video1 = video1;
		this.subjectCode = subjectCode;
		this.video3 = video3;
		this.video2 = video2;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}