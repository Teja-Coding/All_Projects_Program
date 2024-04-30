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
import org.springframework.web.bind.annotation.RestController;

import com.org.binding.Passenger;
import com.org.binding.Ticket;
import com.org.service.TravelYaariService;

@RestController
public class TravelYaariController {
	
	@Autowired
	private TravelYaariService travelYaariService;
	
	@PostMapping("/bookingTicket")
	public ResponseEntity<Ticket> bookTicket (@RequestBody Passenger passenger){
		Ticket ticket =travelYaariService.bookTicket(passenger);
		return new ResponseEntity<Ticket>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllTickets")
	public ResponseEntity<List<Ticket>> getAllTickets(){
		List<Ticket> allTickets = travelYaariService.getAllTickets();
		return new ResponseEntity<List<Ticket>>(allTickets,HttpStatus.OK);
	}
	

	@DeleteMapping("deleteTicket/{id}")
	public ResponseEntity<String> deleteTicket(@PathVariable("id") Integer ticketId){
		String deleteTicket = travelYaariService.deleteTicket(ticketId);
		return ResponseEntity.ok(deleteTicket);		
	}
	

	@GetMapping("/getTicket/{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable("id") Integer ticketId){
		Ticket ticket = travelYaariService.getTicket(ticketId);
		return ResponseEntity.ok(ticket);	
	}
	
	
}