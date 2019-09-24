package com.group.FRS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.group.FRS.model.Flight;
import com.group.FRS.model.FlightSchedule;
import com.group.FRS.model.Route;
import com.group.FRS.repository.Flight_ScheduleRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Flight_ScheduleRepositoryTest {
	@Autowired
	
	private TestEntityManager entityManager;
	
	@Autowired
	private Flight_ScheduleRepository flightschedulerepo;
	
//	@Before
//	public void createFlightSchedule() {
//		FlightSchedule flightschedule = new FlightSchedule();
//	}
	
	
	@Test
	public void addSchedule()
	{
		//flightschedule
		Date scheduleDay = new Date();
		Flight flight = new Flight("Dino Flight", 12, 3);
		List<Route> routes = new ArrayList();
		//FlightSchedule flightschedule = new FlightSchedule((long)14,scheduleDay, flight, routes);
		FlightSchedule flightschedule = new FlightSchedule(scheduleDay, flight, routes);
		
		/*
		 * public FlightSchedule(Date scheduleDay, Flight flight, List<Route> routes) {
		super();
		this.scheduleDay = scheduleDay;
		this.flight = flight;
		this.routes = routes;
	}
		 * 
		 */
		entityManager.persist(flightschedule);
		entityManager.flush();
		

		FlightSchedule found = flightschedulerepo.findById(flightschedule.getId()).orElse(null);
		
		Assert.isTrue(found.getId().equals(flightschedule.getId()));
	}

}
