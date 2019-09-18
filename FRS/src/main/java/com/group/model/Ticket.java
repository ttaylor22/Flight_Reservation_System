package com.group.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Schedule_schedule_id;

	private String payment_info;

	@ManyToOne(cascade = CascadeType.ALL)
	private Passenger_Schedule passenger_schedule;

	public Long getSchedule_schedule_id() {
		return Schedule_schedule_id;
	}

	public void setSchedule_schedule_id(Long schedule_schedule_id) {
		Schedule_schedule_id = schedule_schedule_id;
	}

	public String getPayment_info() {
		return payment_info;
	}

	public void setPayment_info(String payment_info) {
		this.payment_info = payment_info;
	}

	public Passenger_Schedule getPassenger_schedule() {
		return passenger_schedule;
	}

	public void setPassenger_schedule(Passenger_Schedule passenger_schedule) {
		this.passenger_schedule = passenger_schedule;
	}

	@Override
	public String toString() {
		return "Ticket [Schedule_schedule_id=" + Schedule_schedule_id + ", payment_info=" + payment_info
				+ ", passenger_schedule=" + passenger_schedule + "]";
	}

}
