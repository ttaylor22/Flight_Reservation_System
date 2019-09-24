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
import com.group.FRS.model.Ticket;
import com.group.FRS.model.UserProfile;
import com.group.FRS.repository.PassengerRepository;
import com.group.FRS.repository.PassengerScheduleRepository;
import com.group.FRS.repository.TicketRepository;
import com.group.FRS.repository.UserProfileRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PassengerScheduleController {
	
	@Autowired
	PassengerScheduleRepository passengerScheduleRespository;
	
	@Autowired
	PassengerRepository passengerRespository;
	
	@Autowired
	TicketRepository ticketRespository;
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
    @GetMapping(path ="/passenger/schedules")
    public List<PassengerSchedule> getAllFlightSchedules(){
        return passengerScheduleRespository.findAll();
    }
    
    @GetMapping(path="/passenger/schedule/{id}")
    public PassengerSchedule getSinglePassengerSchedule(@PathVariable(value = "id") Long passengerScheduleId) {
    	PassengerSchedule passengerSchedule = passengerScheduleRespository.findById(passengerScheduleId).orElse(null);
    	return passengerSchedule;
    }
    
    @PostMapping(path ="/passenger/schedule")
    public ResponseEntity<PassengerSchedule> create( @RequestBody PassengerSchedule passenger){
    	return ResponseEntity.ok(passengerScheduleRespository.save(passenger));
    }
    
    @PutMapping(path ="/passenger/schedule/{id}")
    public ResponseEntity<PassengerSchedule> updatePassengerSchedule(@PathVariable(value ="id") Long passengerId,
    		@Valid @RequestBody PassengerSchedule passengerscheduleDetails){
    	PassengerSchedule schedule = passengerScheduleRespository.findById(passengerId).orElse(null);
    	schedule.setDestination(passengerscheduleDetails.getDestination());
    	schedule.setJourneyStart(passengerscheduleDetails.getJourneyStart());
    	schedule.setJourneyEnd(passengerscheduleDetails.getJourneyEnd());
    	schedule.setTravelers(passengerscheduleDetails.getTravelers());
    	schedule.setPassenger(passengerscheduleDetails.getPassenger());
    	schedule.setReservationType(passengerscheduleDetails.getReservationType());
    	schedule.setSource(passengerscheduleDetails.getSource());
    	schedule.setTicket(passengerscheduleDetails.getTicket());	
    	return ResponseEntity.ok(passengerScheduleRespository.save(schedule));
    }
    
    @PutMapping("/passenger/schedule/{id1}/passenger/{id2}")
	public ResponseEntity<PassengerSchedule> connect1(@PathVariable(value = "id") Long passengerSId,
			@PathVariable(value = "id2") Long passengerId) {
		PassengerSchedule passS = passengerScheduleRespository.findById(passengerSId).orElse(null);
		Passenger pass = passengerRespository.findById(passengerId).orElse(null);
		passS.setPassenger(pass);
		return ResponseEntity.ok(passengerScheduleRespository.save(passS));
	}
    
    @PutMapping("/passenger/schedule/{id1}/ticket/{id2}")
   	public ResponseEntity<PassengerSchedule> connect2(@PathVariable(value = "id") Long passengerSId,
   			@PathVariable(value = "id2") Long ticketId) {
   		PassengerSchedule passS = passengerScheduleRespository.findById(passengerSId).orElse(null);
   		Ticket ticket = ticketRespository.findById(ticketId).orElse(null);
   		passS.setTicket(ticket);
   		return ResponseEntity.ok(passengerScheduleRespository.save(passS));
   	}
    
    @PutMapping("/passenger/schedule/{id1}/user/profile/{id2}")
   	public ResponseEntity<PassengerSchedule> connect3(@PathVariable(value = "id") Long passengerSId,
   			@PathVariable(value = "id2") Long profileId) {
   		PassengerSchedule passS = passengerScheduleRespository.findById(passengerSId).orElse(null);
   		UserProfile userP = userProfileRepository.findById(profileId).orElse(null);
   		passS.setUserProfile(userP);
   		return ResponseEntity.ok(passengerScheduleRespository.save(passS));
   	}
    
    @DeleteMapping(path ="/passenger/schedule/{id}")
    public void delete(@PathVariable("id") Long id) {
    	passengerScheduleRespository.deleteById(id);
    }

}