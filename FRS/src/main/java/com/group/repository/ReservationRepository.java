package com.group.repository;

import org.springframework.data.repository.CrudRepository;


import com.group.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

}

