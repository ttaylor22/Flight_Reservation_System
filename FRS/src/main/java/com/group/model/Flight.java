package com.group.model;

import javax.persistence.*;



@Entity
@Table(name = "flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="flight_Id")
	private int flightId;

	@Column(name="flight_name")
	private String flightName;
	
	@Column(name="seating_capacity")
	private int seatingCapacity;
	
	@Column(name="reservation_capacity")
	private int reservationCapacity;

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
/*
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
		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", seatingCapacity="
				+ seatingCapacity + ", reservationCapacity=" + reservationCapacity + ", passenger=" + passengers
				+ ", reservations=" + reservations + ", flight_schedules=" + flight_schedules + "]";
	}
*/
	
}
