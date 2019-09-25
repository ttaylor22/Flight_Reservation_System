package com.group.FRS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.FRS.model.Reservation;
import com.group.FRS.model.Route;
import com.group.FRS.repository.ReservationRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/r")
public class ReservationController {
	
	@Autowired
	ReservationRepository reservationRepository;
	
    @GetMapping("/reservation/{id}")
	public Reservation getReservation(@PathVariable(value="id") Long reservationId) {
		return reservationRepository.findById(reservationId).orElse(null);
	}
    
    @PostMapping("/reservation")
    public ResponseEntity<Reservation> createReservation( @RequestBody Reservation reservation){
    	return ResponseEntity.ok(reservationRepository.save(reservation));
    }
    
}