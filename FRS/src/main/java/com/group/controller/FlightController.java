package com.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.model.Flight;
import com.group.repository.FlightRepository;

@RestController
@RequestMapping("/api")
public class FlightController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@GetMapping("/flight")
	public List<Flight> getAllFlights(){
		return flightRepository.findAll();
	}

}
