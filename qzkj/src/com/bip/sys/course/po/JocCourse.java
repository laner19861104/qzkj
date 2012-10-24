package com.bip.sys.course.po;

import com.bip.common.upload.po.JocFile;

public class JocCourse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4869989997155893851L;
	private Integer id;
	private String code;
	private JocFile video1;
	private JocSubject subject;
	private JocFile video3;
	private JocFile video2;
	private String name;
	private Integer cost;
	private String titleimage;
	private String discription;
	public JocCourse() {
		super();
	}
	public JocCourse(Integer id) {
		super();
		this.id = id;
	}
	public JocCourse(Integer id, String code, JocFile video1,
			JocSubject subject, JocFile video3, JocFile video2, String name,
			Integer cost, String titleimage, String discription) {
		super();
		this.id = id;
		this.code = code;
		this.video1 = video1;
		this.subject = subject;
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
	public JocFile getVideo1() {
		return video1;
	}
	public void setVideo1(JocFile video1) {
		this.video1 = video1;
	}
	public JocSubject getSubject() {
		return subject;
	}
	public void setSubject(JocSubject subject) {
		this.subject = subject;
	}
	public JocFile getVideo3() {
		return video3;
	}
	public void setVideo3(JocFile video3) {
		this.video3 = video3;
	}
	public JocFile getVideo2() {
		return video2;
	}
	public void setVideo2(JocFile video2) {
		this.video2 = video2;
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
}