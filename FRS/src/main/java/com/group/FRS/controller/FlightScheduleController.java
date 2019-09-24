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

import com.group.FRS.model.FlightSchedule;
import com.group.FRS.repository.FlightScheduleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flight/schedule")
public class FlightScheduleController {
	
	@Autowired
	FlightScheduleRepository flightScheduleService;
	
    @GetMapping(path="/getAll")
    public List<FlightSchedule> getAllFlightSchedules(){
        return (List<FlightSchedule>) flightScheduleService.findAll();
    }
    
    @GetMapping(path="/get/{id}")
    public FlightSchedule getSingleFlightSchedule(@PathVariable(value = "id") Long flightId) {
 	   FlightSchedule flightSchedule = flightScheduleService.findById(flightId).orElse(null);
    	return flightSchedule;
    }
    
    @PostMapping(path="/add", produces="application/json")
    public ResponseEntity<FlightSchedule> create( @RequestBody FlightSchedule flight){
    	return ResponseEntity.ok(flightScheduleService.save(flight));
    }
    
    @PutMapping(path="/update/{id}")
    public ResponseEntity<FlightSchedule> updateFlightSchedule(@PathVariable(value ="id") Long scheduleId,
    		@Valid @RequestBody FlightSchedule flightscheduleDetails){
    	FlightSchedule schedule = flightScheduleService.findById(scheduleId).orElse(null);
    	schedule.setFlight(flightscheduleDetails.getFlight());
    	schedule.setRoutes(flightscheduleDetails.getRoutes());
    	schedule.setScheduleDay(flightscheduleDetails.getScheduleDay());
    	return ResponseEntity.ok(flightScheduleService.save(schedule));
    }
    
	@DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
         flightScheduleService.deleteById(id);
    }
	
	
	

}
