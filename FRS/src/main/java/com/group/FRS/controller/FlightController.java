package com.group.FRS.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.group.FRS.model.FlightSchedule;
import com.group.FRS.repository.FlightRepository;
import com.group.FRS.repository.FlightScheduleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FlightController {
	
	@Autowired
	 FlightRepository flightRepository;
	
	@Autowired
    FlightScheduleRepository flightScheduleRepository;

    @GetMapping(path="/flights")
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    @GetMapping(path="/flight/{id}")
    public Flight getSingleFlight(@PathVariable(value = "id") Long flightId) {
    	return flightRepository.findById(flightId).orElse(null);
    }
    
    @GetMapping(path="/displayFlights", produces="application/json")
    public List<Object> getAllFlightInfo() {
    	List<Object> routes = flightRepository.getAllFlightInformation();
    	return routes;
    }
    
	@PostMapping(path="/flight")
    public ResponseEntity<Flight> create( @RequestBody Flight flight){
         return ResponseEntity.ok(flightRepository.save(flight));
    }
	
	@PutMapping("/flight/{id}")
	   public ResponseEntity<Flight> updateFlight(@PathVariable(value = "id") Long flightId,
	                                              @Valid @RequestBody Flight flightDetails) {
	       Flight flight = flightRepository.findById( flightId).orElse(null);
	       flight.setflightName(flightDetails.getflightName());
	       flight.setseatingCapacity(flightDetails.getseatingCapacity());
	       flight.setreservationCapacity(flightDetails.getreservationCapacity());
	       return ResponseEntity.ok(flightRepository.save(flight));
	   }
	
	
	/*
	//@SuppressWarnings("unchecked")
	@PutMapping("/update/{id}/schedule/{id2}")
	   public ResponseEntity<Flight> updateFlight(@PathVariable(value = "id") Long flightId,
			   									  @PathVariable(value = "id2") Long flightScheduleId,
	                                              @Valid @RequestBody Flight flightDetails) {
		   Flight flight = flightRepository.findById( flightId).orElse(null);
	       flight.setflightName(flightDetails.getflightName());
	       flight.setseatingCapacity(flightDetails.getseatingCapacity());
	       flight.setreservationCapacity(flightDetails.getreservationCapacity());   
	       ArrayList<FlightSchedule> list = new ArrayList<FlightSchedule>();
	       FlightSchedule flightSchedule = flightScheduleRepository.findById(flightScheduleId).orElse(null);
	       if(flightSchedule == null) {
	    	   return null;
	       }
	       list.add(flightSchedule);    
	       flight.getFlightSchedules().addAll(list);
	       return ResponseEntity.ok(flightRepository.save(flight));
	   }
	*/
	@DeleteMapping("/flight/{id}")
    public void delete(@PathVariable("id") Long id) {
         flightRepository.deleteById(id);
    }
    

   

}