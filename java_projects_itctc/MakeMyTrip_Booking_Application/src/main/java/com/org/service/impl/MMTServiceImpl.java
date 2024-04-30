package com.org.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.binding.Passenger;
import com.org.binding.Ticket;
import com.org.service.MMTService;
;

@Service
@Component
public class MMTServiceImpl implements MMTService{
	
	@Autowired
	private RestTemplate restTemplate;
	

	
	@Override
	public Ticket bookTicket(Passenger passenger) {
	
		String bookUrl= "http://localhost:8080/irctc/bookTicket";
		Passenger pass = new Passenger();
		pass.setPid(passenger.getPid());
		pass.setName(passenger.getName());
		pass.setJourneyDate(passenger.getJourneyDate());
		pass.setTrainNum(passenger.getTrainNum());
		pass.setSource(passenger.getSource());
		pass.setDestination(passenger.getDestination());
		ResponseEntity<Ticket> responseEntity = restTemplate.postForEntity(bookUrl,pass, Ticket.class);
		Ticket ticket = responseEntity.getBody();
		System.out.println(ticket);
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		String getUrl= "http://localhost:8080/irctc/getTicket/{id}";
		Map<String, Integer> param = new HashMap<>();
		param.put("id", ticketId);
		Ticket getTicket = restTemplate.getForObject(getUrl, Ticket.class, param);
		return getTicket;
	}
	
	@Override
	public List<Ticket> getAllTickets(){
		String getAllUrl= "http://localhost:8080/irctc/getAllTickets";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<Ticket[]> responseEntity = restTemplate.exchange(getAllUrl, HttpMethod.GET, entity, Ticket[].class);
		Ticket[] tickets = responseEntity.getBody();
		List<Ticket> list = Arrays.asList(tickets);
		return list;
	}

	@Override
	public String deleteTicket(Integer ticketId) {
		String url = "http://localhost:8080/irctc/deleteTicket/{id}";
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE,null,String.class,ticketId);
		String delete = responseEntity.getBody();
		return delete;
	}

	@Override
	public Ticket updateTicket(Passenger passenger, Integer ticketId) {
		String updateUrl= "http://localhost:8080/irctc/updateTicket/{id}";
		Map<String, Integer> ticketMap = new HashMap<>();
		ticketMap.put("id", ticketId);
		Passenger updatedPassenger = new Passenger();
		updatedPassenger.setJourneyDate(passenger.getJourneyDate());
		updatedPassenger.setName(passenger.getName());
		updatedPassenger.setPid(ticketId);
		updatedPassenger.setTrainNum(passenger.getTrainNum());
		updatedPassenger.setSource(passenger.getSource());
		updatedPassenger.setDestination(passenger.getDestination());
		HttpEntity<Passenger> requestEntity = new HttpEntity<>(passenger);
		ResponseEntity<Ticket> updated = restTemplate.exchange(updateUrl, HttpMethod.PUT,requestEntity,Ticket.class,ticketId);
		Ticket updatedTicket = updated.getBody();
		return updatedTicket;
	}

	
}