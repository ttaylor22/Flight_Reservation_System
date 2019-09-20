package com.group.FRS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.FlightSchedule;

@Repository
public interface Flight_ScheduleRepository extends CrudRepository<FlightSchedule, Long> {
	//
}
