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

import com.org.entity.Passenger_Details;
import com.org.entity.Ticket_details;
import com.org.service.FlightService;

@RestController
public class FlightControler {

	@Autowired
	private FlightService flightService;

	@PostMapping("/bookFlightTicket")
	public ResponseEntity<Ticket_details> bookTicket(@RequestBody Passenger_Details passenger) {
		Ticket_details bookTicket = flightService.bookTicket(passenger);

		return new ResponseEntity<Ticket_details>(bookTicket, HttpStatus.CREATED);

	}

	@GetMapping("/allTickets")
	public ResponseEntity<List<Ticket_details>> getAllTickets() {
		List<Ticket_details> allTickets = flightService.getAllTickets();
		return new ResponseEntity<List<Ticket_details>>(allTickets, HttpStatus.OK);

	}

	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<Ticket_details> getTicketById(@PathVariable("ticketId") Integer ticketId) {
		Ticket_details ticket = flightService.getTicket(ticketId);
		return new ResponseEntity<Ticket_details>(ticket, HttpStatus.OK);

	}


	@DeleteMapping("/deleteTicket/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable("ticketId")Integer  ticketNumber) {
		String deleteTicket = flightService.deleteTicket(ticketNumber);
		return new ResponseEntity<String>(deleteTicket, HttpStatus.OK);

	}
	
	@PutMapping("/update/{ticketId}")
	public ResponseEntity<Ticket_details> updateTicketDetails(@PathVariable Integer ticketId,@RequestBody Passenger_Details passengerInfo){
		Ticket_details details = flightService.updateDetails(ticketId, passengerInfo);
		return new ResponseEntity<Ticket_details>(details,HttpStatus.CREATED);
	}

}
