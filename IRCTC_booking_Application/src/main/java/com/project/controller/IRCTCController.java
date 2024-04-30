package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.PassengerInfo;
import com.project.entity.TicketDetail;
import com.project.service.IRCTCService;

@RestController
public class IRCTCController {
	
	@Autowired
	private IRCTCService irctcService;
	
	@PostMapping(value = "/booking",consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDetail> bookTicket(@RequestBody PassengerInfo passengerInfo){
		TicketDetail ticketDetail = irctcService.insertDetails(passengerInfo);
		return new ResponseEntity<TicketDetail>(ticketDetail,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllTickets")
	public ResponseEntity<List<TicketDetail>> getAllTickets(){
		List<TicketDetail> allTickets = irctcService.getAllTickets();
		return new ResponseEntity<List<TicketDetail>>(allTickets,HttpStatus.OK);
	}
	
	@PutMapping("/updateTicket/{pnr}")
	public ResponseEntity<TicketDetail> updateTicket(@PathVariable String pnr,@RequestBody PassengerInfo passengerInfo){
		TicketDetail ticketDetail = irctcService.updateDetails(pnr, passengerInfo);
		return new ResponseEntity<TicketDetail>(ticketDetail,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteTicket/{pnr}")
	public ResponseEntity<String> deleteTicket(@PathVariable String pnr){
		irctcService.deleteTicket(pnr);
		return new ResponseEntity<String>("Ticket Deleted",HttpStatus.OK);
	}

}
