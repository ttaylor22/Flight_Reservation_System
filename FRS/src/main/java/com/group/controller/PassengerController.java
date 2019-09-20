package com.group.controller;

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

import com.group.model.Flight;
import com.group.model.Passenger;
import com.group.repository.FlightRepository;
import com.group.repository.PassengerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/passenger")
public class PassengerController {


	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@GetMapping("/passengers")
	public List<Passenger> getAllPassengers(){
		return passengerRepository.findAll();
	}
    

	@PostMapping(path="/addPassenger", produces="application/json")
    public void create(@RequestBody Passenger passenger){
		//System.out.println(passenger.getFlight());
         passengerRepository.save(passenger);
    }
	
	@PutMapping("/update/{id}")
	   public ResponseEntity<Passenger> updateDoctor(@PathVariable(value = "id") Long passengerId,
	                                              @Valid @RequestBody Passenger passengerDetails) {
	       Passenger passenger = passengerRepository.findById( passengerId).orElse(null);
	       passenger.setAge(passengerDetails.getAge());
	       passenger.setName(passengerDetails.getName());
	       passenger.setGender(passengerDetails.getGender());
	       passenger.setSeatNo(passengerDetails.getSeatNo());
	       passenger.setBookingDate(passengerDetails.getBookingDate());
	       final Passenger updatedPassenger = passengerRepository.save(passenger);
	       return ResponseEntity.ok(updatedPassenger);
	   }
	
	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
         passengerRepository.deleteById(id);
    }
	
}
