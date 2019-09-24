package com.group.FRS.controller;

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


import com.group.FRS.model.FlightSchedule;

import com.group.FRS.model.Route;
import com.group.FRS.model.UserCredential;
import com.group.FRS.model.UserProfile;
import com.group.FRS.repository.FlightScheduleRepository;
import com.group.FRS.repository.RouteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RouteController {
	//produces="application/json"
	
	@Autowired
	RouteRepository routeRepository;
	
	@Autowired
	FlightScheduleRepository flightscheduleRepository;
	
    @GetMapping(path="/routes")
    public List<Route> getAllRepositories(){
        return routeRepository.findAll();
    }
    
    @GetMapping(path="/route/{id}")
	public Route getSinglePassenger(@PathVariable(value="id") Long routeId) {
		return routeRepository.findById(routeId).orElse(null);
	}
    
    @GetMapping(path="/displayFlights/{source}/{destination}/{scheduleDay}", produces="application/json")
    public List<Object> displayFlights(@PathVariable(value="source") String source, @PathVariable(value="destination") String destination, 
    									@PathVariable(value="scheduleDay") @DateTimeFormat(pattern="yyyy-MM-dd") Date scheduleDate) {
    	List<Object> routes = routeRepository.findRoutes(source, destination, scheduleDate);
    	return routes;
    }
    
    @PostMapping(path="/route")
    public ResponseEntity<Route> create( @RequestBody Route route){
    	return ResponseEntity.ok(routeRepository.save(route));
    }
    
    @PutMapping(path="/route/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable(value ="id") Long scheduleId,
    		@Valid @RequestBody Route routeDetails){
    	Route route = routeRepository.findById(scheduleId).orElse(null);
    	route.setSource(routeDetails.getSource());
    	route.setDestination(routeDetails.getDestination());
    	route.setDuration(routeDetails.getDuration());
    	route.setDistance(routeDetails.getDistance());
    	return ResponseEntity.ok(routeRepository.save(route));
    }
    
    @PutMapping("/route/{id}/flight/schedule/{id2}")
	public ResponseEntity<Route> connect(@PathVariable(value = "id") Long routeId,
			@PathVariable(value = "id2") Long flightSId,
			@Valid @RequestBody UserProfile userDetails) {
		Route route = routeRepository.findById(routeId).orElse(null);
		FlightSchedule flightS = flightscheduleRepository.findById(flightSId).orElse(null);
		route.setFlightSchedule(flightS);
		return ResponseEntity.ok(routeRepository.save(route));
	}
    
	@DeleteMapping(path="/route/{id}")
    public void delete(@PathVariable("id") Long id) {
         routeRepository.deleteById(id);
    }
}