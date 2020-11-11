package com.bean;

import java.io.Serializable;

public class Student implements Serializable {
    private String stuid;
    private String sname;
    private String sex;
    private String address;
    private String birthday;
    private String classid;
    private String cname;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String stuid, String sname, String sex, String address, String birthday, String classid,
			String cname) {
		super();
		this.stuid = stuid;
		this.sname = sname;
		this.sex = sex;
		this.address = address;
		this.birthday = birthday;
		this.classid = classid;
		this.cname = cname;
	}
	
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", sname=" + sname + ", sex=" + sex + ", address=" + address + ", birthday="
				+ birthday + ", classid=" + classid + ", cname=" + cname + "]";
	}
    
}
