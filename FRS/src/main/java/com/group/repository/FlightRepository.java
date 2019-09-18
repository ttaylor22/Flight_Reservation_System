package com.group.repository;

import org.springframework.data.repository.CrudRepository;

import com.group.model.Flight;

public interface FlightRepository  extends CrudRepository<Flight, Long> {

	

}

