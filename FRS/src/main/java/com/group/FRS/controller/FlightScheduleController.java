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
import com.group.FRS.model.Passenger;
import com.group.FRS.model.PassengerSchedule;
import com.group.FRS.model.Route;
import com.group.FRS.repository.FlightScheduleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FlightScheduleController {
	
	@Autowired
	FlightScheduleRepository flightScheduleRepository;
	
    @GetMapping(path="/flight/schedules")
    public List<FlightSchedule> getAllFlightSchedules(){
        return (List<FlightSchedule>) flightScheduleRepository.findAll();
    }
    
    @GetMapping(path="/flight/schedule/{id}")
    public FlightSchedule getSingleFlightSchedule(@PathVariable(value = "id") Long flightId) {
 	   FlightSchedule flightSchedule = flightScheduleRepository.findById(flightId).orElse(null);
    	return flightSchedule;
    }
    
//    @PostMapping(path="/flight/schedule", produces="application/json")
//    public ResponseEntity<FlightSchedule> create( @RequestBody FlightSchedule flight){
//    	return ResponseEntity.ok(flightScheduleRepository.save(flight));
//    }
    
    @PostMapping("/flight/schedule")
    public ResponseEntity<FlightSchedule> create( @RequestBody FlightSchedule flightSchedule){
    	return ResponseEntity.ok(flightScheduleRepository.save(createOneToMany(flightSchedule)));
    }
    
    public static FlightSchedule createOneToMany(FlightSchedule flightSchedule) {
    	FlightSchedule fsC = new FlightSchedule(); 
    	fsC.setScheduleDay(flightSchedule.getScheduleDay());
		for(Route r: flightSchedule.getRoutes()) {
			fsC.addRoute(r);
		}
		return fsC;
	}
    
    @PutMapping(path="/flight/schedule/{id}")
    public ResponseEntity<FlightSchedule> updateFlightSchedule(@PathVariable(value ="id") Long scheduleId,
    		@Valid @RequestBody FlightSchedule flightscheduleDetails){
    	FlightSchedule schedule = flightScheduleRepository.findById(scheduleId).orElse(null);
    	schedule.setFlight(flightscheduleDetails.getFlight());
    	schedule.setRoutes(flightscheduleDetails.getRoutes());
    	schedule.setScheduleDay(flightscheduleDetails.getScheduleDay());
    	return ResponseEntity.ok(flightScheduleRepository.save(schedule));
    }
     
    @DeleteMapping("/flight/schedules")
    public void delete() {
		flightScheduleRepository.deleteAll();
   
    }
    
	@DeleteMapping(path="/flight/schedule/{id}")
    public void delete(@PathVariable("id") Long id) {
		flightScheduleRepository.deleteById(id);
    }
	
	
	

}
