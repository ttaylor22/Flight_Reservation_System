package com.group.controller;

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

import com.group.model.Ticket;
import com.group.model.Ticket;
import com.group.repository.TicketRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@GetMapping("/tickets")
	public List<Ticket> getAllTickets(){
		return ticketRepository.findAll();
	}
    

	@PostMapping("/addTicket")
    public void create( @RequestBody Ticket ticket){
         ticketRepository.save(ticket);
    }
	
	@PutMapping("/update/{id}")
	   public ResponseEntity<Ticket> updateDoctor(@PathVariable(value = "id") Long tickedId,
	                                              @Valid @RequestBody Ticket ticketDetails) {
	       Ticket ticket = ticketRepository.findById( tickedId).orElse(null);
	       ticket.setPaymentInfo(ticketDetails.getPaymentInfo());
	       final Ticket updatedTicket = ticketRepository.save(ticket);
	       return ResponseEntity.ok(updatedTicket);
	   }
	
	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
         ticketRepository.deleteById(id);
    }
	
	
}


