package com.group.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class FlightSchedule {
	private int  flightId;
	private int  routeId;
	private Date scheduleDay;
	
	public int getFlightId() {
		return flightId;
	}
	public int getRouteId() {
		return routeId;
	}
	public Date getScheduleDay() {
		return scheduleDay;
	}

	
	@Autowired
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	
	@Autowired
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
	@Autowired
	public void setScheduleDay(Date scheduleDay) {
		this.scheduleDay = scheduleDay;
	}
	
	
}
