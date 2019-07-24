package me.sifan.domain;

import java.util.Date;

/**
 * 这是一个domain类,学生类,实例化对象代表这数据库里面的一条记录
 * 一共有七个属性:
 * 	id,姓名,性别,电话号码,生日,爱好,简介
 * @author Sifan
 * @date 2019-07-19
 * @version 1.0
 */

public class Student {
	
	private int sid;
	private String sname;
	private String gender;
	private String phonenum;
	private Date birthday;
	private String hobby;
	private String info;
	
	public Student() {}
	
	public Student(String sname, String gender, String phonenum, Date birthday, String hobby, String info) {
		this.sname = sname;
		this.gender = gender;
		this.phonenum = phonenum;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}
	
	public Student(int sid,String sname, String gender, String phonenum, Date birthday, String hobby, String info) {
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.phonenum = phonenum;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	

	
	
}
