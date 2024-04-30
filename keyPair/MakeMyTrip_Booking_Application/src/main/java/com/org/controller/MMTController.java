package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.binding.Passenger;
import com.org.binding.Ticket;
import com.org.service.MMTService;



@RestController
@RequestMapping("/mmt")
public class MMTController {
	
	
	@Autowired
	private MMTService mmtservice;
	
	@PostMapping("/bookTicket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger){
		Ticket ticket = mmtservice.bookTicket(passenger);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}
	
	@GetMapping("/getTicket/{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable("id") Integer ticketId){
		Ticket ticket = mmtservice.getTicket(ticketId);
		return ResponseEntity.ok(ticket);	
	}
	
	@GetMapping("/getAlltickets")
	public ResponseEntity<List<Ticket>> getTicket(){
		List<Ticket> allTickets = mmtservice.getAllTickets();
		return ResponseEntity.ok(allTickets);	
	}
	
	@DeleteMapping("deleteTicket/{id}")
	public ResponseEntity<String> deleteTicket(@PathVariable("id") Integer ticketId){
		String deleteTicket = mmtservice.deleteTicket(ticketId);
		return ResponseEntity.ok(deleteTicket);		
	}
	
	@PutMapping("/updateTicket/{id}")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Passenger passenger, @PathVariable("id") Integer ticketId){
		Ticket updateTicket = mmtservice.updateTicket(passenger, ticketId);
		return ResponseEntity.ok(updateTicket);			
	}
}
