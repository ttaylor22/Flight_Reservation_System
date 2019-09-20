package com.group.FRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.FRS.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
