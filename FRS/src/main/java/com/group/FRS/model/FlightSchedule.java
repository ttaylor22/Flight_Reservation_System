package com.group.FRS.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;

@Entity
@Table(name = "flight_schedule")
public class FlightSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="schedule_day")
	private Date scheduleDay;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="flight_id", nullable=false)
	@JsonIgnore
	private Flight flight;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flightSchedule")
	@JsonIgnore
	public List<Route> routes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getScheduleDay() {
		return scheduleDay;
	}

	public void setScheduleDay(Date scheduleDay) {
		this.scheduleDay = scheduleDay;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "FlightSchedule [id=" + id + ", scheduleDay=" + scheduleDay + ", flight=" + flight + ", routes=" + routes
				+ "]";
	}

	

}
