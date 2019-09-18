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

@Entity
@Table(name = "passenger_schedule")
public class Passenger_Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schedule_id;
	
	private Date journey_date;
	private String source;
	private String destination;
	private String reservation_type;
	private int Passenger_passenger_id;
	private int Passenger_Flight_flight_id;
	
	@OneToMany(mappedBy = "passenger_schedule")
	private Set<Ticket> tickets;

	@ManyToOne(cascade = CascadeType.ALL)
	private Passenger passenger;
	
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public Date getJourney_date() {
		return journey_date;
	}
	public void setJourney_date(Date journey_date) {
		this.journey_date = journey_date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getReservation_type() {
		return reservation_type;
	}
	public void setReservation_type(String reservation_type) {
		this.reservation_type = reservation_type;
	}
	public int getPassenger_passenger_id() {
		return Passenger_passenger_id;
	}
	public void setPassenger_passenger_id(int passenger_passenger_id) {
		Passenger_passenger_id = passenger_passenger_id;
	}
	public int getPassenger_Flight_flight_id() {
		return Passenger_Flight_flight_id;
	}
	public void setPassenger_Flight_flight_id(int passenger_Flight_flight_id) {
		Passenger_Flight_flight_id = passenger_Flight_flight_id;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	@Override
	public String toString() {
		return "Passenger_Schedule [schedule_id=" + schedule_id + ", journey_date=" + journey_date + ", source="
				+ source + ", destination=" + destination + ", reservation_type=" + reservation_type
				+ ", Passenger_passenger_id=" + Passenger_passenger_id + ", Passenger_Flight_flight_id="
				+ Passenger_Flight_flight_id + ", tickets=" + tickets + ", passenger=" + passenger + "]";
	}
	
}
