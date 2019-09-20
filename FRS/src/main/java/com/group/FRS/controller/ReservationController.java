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
@RequestMapping("/api")
public class ReservationController {
	@Autowired
	ReservationRepository reservationService;
	
	//@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
    @GetMapping("/reservations")
    public List<Reservation> getAllFlights(){
        return reservationService.findAll();
    }
    
    //add
    @PostMapping("/addReservation")
    public void create( @RequestBody Reservation reservation){
    	reservationService.save(reservation);
    }
    
    @PutMapping("/reservation/{id}")
	   public ResponseEntity<Reservation> updateDoctor(@PathVariable(value = "id") int reservationId,
	                                              @Valid @RequestBody Reservation reservationDetails) {
    	Reservation reservation = reservationService.findById( reservationId).orElse(null);
    	reservation.setFlights(reservationDetails.getFlights());
    	reservation.setJourneyDate(reservationDetails.getJourneyDate());
    	reservation.setNoOfSeats(reservationDetails.getNoOfSeats());
    	reservation.setUserProfile(reservationDetails.getUserProfile());
    	Reservation updatedReservation = reservationService.save(reservation);
	       return ResponseEntity.ok(updatedReservation);
	   }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
    	reservationService.deleteById(id);
    }
    

}
