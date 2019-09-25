package com.group.FRS.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "passenger")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="age")
	private int age;
	@Column(name="gender")
	private String gender;
	@Column(name="seat_no")
	private int seatNo;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="booking_date")
	private Date bookingDate;
	
	@JsonIgnore
	//@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="flight_id")
	private Flight flight;
	
	//@JsonIgnore
	//@JsonBackReference
	@OneToMany(mappedBy = "passenger",  
				orphanRemoval = true, 
				cascade = CascadeType.PERSIST)
	public List<PassengerSchedule> passengerSchedules = new ArrayList<>();

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(Long id, String firstName, String lastName, int age, String gender, int seatNo, Date bookingDate,
			Flight flight, List<PassengerSchedule> passengerSchedules) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.seatNo = seatNo;
		this.bookingDate = bookingDate;
		this.flight = flight;
		this.passengerSchedules = passengerSchedules;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public List<PassengerSchedule> getPassengerSchedules() {
		return passengerSchedules;
	}

	public void setPassengerSchedules(List<PassengerSchedule> passengerSchedules) {
		this.passengerSchedules = passengerSchedules;
	}

	public void addPassengerSchedule(PassengerSchedule passengerSchedule) {
		passengerSchedule.setPassenger(this);
		this.passengerSchedules.add(passengerSchedule);
	}

	
	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", seatNo=" + seatNo + ", bookingDate=" + bookingDate + ", flight=" + flight
				+ ", passengerSchedules=" + passengerSchedules + "]";
	}
	
}