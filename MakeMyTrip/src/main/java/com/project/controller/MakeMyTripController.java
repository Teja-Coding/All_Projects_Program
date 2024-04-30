package com.project.controller;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.entity.PassengerInfo;
import com.project.entity.TicketDetails;
import com.project.service.MakeMyTripRepository;



@RestController
public class MakeMyTripController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MakeMyTripRepository makeMyTripRepository;
	
	@PostMapping(value = "/passengers",consumes = MediaType.APPLICATION_JSON_VALUE)   // consumes not required
	public ResponseEntity<TicketDetails> bookTickets(@RequestBody PassengerInfo passengerInfo){
		
		makeMyTripRepository.savePassenger(passengerInfo);
		
		String url = "http://localhost:8080/booking";
		
		HttpHeaders headers = new HttpHeaders();    // not required
		headers.setContentType(MediaType.APPLICATION_JSON);  // not required
		
		HttpEntity<TicketDetails> requstEntity = new HttpEntity(passengerInfo,headers);   //headers not required 
		
		ResponseEntity<TicketDetails> responseEntity = restTemplate.postForEntity(url, requstEntity, TicketDetails.class);
		
		TicketDetails ticketDetails = responseEntity.getBody();
		makeMyTripRepository.saveTicket(ticketDetails);
		 return ResponseEntity.ok(ticketDetails);
		
	}
	
	@GetMapping("/getTickets")
	public ResponseEntity<List<TicketDetails>> getAllTickets(){
		String url = "http://localhost:8080/getAllTickets";
		
		ResponseEntity<TicketDetails[]> responseEntity = restTemplate.getForEntity(url, TicketDetails[].class);
		TicketDetails[] ticketDetails = responseEntity.getBody();
		List<TicketDetails> ticketDetailsList = Arrays.asList(ticketDetails);
		
		return ResponseEntity.ok(ticketDetailsList);
		
		
	}
	
	@PutMapping("/updateDetails/{pnr}")
	public ResponseEntity<TicketDetails> updateTickets(@PathVariable String pnr,@RequestBody PassengerInfo passengerInfo){
		String url = "http://localhost:8080/updateTicket/{pnr}";
		
		
		HttpEntity<PassengerInfo> requestEntity = new HttpEntity<>(passengerInfo);
		
		ResponseEntity<TicketDetails> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,requestEntity,TicketDetails.class,pnr);
		TicketDetails ticketDetails = responseEntity.getBody();
		
		makeMyTripRepository.updateDetails(pnr,passengerInfo);
		return ResponseEntity.ok(ticketDetails);
		
	}
	
	@DeleteMapping("/deleteTicket/{pnr}")
	public ResponseEntity<String> deleteTicket(@PathVariable String pnr){
		
		String url = "http://localhost:8080/deleteTicket/{pnr}";
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE,null,String.class,pnr);
		String body = responseEntity.getBody();
		makeMyTripRepository.deleteTicket(pnr);
		return ResponseEntity.ok(body);
	}
	
}
