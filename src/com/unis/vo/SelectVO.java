package com.unis.vo;

public class SelectVO {
	private int select_id;
	private String student_id;
	private int course_id;
	private String st_name;
	private String course_name;
	
	
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getSelect_id() {
		return select_id;
	}
	public void setSelect_id(int select_id) {
		this.select_id = select_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
}
