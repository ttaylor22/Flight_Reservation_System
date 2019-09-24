package com.group.FRS.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="journey_start")
	private Date journeyStart;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="journey_end")
	private Date journeyEnd; 
	@Column(name="travelers")
	private int travelers;
	@Column(name="source")
	private String source;
	@Column(name="destination")
	private String destination;
	@Column(name="reservation_type")
	private String reservationType;
	
	//@JsonIgnore
	@OneToOne(orphanRemoval = true)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
	private Ticket ticket;
	
	@JsonIgnore
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="passenger_id")
	private Passenger passenger;
	
	@JsonIgnore
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="user_profile_id")
	private UserProfile userProfile;
	
	
	public PassengerSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PassengerSchedule(Long id, Date journeyStart, Date journeyEnd, int travelers, String source,
			String destination, String reservationType, Ticket ticket, Passenger passenger) {
		super();
		this.id = id;
		this.journeyStart = journeyStart;
		this.journeyEnd = journeyEnd;
		this.travelers = travelers;
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


	public Date getJourneyStart() {
		return journeyStart;
	}


	public void setJourneyStart(Date journeyStart) {
		this.journeyStart = journeyStart;
	}


	public Date getJourneyEnd() {
		return journeyEnd;
	}


	public void setJourneyEnd(Date journeyEnd) {
		this.journeyEnd = journeyEnd;
	}


	public int getTravelers() {
		return travelers;
	}


	public void setTravelers(int travelers) {
		this.travelers = travelers;
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


	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}


	@Override
	public String toString() {
		return "PassengerSchedule [id=" + id + ", journeyStart=" + journeyStart + ", journeyEnd=" + journeyEnd
				+ ", travelers=" + travelers + ", source=" + source + ", destination=" + destination
				+ ", reservationType=" + reservationType + ", ticket=" + ticket + ", passenger=" + passenger
				+ ", userProfile=" + userProfile + "]";
	}
	
	

	
}