package com.group.FRS;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group.FRS.controller.FlightController;
import com.group.FRS.model.Flight;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {
	
	 @Autowired
	    private MockMvc mvc;
	 
	    @MockBean
	    private Flight flight;
	    
	    //test cases
	    
	    @Before
	    public void getFlights()
	    {
	    	
	    	Flight flight = new Flight("Dino Flight", 12, 3);
	    	//List<Flight> allFlight = Arrays.asList(flight);
	    	List<Flight> flights;
	    	
	    	
	    	
	    	/*
	    	 *@GetMapping(path="/getAll")
    	public List<Flight> getAllFlights(){
        	return flightRepository.findAll();
    }
	    	 * 
	    	 */
	    }

}
