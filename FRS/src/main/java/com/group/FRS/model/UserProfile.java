package com.group.FRS.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "userProfile")
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Column(name="gender")
	private String gender;
	@Column(name="address")
	private String address;
	@Column(name="mobile_number")
	private String mobileNumber;
	@Column(name="email_id")
	private String emailId;

	@JsonIgnore
	//@JsonBackReference
	@OneToMany(mappedBy = "userProfile", orphanRemoval = true, cascade = CascadeType.PERSIST)
	private Set<PassengerSchedule> passengerSchedules;

	
	//@JsonIgnore
	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "user_credential_id", referencedColumnName = "id")
	private UserCredential userCredential;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		System.out.println(id);
		this.id = id;
		System.out.println("id set");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println(firstName);
		this.firstName = firstName;
		System.out.println("firstName set");
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		System.out.println(lastName);
		this.lastName = lastName;
		System.out.println("lastName set");
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		System.out.println(dateOfBirth);
		this.dateOfBirth = dateOfBirth;
		System.out.println("dateOfBirth set");
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		System.out.println(gender);
		this.gender = gender;
		System.out.println("gender set");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println(address);
		this.address = address;
		System.out.println("address set");
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		System.out.println(mobileNumber);
		this.mobileNumber = mobileNumber;
		System.out.println("mobileNumber set");
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		System.out.println(emailId);
		this.emailId = emailId;
		System.out.println("emailId set");
	}
/*
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
*/
	public UserCredential getUserCredential() {
		return userCredential;
	}

	public void setUserCredential(UserCredential userCredential) {
		System.out.println("USER CREDENTIAL SET");
		this.userCredential = userCredential;
	}
/*
	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", address=" + address + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", reservations="
				+ reservations + ", userCredential=" + userCredential + "]";
	}
*/
	
}