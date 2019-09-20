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
@RequestMapping("/Reservation")
public class ReservationController {
	@Autowired
	ReservationRepository reservationService;
	
	//@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
    @GetMapping(path ="/reservations",produces="application/json")
    public List<Reservation> getAllFlights(){
        return reservationService.findAll();
    }
    
    //add
    @PostMapping(path ="/addReservation")
    public void create( @RequestBody Reservation reservation){
    	reservationService.save(reservation);
    }
    
    @PutMapping(path ="/reservationupdate/{id}")
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
    
    @DeleteMapping(path ="/delete/{id}")
    public void delete(@PathVariable("id") int id) {
    	reservationService.deleteById(id);
    }
    

}
