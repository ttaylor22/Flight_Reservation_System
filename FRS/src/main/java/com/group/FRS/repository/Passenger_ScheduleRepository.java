package com.group.FRS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.PassengerSchedule;


@Repository
public interface Passenger_ScheduleRepository extends CrudRepository<PassengerSchedule, Long> {
//
}
