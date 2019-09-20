package com.group.FRS.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="gender")
	private String gender;
	@Column(name="seat_no")
	private int seatNo;
	@Column(name="booking_date")
	private Date bookingDate;
	
	

	public Passenger(String name, int age, String gender, int seatNo, Date bookingDate, Flight flight) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.seatNo = seatNo;
		this.bookingDate = bookingDate;
		this.flight = flight;
	}
	
	

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}



	//@ManyToOne(targetEntity=Flight.class, fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST})
	@JsonIgnore
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="flight_id", nullable=false)
	private Flight flight;

	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "passenger")
	//@JsonIgnore
	//public List<PassengerSchedule> passengerSchedules;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", seatNo=" + seatNo
				+ ", bookingDate=" + bookingDate + ", flight=" + flight + "]";
	}

	
	
}