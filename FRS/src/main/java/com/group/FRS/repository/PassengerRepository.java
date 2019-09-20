package com.group.FRS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.Passenger;


@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {
//
}

