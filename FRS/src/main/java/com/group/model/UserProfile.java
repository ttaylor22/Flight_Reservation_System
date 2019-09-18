package com.group.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class UserProfile {
	private int userProfileId;
	private String name;
	private Date dateOfBirth;
	private String gender;
	private String address;
	private String mobileNumber;
	private String emailId;
	private int userCredentialsId;
	
	
	public int getUserProfileId() {
		return userProfileId;
	}
	public String getName() {
		return name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public String getAddress() {
		return address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public int getUserCredentialsId() {
		return userCredentialsId;
	}
	
	@Autowired
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	
	@Autowired
	public void setName(String name) {
		this.name = name;
	}
	
	@Autowired
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Autowired
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Autowired
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Autowired
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	@Autowired
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Autowired
	public void setUserCredentialsId(int userCredentialsId) {
		this.userCredentialsId = userCredentialsId;
	}
	
	
	
	
}
