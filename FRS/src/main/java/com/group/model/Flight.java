package com.group.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Flight {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int flight_id;
 private String flight_name;
 private int seating_capacity;
 private int reservation_capacity;

 public int getFlight_id() {
	return flight_id;
}
public void setFlight_id(int flight_id) {
	this.flight_id = flight_id;
}
public String getFlight_name() {
	return flight_name;
}
public void setFlight_name(String flight_name) {
	this.flight_name = flight_name;
}
public int getSeating_capacity() {
	return seating_capacity;
}
public void setSeating_capacity(int seating_capacity) {
	this.seating_capacity = seating_capacity;
}
public int getReservation_capacity() {
	return reservation_capacity;
}
public void setReservation_capacity(int reservation_capacity) {
	this.reservation_capacity = reservation_capacity;
}
@Override
public String toString() {
	return "Flight [flight_id=" + flight_id + ", flight_name=" + flight_name + ", seating_capacity=" + seating_capacity
			+ ", reservation_capacity=" + reservation_capacity + "]";
}


 
}
