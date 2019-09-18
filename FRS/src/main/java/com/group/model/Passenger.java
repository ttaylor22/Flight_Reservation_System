package com.group.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passenger_id;
	private String passenger_name;
	private int passenger_age;
	private String passenger_gender;
	private int passenger_seat_no;
	private Date booking_date;
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getPassenger_name() {
		return passenger_name;
	}
	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}
	public int getPassenger_age() {
		return passenger_age;
	}
	public void setPassenger_age(int passenger_age) {
		this.passenger_age = passenger_age;
	}
	public String getPassenger_gender() {
		return passenger_gender;
	}
	public void setPassenger_gender(String passenger_gender) {
		this.passenger_gender = passenger_gender;
	}
	public int getPassenger_seat_no() {
		return passenger_seat_no;
	}
	public void setPassenger_seat_no(int passenger_seat_no) {
		this.passenger_seat_no = passenger_seat_no;
	}
	public Date getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	
}
