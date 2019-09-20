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
import com.group.repository.FlightRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FlightController {
	
	@Autowired
	 FlightRepository flightService;


	//@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
    @GetMapping("/flights")
    public List<Flight> getAllFlights(){
        return flightService.findAll();
    }
    
    
    

	@PostMapping("/addFlight")
    public void create( @RequestBody Flight flight){
         flightService.save(flight);
    }
	
	@PutMapping("/flight/{id}")
	   public ResponseEntity<Flight> updateDoctor(@PathVariable(value = "id") int flightId,
	                                              @Valid @RequestBody Flight flightDetails) {
	       Flight flight = flightService.findById( flightId).orElse(null);
	       flight.setflightName(flightDetails.getflightName());
	       flight.setseatingCapacity(flightDetails.getseatingCapacity());
	       flight.setreservationCapacity(flightDetails.getreservationCapacity());
	       final Flight updatedFlight = flightService.save(flight);
	       return ResponseEntity.ok(updatedFlight);
	   }
	
	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
         flightService.deleteById(id);
    }
    

   

}