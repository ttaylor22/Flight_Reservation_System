package com.group.FRS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="payment_info")
	private String paymentInfo;
	
	@Column(name="price")
	private int price;

	@JsonIgnore
	@OneToOne(mappedBy = "ticket")
	private PassengerSchedule passengerSchedule;
	
	@Column(name="trip")
	private String trip;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(Long id, String paymentInfo, int price, String trip, PassengerSchedule passengerSchedule) {
		super();
		this.id = id;
		this.paymentInfo = paymentInfo;
		this.price = price;
		this.passengerSchedule = passengerSchedule;
		this.trip = trip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public PassengerSchedule getPassengerSchedule() {
		return passengerSchedule;
	}

	public void setPassengerSchedule(PassengerSchedule passengerSchedule) {
		this.passengerSchedule = passengerSchedule;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", paymentInfo=" + paymentInfo + ", price=" + price + ", passengerSchedule="
				+ passengerSchedule + "]";
	}

	
	

	
}