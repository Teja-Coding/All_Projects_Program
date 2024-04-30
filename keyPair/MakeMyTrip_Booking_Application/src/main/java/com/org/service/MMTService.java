package com.org.service;

import java.util.List;

import com.org.binding.Passenger;
import com.org.binding.Ticket;



public interface MMTService {

	Ticket bookTicket(Passenger passenger);

	Ticket getTicket(Integer ticketId);

	List<Ticket> getAllTickets();

	String deleteTicket(Integer ticketId);

	Ticket updateTicket(Passenger passenger, Integer ticketId);


}
