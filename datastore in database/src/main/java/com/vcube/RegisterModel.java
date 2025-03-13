package com.vcube;

public class RegisterModel {

String fname;

String Lname;
String password;
String id;

public RegisterModel() {
	super();
	
}





public String getFname() {
	return fname;
}




public void setFname(String fname) {
	this.fname = fname;
	System.out.print(fname);
}




@Override
public String toString() {
	return "RegisterModel [fname=" + fname + ", Lname=" + Lname + ", password=" + password + ", id=" + id + "]";
}





public String getLname() {
	return Lname;
}
public void setLname(String lname) {
	Lname = lname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
}
