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
import com.group.FRS.repository.PassengerScheduleRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/passenger/schedule")
public class PassengerScheduleController {
	
	@Autowired
	PassengerScheduleRepository passengerScheduleService;
	
	
    @GetMapping(path ="/getAll")
    public List<PassengerSchedule> getAllFlightSchedules(){
        return passengerScheduleService.findAll();
    }
    
    @GetMapping(path="/get/{id}")
    public PassengerSchedule getSinglePassengerSchedule(@PathVariable(value = "id") Long passengerScheduleId) {
    	PassengerSchedule passengerSchedule = passengerScheduleService.findById(passengerScheduleId).orElse(null);
    	return passengerSchedule;
    }
    
    @PostMapping(path ="/add")
    public ResponseEntity<PassengerSchedule> create( @RequestBody PassengerSchedule passenger){
    	return ResponseEntity.ok(passengerScheduleService.save(passenger));
    }
    
    @PutMapping(path ="/update/{id}")
    public ResponseEntity<PassengerSchedule> updatePassengerSchedule(@PathVariable(value ="id") Long passengerId,
    		@Valid @RequestBody PassengerSchedule passengerscheduleDetails){
    	PassengerSchedule schedule = passengerScheduleService.findById(passengerId).orElse(null);
    	schedule.setDestination(passengerscheduleDetails.getDestination());
    	schedule.setJourneyStart(passengerscheduleDetails.getJourneyStart());
    	schedule.setJourneyEnd(passengerscheduleDetails.getJourneyEnd());
    	schedule.setTravelers(passengerscheduleDetails.getTravelers());
    	schedule.setPassenger(passengerscheduleDetails.getPassenger());
    	schedule.setReservationType(passengerscheduleDetails.getReservationType());
    	schedule.setSource(passengerscheduleDetails.getSource());
    	schedule.setTicket(passengerscheduleDetails.getTicket());	
    	return ResponseEntity.ok(passengerScheduleService.save(schedule));
    }
    
    @DeleteMapping(path ="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	passengerScheduleService.deleteById(id);
    }

}