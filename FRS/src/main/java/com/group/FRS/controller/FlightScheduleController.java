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
import com.group.FRS.repository.Flight_ScheduleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FlightScheduleController {
	
	@Autowired
	Flight_ScheduleRepository flightScheduleService;
	
	//@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
    @GetMapping(path="/FlightSchedule",produces="application/json" )
    public List<FlightSchedule> getAllFlightSchedules(){
        return (List<FlightSchedule>) flightScheduleService.findAll();
    }
    
    //put add flight
    @PostMapping(path="/addFlightSchedule", produces="application/json")
    public void create( @RequestBody FlightSchedule flight){
    	flightScheduleService.save(flight);
    }
    

    @PutMapping(path="/flightschedule/{id}")
    public ResponseEntity<FlightSchedule> updateFSchedule(@PathVariable(value ="id") int scheduleId,
    		@Valid @RequestBody FlightSchedule flightscheduleDetails){
    	FlightSchedule schedule = flightScheduleService.findById(scheduleId).orElse(null);
    	schedule.setFlight(flightscheduleDetails.getFlight());
    	schedule.setRoutes(flightscheduleDetails.getRoutes());
    	schedule.setScheduleDay(flightscheduleDetails.getScheduleDay());
    	
    	final FlightSchedule updatedFlightSchedule = flightScheduleService.save(schedule);
    	
    	return ResponseEntity.ok(updatedFlightSchedule);
    }
    
    

	@DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable("id") int id) {
         flightScheduleService.deleteById(id);
    }
	
	
	

}
