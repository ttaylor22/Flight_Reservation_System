package com.group.FRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.PassengerSchedule;


@Repository
public interface PassengerScheduleRepository extends JpaRepository<PassengerSchedule, Long> {

}
