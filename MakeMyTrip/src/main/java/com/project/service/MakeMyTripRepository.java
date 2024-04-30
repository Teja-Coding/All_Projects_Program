package com.project.service;

import com.project.entity.PassengerInfo;
import com.project.entity.TicketDetails;

public interface MakeMyTripRepository {
	
	public void savePassenger(PassengerInfo passengerInfo);
	
	public void saveTicket(TicketDetails ticketDetails);

	public TicketDetails updateDetails(String pnr,PassengerInfo passengerInfo);
	
	public void deleteTicket(String pnr);
}
