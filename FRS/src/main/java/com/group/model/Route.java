package com.group.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Route {
	
	private int		routeId;
	private String 	source;
	private String 	destination;
	private float 	distance;
	private int 	duration;

	public int getRouteId() {
		return routeId;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public float getDistance() {
		return distance;
	}
	
	public int getDuration() {
		return duration;
	}
	
	@Autowired
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
	@Autowired
	public void setSource(String source) {
		this.source = source;
	}
	
	@Autowired
	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Autowired
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	@Autowired
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
