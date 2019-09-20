package com.group.FRS.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "passenger_schedule")
public class PassengerSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="journey_date")
	private Date journeyDate;
	@Column(name="source")
	private String source;
	@Column(name="destination")
	private String destination;
	@Column(name="reservation_type")
	private String reservationType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
	@JsonIgnore
	private Ticket ticket;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="passenger_id", nullable=false)
	@JsonIgnore
	private Passenger passenger;

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
