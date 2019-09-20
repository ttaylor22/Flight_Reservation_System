package com.group.FRS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	 FlightRepository flightService;


	//@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
    @GetMapping("/flights")
    public List<Flight> getAllFlights(){
        return (List<Flight>) flightService.findAll();
    }

	@PostMapping("/addFlight")
    public void create( @RequestBody Flight flight){
         flightService.save(flight);
    }
    
    @GetMapping(path = {"/{id}"})
    public Optional<Flight> findOne(@PathVariable("id") long id){
        return flightService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Flight update(@PathVariable("id") int id, @RequestBody Flight flight){
        flight.setflightId(id);
        return flightService.updateFlight(id, flight);
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") long id) {
        flightService.deleteById(id);
    }

   

}