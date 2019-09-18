package com.group.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long flight_id;

	private String flight_name;
	private int seating_capacity;
	private int reservation_capacity;

	@OneToMany(mappedBy = "flight")
	private Set<Passenger> passengers;

	@ManyToMany
	public Set<Reservation> reservations;

	@OneToMany(mappedBy = "flight")
	private Set<Flight_Schedule> flight_schedules;

	public Long getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(Long flight_id) {
		this.flight_id = flight_id;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public int getSeating_capacity() {
		return seating_capacity;
	}

	public void setSeating_capacity(int seating_capacity) {
		this.seating_capacity = seating_capacity;
	}

	public int getReservation_capacity() {
		return reservation_capacity;
	}

	public void setReservation_capacity(int reservation_capacity) {
		this.reservation_capacity = reservation_capacity;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Set<Reservation> getReservation() {
		return reservations;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservations = reservation;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Set<Flight_Schedule> getFlight_schedules() {
		return flight_schedules;
	}

	public void setFlight_schedules(Set<Flight_Schedule> flight_schedules) {
		this.flight_schedules = flight_schedules;
	}

	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", flight_name=" + flight_name + ", seating_capacity="
				+ seating_capacity + ", reservation_capacity=" + reservation_capacity + ", passenger=" + passengers
				+ ", reservations=" + reservations + ", flight_schedules=" + flight_schedules + "]";
	}

	
}
