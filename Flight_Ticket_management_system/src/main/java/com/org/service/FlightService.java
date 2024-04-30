package com.org.service;

import java.util.List;

import com.org.entity.Passenger_Details;
import com.org.entity.Ticket_details;


public interface FlightService {

	public Ticket_details bookTicket(Passenger_Details passenger);

	public Ticket_details getTicket(Integer ticketId);

	public Ticket_details updateDetails(Integer ticketId,Passenger_Details passenger_Details);
	
	public String deleteTicket(Integer ticketId);

	public List<Ticket_details> getAllTickets();
}
