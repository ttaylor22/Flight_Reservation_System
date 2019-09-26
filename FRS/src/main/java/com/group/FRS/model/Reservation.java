package com.group.FRS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="flight_id")
	private int flightId;
	@Column(name="flight_schedule_id")
	private int flightScheduleId;
	@Column(name="route_id")
	private int routeId;
	@Column(name="user_profile_id")
	private int userProfileId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="date_time")
	private Date dateTime;
	
	
	public Reservation() {
		super();
	}
	
	public Reservation(Long id, int flightId, int flightScheduleId, int routeId, int userProfileId, Date dateTime) {
		super();
		this.id = id;
		this.flightId = flightId;
		this.flightScheduleId = flightScheduleId;
		this.routeId = routeId;
		this.userProfileId = userProfileId;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getFlightScheduleId() {
		return flightScheduleId;
	}
	public void setFlightScheduleId(int flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", flightId=" + flightId + ", flightScheduleId=" + flightScheduleId
				+ ", routeId=" + routeId + ", userProfileId=" + userProfileId + "]";
	}
}