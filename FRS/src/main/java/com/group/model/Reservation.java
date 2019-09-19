package com.group.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.group.FRS.Flight;

@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reservation_id;

	private Date journey_date;
	private int no_of_seats;
	private int user_id;

	@ManyToOne(cascade = CascadeType.ALL)
	private User_Profile user_profile;

	@ManyToMany
	private Set<Flight> flights;

	public Long getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(Long reservation_id) {
		this.reservation_id = reservation_id;
	}

	public Date getJourney_date() {
		return journey_date;
	}

	public void setJourney_date(Date journey_date) {
		this.journey_date = journey_date;
	}

	public int getNo_of_seats() {
		return no_of_seats;
	}

	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public User_Profile getUser_profile() {
		return user_profile;
	}

	public void setUser_profile(User_Profile user_profile) {
		this.user_profile = user_profile;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flight) {
		this.flights = flight;
	}

	@Override
	public String toString() {
		return "Reservation [reservation_id=" + reservation_id + ", journey_date=" + journey_date + ", no_of_seats="
				+ no_of_seats + ", user_id=" + user_id + ", user_profile=" + user_profile + ", flight=" + flights + "]";
	}

}
