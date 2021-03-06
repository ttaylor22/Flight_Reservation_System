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

import com.group.FRS.model.Flight;
import com.group.FRS.model.Passenger;
import com.group.FRS.model.PassengerSchedule;
import com.group.FRS.model.UserProfile;
import com.group.FRS.repository.FlightRepository;
import com.group.FRS.repository.PassengerRepository;
import com.group.FRS.model.PassengerSchedule;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PassengerController {

	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@GetMapping(path="/passengers")
	public List<Passenger> getAllPassengers(){
		return passengerRepository.findAll();
	}
	
	@GetMapping(path="/passenger/{id}")
	public Passenger getSinglePassenger(@PathVariable(value="id") Long passengerId) {
		return passengerRepository.findById(passengerId).orElse(null);
	}

//	@PostMapping(path="/passenger")
//    public ResponseEntity<Passenger> create(@RequestBody Passenger passenger){
//		return ResponseEntity.ok(passengerRepository.save(passenger));
//    }
	
	@PostMapping(path = "/passenger")
	public ResponseEntity<Passenger> create(@RequestBody Passenger passenger) {
		return ResponseEntity.ok(passengerRepository.save(createOneToMany(passenger)));
	}
	
	public static Passenger createOneToMany(Passenger passenger) {
		Passenger pC = new Passenger(); 
		pC.setAge(passenger.getAge());
		pC.setFirstName(passenger.getFirstName());
		pC.setLastName(passenger.getLastName());
		pC.setGender(passenger.getGender());
		pC.setSeatNo(passenger.getSeatNo());
		pC.setBookingDate(passenger.getBookingDate());
		for(PassengerSchedule ps: passenger.getPassengerSchedules()) {
			pC.addPassengerSchedule(ps);
		}
		return pC;
	}
	
	@PutMapping(path="/passenger/{id}")
	public ResponseEntity<Passenger> updatePassenger(@PathVariable(value = "id") Long passengerId,
	                                              @Valid @RequestBody Passenger passengerDetails) {
		Passenger passenger = passengerRepository.findById( passengerId).orElse(null);
	    passenger.setAge(passengerDetails.getAge());
	    passenger.setFirstName(passengerDetails.getFirstName());
	    passenger.setLastName(passengerDetails.getLastName());
	    passenger.setGender(passengerDetails.getGender());
	    passenger.setSeatNo(passengerDetails.getSeatNo());
	    passenger.setBookingDate(passengerDetails.getBookingDate());
	    return ResponseEntity.ok(passengerRepository.save(passenger));
	}
	
	@PutMapping("/passenger/{id1}/flight/{id2}")
	public ResponseEntity<Passenger> connect(@PathVariable(value = "id") Long passengerId,
			@PathVariable(value = "id2") Long flightId) {
		Passenger pass = passengerRepository.findById(passengerId).orElse(null);
		Flight flight = flightRepository.findById(flightId).orElse(null);
		pass.setFlight(flight);
		return ResponseEntity.ok(passengerRepository.save(pass));
	}
	
//	@DeleteMapping(path="/passenger/{id}")
//    public void delete(@PathVariable("id") Long id) {
//         passengerRepository.deleteById(id);
//    }
	
	@DeleteMapping("/passenger/{id}")
	public ResponseEntity<Passenger> delete(@PathVariable("id") Long id) {
		if (passengerRepository.findById(id).orElse(null) != null) {
			passengerRepository.deleteById(id);
			return ResponseEntity.ok().body(null);
		}
		return ResponseEntity.notFound().build();
	}
}