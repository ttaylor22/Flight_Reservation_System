package com.group.FRS.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import com.fasterxml.jackson.annotation.JsonProperty;







@Entity
@Table(name = "flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String flightName;
	
	@Column(name="seating_capacity")
	private int seatingCapacity;
	
	@Column(name="reservation_capacity")
	private int reservationCapacity;
	
	@JsonIgnore
	//@JsonBackReference
	@OneToMany(mappedBy="flight", orphanRemoval = true, cascade = CascadeType.PERSIST)
	private Set<Passenger> passengers;

	@JsonIgnore
	//@JsonBackReference
	@OneToMany(mappedBy = "flight", orphanRemoval = true, cascade = CascadeType.PERSIST)
	private Set<FlightSchedule> flightSchedules;

	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Flight(String flightName, int seatingCapacity, int reservationCapacity) {
		this.flightName = flightName;
		this.seatingCapacity = seatingCapacity;
		this.reservationCapacity = reservationCapacity;
	}

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
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

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Set<FlightSchedule> getFlightSchedules() {
		return flightSchedules;
	}

	public void setFlightSchedules(Set<FlightSchedule> flightSchedules) {
		this.flightSchedules = flightSchedules ;
	}


	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightName=" + flightName + ", seatingCapacity=" + seatingCapacity
				+ ", reservationCapacity=" + reservationCapacity + ", passengers=" + passengers + ", flightSchedules="
				+ flightSchedules + "]";
	}

	

	

}