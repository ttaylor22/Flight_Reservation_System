package com.group.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Flight_Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Flight_flight_id;
	private int Route_route_id;
	private Date schedule_day;
	public int getFlight_flight_id() {
		return Flight_flight_id;
	}
	public void setFlight_flight_id(int flight_flight_id) {
		Flight_flight_id = flight_flight_id;
	}
	public int getRoute_route_id() {
		return Route_route_id;
	}
	public void setRoute_route_id(int route_route_id) {
		Route_route_id = route_route_id;
	}
	public Date getSchedule_day() {
		return schedule_day;
	}
	public void setSchedule_day(Date schedule_day) {
		this.schedule_day = schedule_day;
	}
	
	
}
