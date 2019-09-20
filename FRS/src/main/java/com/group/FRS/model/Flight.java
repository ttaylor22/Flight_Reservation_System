package com.group.FRS.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;

@Entity
@Table(name = "flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	@Column(name="seating_capacity")
	private int seatingCapacity;
	@Column(name="reservation_capacity")
	private int reservationCapacity;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
	@JsonIgnore
	private List<Passenger> passengers;

	@ManyToMany
	@JsonIgnore
	public List<Reservation> reservations;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
	@JsonIgnore
	private List<FlightSchedule> flightSchedules;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public int getReservationCapacity() {
		return reservationCapacity;
	}

	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<FlightSchedule> getFlightSchedules() {
		return flightSchedules;
	}

	public void setFlightSchedules(List<FlightSchedule> flightSchedules) {
		this.flightSchedules = flightSchedules;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", name=" + name + ", seatingCapacity=" + seatingCapacity + ", reservationCapacity="
				+ reservationCapacity + ", passengers=" + passengers + ", reservations=" + reservations
				+ ", flightSchedules=" + flightSchedules + "]";
	}

	
	
	
}
