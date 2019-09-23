package com.group.FRS.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.FRS.model.Reservation;
import com.group.FRS.repository.ReservationRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	ReservationRepository reservationService;
	
    @GetMapping(path ="/getAll",produces="application/json")
    public List<Reservation> getAllFlights(){
        return reservationService.findAll();
    }
    
    //add
    @PostMapping(path ="/add")
    public ResponseEntity<Reservation> create( @RequestBody Reservation reservation){
    	return ResponseEntity.ok(reservationService.save(reservation));
    }
    
    @PutMapping(path ="/update/{id}")
	   public ResponseEntity<Reservation> updateDoctor(@PathVariable(value = "id") Long reservationId,
	                                              @Valid @RequestBody Reservation reservationDetails) {
    	Reservation reservation = reservationService.findById( reservationId).orElse(null);
    	reservation.setFlights(reservationDetails.getFlights());
    	reservation.setJourneyDate(reservationDetails.getJourneyDate());
    	reservation.setNoOfSeats(reservationDetails.getNoOfSeats());
    	reservation.setUserProfile(reservationDetails.getUserProfile());
	       return ResponseEntity.ok(reservationService.save(reservation));
	   }
    
    @DeleteMapping(path ="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	reservationService.deleteById(id);
    }
    

}
