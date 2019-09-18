package com.group.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class PassengerSchedule {
	private int 	scheduleId;
	private Date 	journeyDate;
	private String 	source;
	private String 	destination;
	private String 	reservationType;
	private int 	passengerId;
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

	
	@Autowired
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	@Autowired
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	@Autowired
	public void setSource(String source) {
		this.source = source;
	}
	
	@Autowired
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@Autowired
	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}
	
	@Autowired
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	
	@Autowired
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
}
