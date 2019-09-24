package com.group.FRS.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "flight_schedule")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class FlightSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="schedule_day")
	private Date scheduleDay;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="flight_id")
	private Flight flight;

	//@JsonIgnore
	//@JsonBackReference
	@OneToMany(mappedBy = "flightSchedule",  orphanRemoval = true, cascade = CascadeType.PERSIST)
	public Set<Route> routes;

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

	public Set<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}
	

	@Override
	public String toString() {
		return "FlightSchedule [id=" + id + ", scheduleDay=" + scheduleDay + ", flight=" + flight + ", routes=" + routes
				+ "]";
	}

	

}