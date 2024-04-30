package com.project.controller;

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

import com.project.entity.PassengerInfo;
import com.project.entity.TicketDetails;
import com.project.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping("/booking")
	public ResponseEntity<TicketDetails> insertInfo(@RequestBody PassengerInfo passengerInfo){
		TicketDetails insertDetails = flightService.insertDetails(passengerInfo);
		return new ResponseEntity<TicketDetails>(insertDetails,HttpStatus.CREATED);
	}
	
	@GetMapping("/ticketDetails/{pnrNo}")
	public ResponseEntity<TicketDetails> getTicketDetails(@PathVariable Integer pnrNo){
		TicketDetails ticketDetails = flightService.getById(pnrNo);
		return new ResponseEntity<TicketDetails>(ticketDetails,HttpStatus.OK);
	}
	
	@PutMapping("/update/{pnrNo}")
	public ResponseEntity<TicketDetails> updateTicketDetails(@PathVariable Integer pnrNo,@RequestBody PassengerInfo passengerInfo){
		TicketDetails details = flightService.updateDetails(pnrNo, passengerInfo);
		return new ResponseEntity<TicketDetails>(details,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteTicket/{pnrNo}")
	public ResponseEntity<String>  deleteTicket(@PathVariable Integer pnrNo){
		
		flightService.deleteDetails(pnrNo);
		return new ResponseEntity<String>("Ticket Deleted",HttpStatus.OK);
		
	}
	
	
	

}
