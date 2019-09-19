package com.group.FRS;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface FlightRepository  extends CrudRepository<Flight, Long>, FlightRepositoryCustom {


}

