package com.group.FRS.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.Route;




@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

	@Query(value="select flight.name, flight.seating_capacity, flight.reservation_capacity, flight_schedule.schedule_day, route.source, route.destination\r\n" + 
			",  route.distance, route.duration from  flight inner join flight_schedule on flight_schedule.flight_id = flight.id inner join route on \r\n" + 
			"route.flight_schedule_id = flight_schedule.id where route.source = :source and route.destination = :destination and flight_schedule.schedule_day = :scheduleDay", nativeQuery=true)
	List<Object> findRoutes(@Param("source") String source, @Param("destination") String destinaton, @Param("scheduleDay") Date scheduleDate);

}