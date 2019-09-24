package com.group.FRS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.Flight;


@Repository
public interface FlightRepository  extends JpaRepository<Flight, Long> {
	@Query(value="select flight.id, flight.name, flight.seating_capacity, flight.reservation_capacity, flight_schedule.schedule_day, \r\n" + 
			"route.source, route.destination, route.distance, route.duration from flight\r\n" + 
			"left join flight_schedule on flight_schedule.flight_id = flight.id \r\n" + 
			"left join route on route.flight_schedule_id = flight_schedule.id;", nativeQuery=true)
	List<Object> getAllFlightInformation();
}