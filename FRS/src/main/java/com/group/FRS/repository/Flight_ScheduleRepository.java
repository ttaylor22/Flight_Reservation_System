package com.group.FRS.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.FlightSchedule;
import com.group.FRS.model.Route;

@Repository
public interface Flight_ScheduleRepository extends JpaRepository<FlightSchedule, Long> {

}