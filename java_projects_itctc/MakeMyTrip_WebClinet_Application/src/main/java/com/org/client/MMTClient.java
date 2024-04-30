package com.org.client;

import java.lang.ref.Cleaner.Cleanable;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.org.binding.Passenger;
import com.org.binding.Ticket;

import ch.qos.logback.core.net.server.Client;

@Service
public class MMTClient {

	public void invokeGetTicket() {

		String getAllUrl = "http://localhost:8080/irctc/getAllTickets";
		
		WebClient client =WebClient.create();
		
		String block = client.get().uri(getAllUrl).retrieve().bodyToMono(String.class).block();
		
		System.out.println(block);
	}
	
	
	public void invokePostData() {
		String bookUrl= "http://localhost:8080/irctc/bookTicket";
		
		Passenger pass = new Passenger();
		Ticket tc =new Ticket();
		
		pass.setName("manikanta");
		pass.setDestination("tanuku");
		pass.setSource("vizag");
		pass.setTrainNum(854582);
		pass.setJourneyDate("30/6/2023");
		
		tc.setName(pass.getName());
		tc.setDestination(pass.getDestination());
		tc.setJourneyDate(pass.getJourneyDate());
		tc.setSource(pass.getSource());
		tc.setPnr("526582628");
		tc.setStatus("confirm");
		tc.setTrainNum(74657);
		
		WebClient client = WebClient.create();
		
		String block = client.post().uri(bookUrl).bodyValue(pass).retrieve().bodyToMono(String.class).block();
		
		
		
		
	}
}
