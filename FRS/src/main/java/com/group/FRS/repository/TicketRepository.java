package com.group.FRS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.Ticket;


@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
	}
