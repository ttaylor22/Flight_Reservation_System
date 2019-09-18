package com.group.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "passenger_schedule")
public class PassengerSchedule {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private int 	scheduleId;
	
	@Column(name = "journey_date")
	private Date 	journeyDate;
	
	@Column(name = "source")
	private String 	source;
	
	@Column(name = "destination")
	private String 	destination;
	
	@Column(name = "reservation_type")
	private String 	reservationType;
	
	@Column(name = "Passenger_passenger_id")
	private int 	passengerId;
	
	@Column(name = "Passenger_Flight_flight_id")
	private int 	flightId;
	
	
	public int getScheduleId() {
		return scheduleId;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public String getReservationType() {
		return reservationType;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public int getFlightId() {
		return flightId;
	}

	
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}
	
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
}
