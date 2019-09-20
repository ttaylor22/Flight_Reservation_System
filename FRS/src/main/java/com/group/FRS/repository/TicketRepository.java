package com.group.FRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	}
