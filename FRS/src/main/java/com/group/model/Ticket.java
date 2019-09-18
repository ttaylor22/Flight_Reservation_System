package com.group.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Ticket {
	private int		scheduleId;
	private String 	paymentInfo;
	
	public int getScheduleId() {
		return scheduleId;
	}
	
	public String getPaymentInfo() {
		return paymentInfo;
	}
	
	@Autowired
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	@Autowired
	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
