package com.group.FRS.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "passenger_schedule")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class PassengerSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="journey_date")
	private Date journeyDate;
	@Column(name="source")
	private String source;
	@Column(name="destination")
	private String destination;
	@Column(name="reservation_type")
	private String reservationType;
	
	//@JsonIgnore
	@OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
	private Ticket ticket;
	
	@JsonIgnore
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="passenger_id", nullable=false)
	private Passenger passenger;
	
	

	public PassengerSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public PassengerSchedule(Date journeyDate, String source, String destination, String reservationType,
			Ticket ticket, Passenger passenger) {
		super();
		this.journeyDate = journeyDate;
		this.source = source;
		this.destination = destination;
		this.reservationType = reservationType;
		this.ticket = ticket;
		this.passenger = passenger;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
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

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}



	@Override
	public String toString() {
		return "PassengerSchedule [id=" + id + ", journeyDate=" + journeyDate + ", source=" + source + ", destination="
				+ destination + ", reservationType=" + reservationType + ", ticket=" + ticket + ", passenger="
				+ passenger + "]";
	}
	
}