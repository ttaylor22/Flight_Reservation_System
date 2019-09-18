package com.group.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "route")
public class Route {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id")
	private int		routeId;
	
	@Column(name = "source")
	private String 	source;
	
	@Column(name = "destination")
	private String 	destination;
	
	@Column(name = "distance")
	private float 	distance;
	
	@Column(name = "duration")
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
	
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
