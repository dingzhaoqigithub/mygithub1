package com.bean;

import java.io.Serializable;

public class Clazz implements Serializable {
 private String cid;
 private String cname;
public Clazz() {
	super();
	// TODO Auto-generated constructor stub
}
public Clazz(String cid, String cname) {
	super();
	this.cid = cid;
	this.cname = cname;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
@Override
public String toString() {
	return "Clazz [cid=" + cid + ", cname=" + cname + "]";
}
 
}
