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

import com.group.FRS.model.Flight;
import com.group.FRS.repository.FlightRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired(required=true)
	 FlightRepository flightRepository;

    @GetMapping(path="/getAll")
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    @GetMapping(path="/get/{id}")
    public Flight getSingleFlight(@PathVariable(value = "id") int flightId) {
    	Flight flight = flightRepository.findById(flightId).orElse(null);
    	return flight;
    }
    
	@PostMapping(path="/add")
    public ResponseEntity<Flight> create( @RequestBody Flight flight){
         return ResponseEntity.ok(flightRepository.save(flight));
    }
	
	@PutMapping("/update/{id}")
	   public ResponseEntity<Flight> updateFlight(@PathVariable(value = "id") int flightId,
	                                              @Valid @RequestBody Flight flightDetails) {
	       Flight flight = flightRepository.findById( flightId).orElse(null);
	       flight.setflightName(flightDetails.getflightName());
	       flight.setseatingCapacity(flightDetails.getseatingCapacity());
	       flight.setreservationCapacity(flightDetails.getreservationCapacity());
	       return ResponseEntity.ok(flightRepository.save(flight));
	   }
	
	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
         flightRepository.deleteById(id);
    }
    

   

}