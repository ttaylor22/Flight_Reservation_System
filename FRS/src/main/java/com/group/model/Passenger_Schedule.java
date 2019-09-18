package com.group.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Passenger_Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schedule_id;
	private Date journey_date;
	private String source;
	private String destination;
	private String reservation_type;
	private int Passenger_passenger_id;
	private int Passenger_Flight_flight_id;
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public Date getJourney_date() {
		return journey_date;
	}
	public void setJourney_date(Date journey_date) {
		this.journey_date = journey_date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getReservation_type() {
		return reservation_type;
	}
	public void setReservation_type(String reservation_type) {
		this.reservation_type = reservation_type;
	}
	public int getPassenger_passenger_id() {
		return Passenger_passenger_id;
	}
	public void setPassenger_passenger_id(int passenger_passenger_id) {
		Passenger_passenger_id = passenger_passenger_id;
	}
	public int getPassenger_Flight_flight_id() {
		return Passenger_Flight_flight_id;
	}
	public void setPassenger_Flight_flight_id(int passenger_Flight_flight_id) {
		Passenger_Flight_flight_id = passenger_Flight_flight_id;
	}
	
}
