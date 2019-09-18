package com.group.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Credential")
public class UserCredential {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_credentials_id")
	private int		userCredentialsId;
	
	@Column(name = "user_type")
	private String 	userType;
	
	@Column(name = "user_id")
	private int		userId;
	
	@Column(name = "password")
	private String	password;
	
	@Column(name = "login_status")
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
	
	
	public void setUserCredentialsId(int userCredentialsId) {
		this.userCredentialsId = userCredentialsId;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
}
