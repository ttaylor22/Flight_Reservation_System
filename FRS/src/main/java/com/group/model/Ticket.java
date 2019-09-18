package com.group.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;


@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Column(name = "Schedule_schedule_id")
	private int		scheduleId;
	
	@Column(name = "payment_info")
	private String 	paymentInfo;
	
	public int getScheduleId() {
		return scheduleId;
	}
	
	public String getPaymentInfo() {
		return paymentInfo;
	}
	
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
