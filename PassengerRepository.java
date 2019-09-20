package com.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
