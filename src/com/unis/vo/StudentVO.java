package com.unis.vo;

/**
 * ѧ��vo
 * 
 * @author Tina
 * 
 */
public class StudentVO {
	private String st_id; // ѧ��id
	private String st_name; // ����
	private String st_sex; // �Ա�
	private String st_birth; // ��������
	private String st_phone; // �绰
	private String st_password;// ����
	private int st_flag;// ����Ա��� flag=1������Ա����flag=0��ѧ����
	private int st_display;//�Ƿ�ע��
	
	
	public int getSt_display() {
		return st_display;
	}

	public void setSt_display(int st_display) {
		this.st_display = st_display;
	}

	public String getSt_id() {
		return st_id;
	}

	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}

	public String getSt_password() {
		return st_password;
	}

	public void setSt_password(String st_password) {
		this.st_password = st_password;
	}

	public int getSt_flag() {
		return st_flag;
	}

	public void setSt_flag(int st_flag) {
		this.st_flag = st_flag;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getSt_sex() {
		return st_sex;
	}

	public void setSt_sex(String st_sex) {
		this.st_sex = st_sex;
	}



	public String getSt_birth() {
		return st_birth;
	}

	public void setSt_birth(String st_birth) {
		this.st_birth = st_birth;
	}

	public String getSt_phone() {
		return st_phone;
	}

	public void setSt_phone(String st_phone) {
		this.st_phone = st_phone;
	}

}
