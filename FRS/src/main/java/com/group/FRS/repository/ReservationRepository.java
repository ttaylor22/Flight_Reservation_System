package com.group.FRS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.Reservation;


@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
//
}

