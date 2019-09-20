package com.group.FRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.Route;


@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
	//
	}
