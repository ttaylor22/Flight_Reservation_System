package com.group.FRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.group.FRS.model.Flight;


@Repository
public interface FlightRepository  extends JpaRepository<Flight, Long> {
	
}

