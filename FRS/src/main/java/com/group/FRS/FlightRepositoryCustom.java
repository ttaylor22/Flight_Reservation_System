package com.group.FRS;

import java.util.List;

public interface FlightRepositoryCustom {
	Flight create(Flight flight);
	//Flight delete(int id);
	List<Flight> findAll();
	//Flight findById(int id);
	Flight update(Flight flight);
}
