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

//	@Query(value="\r\n" + 
//			"select flight.name, flight.seating_capacity, flight.reservation_capacity, flight_schedule.schedule_day, route.source, route.destination, route.distance, route.duration, ticket.price\r\n" + 
//			" from flight inner join passenger on passenger.flight_id = passenger.id\r\n" + 
//			"inner join passenger_schedule on passenger_schedule.passenger_id = passenger.id \r\n" + 
//			"inner join ticket on ticket.id = passenger_schedule.ticket_id\r\n" + 
//			"inner join flight_schedule on flight_schedule.flight_id = flight.id\r\n" + 
//			"inner join route on route.flight_schedule_id = flight_schedule.flight_id \r\n" + 
//			"where route.source= :source and route.destination= :destination and flight_schedule.schedule_day = :scheduleDay \r\n" + 
//			"", nativeQuery=true)
	@Query(value="\r\n" +
			"select flight.name, flight.seating_capacity, flight.reservation_capacity, flight_schedule.schedule_day, route.source, route.destination, route.distance, route.duration\r\n" +
			" from flight inner join flight_schedule on flight_schedule.flight_id = flight.id\r\n" +
			"inner join route on route.flight_schedule_id = flight_schedule.flight_id\r\n" +
			"where route.source= :source and route.destination= :destination and flight_schedule.schedule_day = :scheduleDay \r\n" +
			"", nativeQuery=true)
	
	List<Object> findRoutes(@Param("source") String source, @Param("destination") String destinaton, @Param("scheduleDay") Date scheduleDate);
}

