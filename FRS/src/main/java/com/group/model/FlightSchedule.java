package com.group.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "flight_schedule")
public class FlightSchedule {
	
	@Column(name = "Flight_flight_id")
	private int  	flightId;
	
	@Column(name = "Route_route_id")
	private int  	routeId;
	
	@Column(name = "schedule_day")
	private Date 	scheduleDay;
	
	
	public int getFlightId() {
		return flightId;
	}
	public int getRouteId() {
		return routeId;
	}
	public Date getScheduleDay() {
		return scheduleDay;
	}

	
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
	public void setScheduleDay(Date scheduleDay) {
		this.scheduleDay = scheduleDay;
	}
	
	
}
