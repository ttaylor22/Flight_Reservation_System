package com.group.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class User_Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_profile_id;

	private String name;
	private Date date_of_birth;
	private String gender;
	private String address;
	private String mobile_number;
	private String email_id;

	@OneToMany(mappedBy = "user_profile")
	private Set<Reservation> reservations;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Credential_user_credentials_id", referencedColumnName = "user_profile_id")
	private User_Credential user_credential;

	public Long getUser_profile_id() {
		return user_profile_id;
	}

	public void setUser_profile_id(Long user_profile_id) {
		this.user_profile_id = user_profile_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public User_Credential getUser_credential() {
		return user_credential;
	}

	public void setUser_credential(User_Credential user_credential) {
		this.user_credential = user_credential;
	}

	@Override
	public String toString() {
		return "User_Profile [user_profile_id=" + user_profile_id + ", name=" + name + ", date_of_birth="
				+ date_of_birth + ", gender=" + gender + ", address=" + address + ", mobile_number=" + mobile_number
				+ ", email_id=" + email_id + ", reservations=" + reservations + ", user_credential=" + user_credential
				+ "]";
	}

}
