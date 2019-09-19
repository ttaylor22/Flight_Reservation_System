package com.group.FRS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping("/api")
public class FlightController {
	
	@Autowired
	 FlightRepository flightService;
	
	@PostMapping
    public Flight create(@RequestBody Flight flight){
        return flightService.create(flight);
    }
/*
    @GetMapping(path = {"/{id}"})
    public Flight findOne(@PathVariable("id") int id){
        return flightService.findById(id);
    }
*/
    @PutMapping(path = {"/{id}"})
    public Flight update(@PathVariable("id") int id, @RequestBody Flight flight){
        flight.setflightId(id);
        return flightService.update(flight);
    }
/*
    @DeleteMapping(path ={"/{id}"})
    public Flight delete(@PathVariable("id") int id) {
        return flightService.delete(id);
    }
*/
    //@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
    @GetMapping(path="/", produces="application/json")
    public List<Flight> getAllFlights(){
        return flightService.findAll();
    }

}
