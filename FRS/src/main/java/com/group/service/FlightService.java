package com.group.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.model.Flight;
import com.group.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List getAllFlights() {
		List flights = new ArrayList<>();
		return (List) flightRepository.findAll();
	}
	/*
	public Flight getFlight(int id) {
		return flightRepository.findOne(id);
	}*/
	
	public void addFlight(Flight flight) {
		flightRepository.save(flight);
	}
	
	public void updateFlight(int id, Flight flight) {
		flightRepository.save(flight);
	}
	/*
	public void deleteFlight(int id) {
		flightRepository.delete(id);
	}*/
}
