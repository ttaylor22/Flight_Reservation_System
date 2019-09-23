package com.group.FRS.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



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
	
	@JsonIgnore
	@JsonBackReference
	@OneToMany(mappedBy="flight", cascade = CascadeType.ALL)
	private List<Passenger> passengers;

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "reservation_has_flight",
    joinColumns = @JoinColumn(name = "reservation_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "flight_id", referencedColumnName = "id"))
	private List<Reservation> reservations;

	//@JsonIgnore
	@JsonBackReference//(value="flight-schedules")
	@OneToMany(mappedBy = "flight")
	private List<FlightSchedule> flightSchedules;

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
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<FlightSchedule> getFlightSchedules() {
		return flightSchedules;
	}

	public void setFlight_schedules(List<FlightSchedule> flightSchedules) {
		this.flightSchedules = flightSchedules;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", seatingCapacity=" + seatingCapacity
				+ ", reservationCapacity=" + reservationCapacity + ", passengers=" + passengers + ", reservations="
				+ reservations + ", flightSchedules=" + flightSchedules + "]";
	}
*/

	

}