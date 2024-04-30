package com.org.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.org.binding.Passenger;
import com.org.binding.Ticket;
import com.org.service.TravelYaariService;

@Service
public class TravelYaariServiceImpl implements TravelYaariService {

	@Override
	public Ticket bookTicket(Passenger passenger) {
		// TODO Auto-generated method stub
		String bookUrl = "http://localhost:8080/irctc/bookTicket";
		WebClient client = WebClient.create();

		Ticket ticket = client.post().uri(bookUrl).bodyValue(passenger).retrieve().bodyToMono(Ticket.class).block();
		return ticket;
	}


	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		String getAllUrl = "http://localhost:8080/irctc/getAllTickets";
		WebClient client = WebClient.create();
		Ticket[] ticketsDetails = client.get().uri(getAllUrl).retrieve().bodyToMono(Ticket[].class).block();
		List<Ticket> tickets = Arrays.asList(ticketsDetails);
		return tickets;
	}


	@Override
	public String deleteTicket(Integer ticketId) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/irctc/deleteTicket/{id}";
		String deleteTicket = WebClient.create().delete().uri(url).retrieve().bodyToMono(String.class).block();
		return deleteTicket;
		
	}


	@Override
	public Ticket getTicket(Integer ticketId) {
		// TODO Auto-generated method stub
		String getUrl= "http://localhost:8080/irctc/getTicket/{id}";
		Map<String, Integer> param = new HashMap<>();
		param.put("id", ticketId);
		Ticket getTicket = WebClient.create().get().uri(getUrl,ticketId).retrieve().bodyToMono(Ticket.class).block();
		return getTicket;
		
	}







	
}
