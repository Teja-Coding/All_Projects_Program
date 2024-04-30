package com.project.service;


import com.project.entity.PassengerInfo;
import com.project.entity.TicketDetails;

public interface FlightService {
	
	public TicketDetails insertDetails(PassengerInfo passengerInfo);
	
	public TicketDetails getById(Integer pnrNo);
	
	public TicketDetails updateDetails(Integer pnrNo,PassengerInfo passengerInfo);
	
	public void deleteDetails(Integer pnrNo);

}
