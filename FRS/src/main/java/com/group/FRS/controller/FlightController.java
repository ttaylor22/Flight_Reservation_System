package com.group.FRS.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping("/api")
public class FlightController {
	
	@Autowired
	 FlightRepository flightRepository;


	//@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
    @GetMapping(path="/flights",  produces="application/json")
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }
    
    
    

	@PostMapping(path="/addFlight")
    public void create( @RequestBody Flight flight){
         flightRepository.save(flight);
    }
	
	@PutMapping("/flight/{id}")
	   public ResponseEntity<Flight> updateDoctor(@PathVariable(value = "id") int flightId,
	                                              @Valid @RequestBody Flight flightDetails) {
	       Flight flight = flightRepository.findById( flightId).orElse(null);
	       flight.setflightName(flightDetails.getflightName());
	       flight.setseatingCapacity(flightDetails.getseatingCapacity());
	       flight.setreservationCapacity(flightDetails.getreservationCapacity());
	       final Flight updatedFlight = flightRepository.save(flight);
	       return ResponseEntity.ok(updatedFlight);
	   }
	
	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
         flightRepository.deleteById(id);
    }
    

   

}