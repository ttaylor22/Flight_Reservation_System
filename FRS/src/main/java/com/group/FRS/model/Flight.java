package com.group.FRS.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



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
	
	@OneToMany(mappedBy="flight", 
			orphanRemoval = true, 
			cascade = CascadeType.PERSIST)
	private List<Passenger> passengers = new ArrayList<>();


	@OneToMany(mappedBy = "flight", 
			orphanRemoval = true, 
			cascade = CascadeType.PERSIST)
	private List<FlightSchedule> flightSchedules = new ArrayList<>();

	
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

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	public void addPassenger(Passenger passenger) {
		passenger.setFlight(this);
		passengers.add(passenger);
	}

	public List<FlightSchedule> getFlightSchedules() {
		return flightSchedules;
	}

	public void setFlightSchedules(List<FlightSchedule> flightSchedules) {
		this.flightSchedules = flightSchedules ;
	}
	
	public void addFlightSchedule(FlightSchedule flightSchedule) {
		flightSchedule.setFlight(this);
		flightSchedules.add(flightSchedule);
	}


	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightName=" + flightName + ", seatingCapacity=" + seatingCapacity
				+ ", reservationCapacity=" + reservationCapacity + ", passengers=" + passengers + ", flightSchedules="
				+ flightSchedules + "]";
	}

	

	

}