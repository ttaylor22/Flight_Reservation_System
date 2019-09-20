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

import com.group.FRS.model.PassengerSchedule;
import com.group.FRS.repository.Passenger_ScheduleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PassengerScheduleController {
	
	@Autowired
	Passenger_ScheduleRepository passengerScheduleService;
	
	//@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
    @GetMapping(path ="/PassengerSchedule", produces="application/json")
    public List<PassengerSchedule> getAllFlightSchedules(){
        return (List<PassengerSchedule>) passengerScheduleService.findAll();
    }
    
    //add passenger schedule
    @PostMapping(path ="/addPassengerSchedule")
    public void create( @RequestBody PassengerSchedule passenger){
    	passengerScheduleService.save(passenger);
    }
    
    //update
    @PutMapping(path ="/flightschedule/{id}")
    public ResponseEntity<PassengerSchedule> updateFSchedule(@PathVariable(value ="id") int passengerId,
    		@Valid @RequestBody PassengerSchedule passengerscheduleDetails){
    	PassengerSchedule schedule = passengerScheduleService.findById(passengerId).orElse(null);
    	schedule.setDestination(passengerscheduleDetails.getDestination());
    	schedule.setJourneyDate(passengerscheduleDetails.getJourneyDate());
    	schedule.setPassenger(passengerscheduleDetails.getPassenger());
    	schedule.setReservationType(passengerscheduleDetails.getReservationType());
    	schedule.setSource(passengerscheduleDetails.getSource());
    	schedule.setTicket(passengerscheduleDetails.getTicket());
    	
    	final PassengerSchedule updatedPassengerSchedule = passengerScheduleService.save(schedule);
    	
    	return ResponseEntity.ok(updatedPassengerSchedule);
    }
    
    //delete
    @DeleteMapping(path ="/delete/{id}")
    public void delete(@PathVariable("id") int id) {
    	passengerScheduleService.deleteById(id);
    }

}
