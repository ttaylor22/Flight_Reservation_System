package com.group.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservation_id;
	private Date journey_date;
	private int no_of_seats;
	private int user_id;
	private int Flight_flight_id;
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public Date getJourney_date() {
		return journey_date;
	}
	public void setJourney_date(Date journey_date) {
		this.journey_date = journey_date;
	}
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFlight_flight_id() {
		return Flight_flight_id;
	}
	public void setFlight_flight_id(int flight_flight_id) {
		Flight_flight_id = flight_flight_id;
	}
	
}
