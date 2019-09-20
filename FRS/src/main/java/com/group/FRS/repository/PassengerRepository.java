package com.group.FRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.Passenger;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
//
}

