package com.group.FRS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService implements FlightRepositoryCustom{
	
	@Autowired
	FlightRepository repository;

	@Override
	public Flight create(Flight flight) {
		return repository.save(flight);
	}

	@Override
	public List<Flight> findAll() {
		return repository.findAll();
	}
	

	@Override
	public Flight update(Flight flight) {
		// TODO Auto-generated method stub
		return null;
	}


/*
	@Override
	public Flight delete(int id) {
		Flight flight = findById(id);
		if(flight != null)
			repository.delete(flight);
		
		return flight;
	}
	*/

	
}
