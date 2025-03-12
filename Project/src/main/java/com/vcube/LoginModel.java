package com.vcube;

public class LoginModel {
	String password;
	String stdid;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getStdid() {
		return stdid;
	}
	public void setStdid(String stdid) {
		this.stdid = stdid;
	}
	public LoginModel(String password, String hallticket) {
		
		this.password = password;
		this.stdid = stdid;
	}


	public LoginModel() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginModel [password=" + password + ", stdid=" + stdid + "]";
	}


	}


