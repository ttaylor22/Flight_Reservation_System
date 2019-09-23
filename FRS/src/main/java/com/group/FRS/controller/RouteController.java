package com.group.FRS.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
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

import com.group.FRS.model.FlightSchedule;
import com.group.FRS.model.Route;
import com.group.FRS.repository.Flight_ScheduleRepository;
import com.group.FRS.repository.RouteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/route")
public class RouteController {

	
	@Autowired
	RouteRepository routeRepository;
	
	
	Flight_ScheduleRepository flightRepository;
	
    @GetMapping(path="/getAll",produces="application/json" )
    public List<Route> getAllRepositories(){
        return routeRepository.findAll();
    }
    
    @GetMapping(path="/get/{id}", produces="application/json")
	public Route getSinglePassenger(@PathVariable(value="id") Long routeId) {
		Route route = routeRepository.findById(routeId).orElse(null);
		return route;
	}
    
    @GetMapping(path="/displayFlights/{source}/{destination}", produces="application/json")
    public List<Object> displayFlights(@PathVariable(value="source") String source, @PathVariable(value="destination") String destination) {
    	List<Object> routes = routeRepository.findRoutes(source, destination);
    	return routes;
    }
    
    //put add flight
    @PostMapping(path="/add", produces="application/json")
    public ResponseEntity<Route> create( @RequestBody Route route){
    	return ResponseEntity.ok(routeRepository.save(route));
    }
    
    
    

    @PutMapping(path="/update/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable(value ="id") Long scheduleId,
    		@Valid @RequestBody Route routeDetails){
    	Route route = routeRepository.findById(scheduleId).orElse(null);
    	route.setSource(routeDetails.getSource());
    	route.setDestination(routeDetails.getDestination());
    	route.setDuration(routeDetails.getDuration());
    	route.setDistance(routeDetails.getDistance());
    	return ResponseEntity.ok(routeRepository.save(route));
    }
    
    

	@DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
         routeRepository.deleteById(id);
    }
}
