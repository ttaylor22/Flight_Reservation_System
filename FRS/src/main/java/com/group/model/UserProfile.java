package com.group.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "User_Profile")
public class UserProfile {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_profile_id")
	private int 	userProfileId;
	
	@Column(name = "name")
	private String 	name;
	
	@Column(name = "date_of_birth")
	private Date 	dateOfBirth;
	
	@Column(name = "gender")
	private String 	gender;
	
	@Column(name = "address")
	private String 	address;
	
	@Column(name = "mobile_number")
	private String 	mobileNumber;
	
	@Column(name = "emailId")
	private String 	emailId;
	
	@Column(name = "User_Credential_user_credentials_id")
	private int 	userCredentialsId;
	
	
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
	
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public void setUserCredentialsId(int userCredentialsId) {
		this.userCredentialsId = userCredentialsId;
	}
	
	
	
	
}
