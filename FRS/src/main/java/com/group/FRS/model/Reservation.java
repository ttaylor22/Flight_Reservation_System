package com.group.FRS.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="journey_date")
	private Date journeyDate;
	@Column(name="no_of_seats")
	private int noOfSeats;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_profile_id", nullable=false)
	@JsonIgnore
	private UserProfile userProfile;

	@ManyToMany
	@JsonIgnore
	private List<Flight> flights;

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

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", journeyDate=" + journeyDate + ", noOfSeats=" + noOfSeats + ", userProfile="
				+ userProfile + ", flights=" + flights + "]";
	}

	
}
