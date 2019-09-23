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
import com.group.FRS.model.UserProfile;
import com.group.FRS.repository.ReservationRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired(required=true)
	 ReservationRepository reservationRepository;

   @GetMapping(path="/getAll")
   public List<Reservation> getAllReservations(){
       return reservationRepository.findAll();
   }

   @GetMapping(path="/get/{id}")
   public Reservation getSingleReservation(@PathVariable(value = "id") Long resId) {
	   Reservation reservation = reservationRepository.findById(resId).orElse(null);
   	return reservation;
   }
   
	@PostMapping(path="/add")
   public ResponseEntity<Reservation> create( @RequestBody Reservation res){
        return ResponseEntity.ok(reservationRepository.save(res));
   }
	
	@PutMapping("/update/{id}")
	   public ResponseEntity<Reservation> updateUserProfile(@PathVariable(value = "id") Long resId,
	                                              @Valid @RequestBody Reservation resDetails) {
		   Reservation reservation = reservationRepository.findById(resId).orElse(null);
	       reservation.setJourneyDate(resDetails.getJourneyDate());
	       reservation.setNoOfSeats(resDetails.getNoOfSeats());
	       return ResponseEntity.ok(reservationRepository.save(reservation));
	   }
	
	@DeleteMapping("/delete/{id}")
   public void delete(@PathVariable("id") Long id) {
        reservationRepository.deleteById(id);
   }
}
