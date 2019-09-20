package com.group.FRS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.Route;


@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {
	//
	}
