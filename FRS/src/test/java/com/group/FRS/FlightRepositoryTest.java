package com.group.FRS;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.group.FRS.model.Flight;
import com.group.FRS.repository.FlightRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest




public class FlightRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManger;
	
	@Autowired
	private FlightRepository flightrepository;
	
	@SuppressWarnings("deprecation")
	
	@Before
	public void createFlight()
	{
		Flight flight = new Flight("Dino Flight", 12, 3);
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void addFlight() {
		Flight flight = new Flight("Dino Flight", 12, 3);
		
		
		entityManger.persist(flight);
		entityManger.flush();
		
		
		
		
		
		Flight found = flightrepository.findById(flight.getflightId()).orElse(null);
		
		
		Assert.isTrue(found.getflightName().equals(flight.getflightName()));
		
		
	}
	
	

}
