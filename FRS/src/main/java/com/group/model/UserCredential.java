package com.group.model;

import org.springframework.beans.factory.annotation.Autowired;

public class UserCredential {
	private int		userCredentialsId;
	private String 	userType;
	private int		userId;
	private String	password;
	private boolean loginStatus;
	
	public int getUserCredentialsId() {
		return userCredentialsId;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isLoginStatus() {
		return loginStatus;
	}
	
	
	@Autowired
	public void setUserCredentialsId(int userCredentialsId) {
		this.userCredentialsId = userCredentialsId;
	}
	
	@Autowired
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Autowired
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Autowired
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Autowired
	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
}
