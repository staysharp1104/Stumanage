package com.unis.vo;

public class CourseVO {
	private int course_id;
	private String course_name;
	private String course_mode;
	private String course_credit;
	private int course_display;

	public int getCourse_display() {
		return course_display;
	}

	public void setCourse_display(int course_display) {
		this.course_display = course_display;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_mode() {
		return course_mode;
	}

	public void setCourse_mode(String course_mode) {
		this.course_mode = course_mode;
	}

	public String getCourse_credit() {
		return course_credit;
	}

	public void setCourse_credit(String course_credit) {
		this.course_credit = course_credit;
	}

}
