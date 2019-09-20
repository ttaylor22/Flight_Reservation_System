package com.group.FRS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.FRS.model.*;
import com.group.FRS.repository.*;

@Service
public class FlightService implements IFlightService{

	@Autowired
	private FlightRepository repository;

	@Override
	public List<Flight> findAll() {
		// TODO Auto-generated method stub
		return (List<Flight>) repository.findAll();
	}
	
	
}
