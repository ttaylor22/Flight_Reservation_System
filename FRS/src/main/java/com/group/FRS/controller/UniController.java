package com.group.FRS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group.FRS.model.Flight;
import com.group.FRS.service.IFlightService;


@RestController
public class UniController {

	@Autowired
    private IFlightService flightService;

	 @RequestMapping(value="/flights", method=RequestMethod.GET, 
	            produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Flight>findFlights() {
    	return flightService.findAll();
    }
    
}
