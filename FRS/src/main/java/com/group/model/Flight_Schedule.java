package com.group.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.group.FRS.Flight;

@Entity
@Table(name = "flight_schedule")
public class Flight_Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Flight_flight_id;

	private Date schedule_day;

	@ManyToOne(cascade = CascadeType.ALL)
	private Flight flight;

	@OneToMany(mappedBy = "flight_schedule")
	public Set<Route> routes;

	public Long getFlight_flight_id() {
		return Flight_flight_id;
	}

	public void setFlight_flight_id(Long flight_flight_id) {
		Flight_flight_id = flight_flight_id;
	}

	public Date getSchedule_day() {
		return schedule_day;
	}

	public void setSchedule_day(Date schedule_day) {
		this.schedule_day = schedule_day;
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
		return "Flight_Schedule [Flight_flight_id=" + Flight_flight_id
				+ ", schedule_day=" + schedule_day + ", flight=" + flight + ", routes=" + routes + "]";
	}

}
