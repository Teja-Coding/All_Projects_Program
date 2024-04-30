package com.org.service;

import java.util.List;

import com.org.entity.Passenger;
import com.org.entity.Ticket;


public interface TicketService {

	Ticket bookTicket(Passenger passenger);
	
	List<Ticket> getAllTickets();
	
	Ticket getTicket(Integer ticketId);
	
	String deleteTicket(Integer id);
	
	Ticket updateTicket(Passenger passenger, Integer ticketId);
}
