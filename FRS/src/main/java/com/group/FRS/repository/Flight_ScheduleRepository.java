package com.group.FRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.group.FRS.model.FlightSchedule;

@Repository
public interface Flight_ScheduleRepository extends JpaRepository<FlightSchedule, Integer> {
	//
}
