package com.group.FRS.controller;

import java.util.ArrayList;
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

import com.group.FRS.model.Flight;
import com.group.FRS.model.FlightSchedule;
import com.group.FRS.model.Passenger;
import com.group.FRS.model.PassengerSchedule;
import com.group.FRS.model.Route;
import com.group.FRS.repository.FlightRepository;
import com.group.FRS.repository.FlightScheduleRepository;
import com.group.FRS.repository.PassengerRepository;
import com.group.FRS.repository.RouteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FlightController {
	
	@Autowired
	 FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
    FlightScheduleRepository flightScheduleRepository;
	
	@Autowired
	RouteRepository routeRepository;

    @GetMapping(path="/flights")
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    @GetMapping(path="/flight/{id}")
    public Flight getSingleFlight(@PathVariable(value = "id") Long flightId) {
    	return flightRepository.findById(flightId).orElse(null);
    }
    
    @GetMapping(path="/displayFlights", produces="application/json")
    public List<Object> getAllFlightInfo() {
    	List<Object> routes = flightRepository.getAllFlightInformation();
    	return routes;
    }
    
//	@PostMapping(path="/flight")
//    public ResponseEntity<Flight> create( @RequestBody Flight flight){
//         return ResponseEntity.ok(flightRepository.save(flight));
//    }
    
    @PostMapping("/flight")
    public ResponseEntity<Flight> create( @RequestBody Flight flight){
         return ResponseEntity.ok(flightRepository.save(createOneToMany(flight)));
    }
	
	public static Flight createOneToMany(Flight flight) {
		Flight fC = new Flight(); 
		fC.setflightName(flight.getflightName());
	    fC.setseatingCapacity(flight.getseatingCapacity());
	    fC.setreservationCapacity(flight.getreservationCapacity());
		for(Passenger p: flight.getPassengers()) {
			fC.addPassenger(PassengerController.createOneToMany(p));
		}
		for(FlightSchedule fs: flight.getFlightSchedules()) {
			fC.addFlightSchedule(FlightScheduleController.createOneToMany(fs));
		}
		return fC;
	}
	
	@PutMapping("/flight/{id}")
	   public ResponseEntity<Flight> updateFlight(@PathVariable(value = "id") Long flightId,
	                                              @Valid @RequestBody Flight flightDetails) {
	       Flight flight = flightRepository.findById( flightId).orElse(null);
	       flight.setflightName(flightDetails.getflightName());
	       flight.setseatingCapacity(flightDetails.getseatingCapacity());
	       flight.setreservationCapacity(flightDetails.getreservationCapacity());
	       return ResponseEntity.ok(flightRepository.save(flight));
	   }
	
	
	
	@PutMapping("/flight/{id1}/passenger/{id2}")
	   public ResponseEntity<Flight> connectP(@PathVariable(value = "id1") Long id1, @PathVariable(value = "id2") Long id2) {
	       Flight flight = flightRepository.findById(id1).orElse(null);
	       Passenger passenger = passengerRepository.findById(id2).orElse(null);
	       flight.getPassengers().add(passenger);
	       return ResponseEntity.ok(flightRepository.save(flight));
	   }
	
	@PutMapping("/flight/{id1}/flight/schedule/{id2}")
	   public ResponseEntity<Flight> connectFS(@PathVariable(value = "id1") Long id1, @PathVariable(value = "id2") Long id2) {
	       Flight flight = flightRepository.findById(id1).orElse(null);
	       FlightSchedule flightSchedule = flightScheduleRepository.findById(id2).orElse(null);
		   flight.getFlightSchedules().add(flightSchedule);
	       return ResponseEntity.ok(flightRepository.save(flight));
	   }
	
	@PutMapping("/flight/{id1}/flight/schedule/{id2}/route/{id3}")
	   public ResponseEntity<Flight> connectFS(@PathVariable(value = "id1") Long id1, @PathVariable(value = "id2") Long id2, @PathVariable(value = "id3") Long id3) {
	       Flight flight = flightRepository.findById(id1).orElse(null);
	       FlightSchedule flightSchedule = flightScheduleRepository.findById(id2).orElse(null);
	       Route route = routeRepository.findById(id3).orElse(null);
		   flightSchedule.getRoutes().add(route);
	       flight.getFlightSchedules().add(flightSchedule);
	       return ResponseEntity.ok(flightRepository.save(flight));
	   }
	
	
	/*
	//@SuppressWarnings("unchecked")
	@PutMapping("/update/{id}/schedule/{id2}")
	   public ResponseEntity<Flight> updateFlight(@PathVariable(value = "id") Long flightId,
			   									  @PathVariable(value = "id2") Long flightScheduleId,
	                                              @Valid @RequestBody Flight flightDetails) {
		   Flight flight = flightRepository.findById( flightId).orElse(null);
	       flight.setflightName(flightDetails.getflightName());
	       flight.setseatingCapacity(flightDetails.getseatingCapacity());
	       flight.setreservationCapacity(flightDetails.getreservationCapacity());   
	       ArrayList<FlightSchedule> list = new ArrayList<FlightSchedule>();
	       FlightSchedule flightSchedule = flightScheduleRepository.findById(flightScheduleId).orElse(null);
	       if(flightSchedule == null) {
	    	   return null;
	       }
	       list.add(flightSchedule);    
	       flight.getFlightSchedules().addAll(list);
	       return ResponseEntity.ok(flightRepository.save(flight));
	   }
	*/
	
	
//	@DeleteMapping("/flight/{id}")
//    public void delete(@PathVariable("id") Long id) {
//         flightRepository.deleteById(id);
//    }
	@DeleteMapping("/flight/{id1}/passenger/{id2}")
	public ResponseEntity<Flight> deleteP(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2) {
		Flight flight = flightRepository.findById(id1).orElse(null);
		Passenger passenger = passengerRepository.findById(id2).orElse(null);
		flight.getPassengers().remove(passenger);
		return ResponseEntity.ok(flightRepository.save(flight));
	}
	@DeleteMapping("/flight/{id1}/flight/schedule/{id2}")
    ResponseEntity<Flight> deleteFS(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2) {
		Flight flight = flightRepository.findById(id1).orElse(null);
		FlightSchedule flightSchedule = flightScheduleRepository.findById(id2).orElse(null);
	    flight.getFlightSchedules().remove(flightSchedule);
		return ResponseEntity.ok(flightRepository.save(flight));
    }
	
	@DeleteMapping("/flight/{id1}/flight/schedule/{id2}/route/{id3}")
    ResponseEntity<Flight> deleteFS(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2,@PathVariable("id3") Long id3) {
		Flight flight = flightRepository.findById(id1).orElse(null);
		FlightSchedule flightSchedule = flightScheduleRepository.findById(id2).orElse(null);
		Route route = routeRepository.findById(id3).orElse(null);
	    if(flight.getFlightSchedules().contains(flightSchedule)) {
	    	flightSchedule.getRoutes().remove(route);
	    }
		return ResponseEntity.ok(flightRepository.save(flight));
    }
	
	@DeleteMapping("/flights")
    public void delete() {
		flightRepository.deleteAll();
   
    }
	
	
	@DeleteMapping("/flight/{id}")
    public void delete(@PathVariable("id") Long id) {
         flightRepository.deleteById(id);
    }
    

   

}