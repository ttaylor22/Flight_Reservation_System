package com.group.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int flightId;

	@Column(name="name")
	private String flightName;
	
	@Column(name="seating_capacity")
	private int seatingCapacity;
	
	@Column(name="reservation_capacity")
	private int reservationCapacity;
	
	//@OneToMany( mappedBy = "flight", targetEntity=Passenger.class, cascade= {CascadeType.PERSIST})

	//@Fetch(FetchMode.JOIN)
	@JsonBackReference
	@OneToMany(mappedBy="flight")
	private List<Passenger> passengers;
/*
	@ManyToMany
	@JsonIgnore
	public List<Reservation> reservations;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
	@JsonIgnore
	private List<FlightSchedule> flightSchedules;
*/
	public Flight() {}
	
	public Flight(String flightName, int seatingCapacity, int reservationCapacity) {
		this.flightName = flightName;
		this.seatingCapacity = seatingCapacity;
		this.reservationCapacity = reservationCapacity;
	}

	
	public int getflightId() {
		return flightId;
	}

	
	public void setflightId(int flightId) {
		this.flightId = flightId;
	}

	
	public String getflightName() {
		return flightName;
	}

	public void setflightName(String flightName) {
		this.flightName = flightName;
	}

	
	public int getseatingCapacity() {
		return seatingCapacity;
	}

	public void setseatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	
	public int getreservationCapacity() {
		return reservationCapacity;
	}

	public void setreservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}

	public List<Passenger> getPassengers() {
		return (List<Passenger>) passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = (List<Passenger>) passengers;
	}
/*
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
		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", seatingCapacity="
				+ seatingCapacity + ", reservationCapacity=" + reservationCapacity + ", passenger=" + passengers
				+ ", reservations=" + reservations + ", flight_schedules=" + flight_schedules + "]";
	}
*/
	

}

