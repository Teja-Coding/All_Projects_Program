package com.org.service;

import java.util.List;

import com.org.binding.Passenger;
import com.org.binding.Ticket;



public interface TravelYaariService {

	Ticket bookTicket(Passenger passenger);

	List<Ticket> getAllTickets();
	
	String deleteTicket(Integer ticketId);
	
	Ticket getTicket(Integer ticketId);



	


}
