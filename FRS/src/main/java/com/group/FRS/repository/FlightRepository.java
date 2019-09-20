package com.group.FRS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.Flight;


@Repository
public interface FlightRepository  extends CrudRepository<Flight, Long> {
//
	

}

