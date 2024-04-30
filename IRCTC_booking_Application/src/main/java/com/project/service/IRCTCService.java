package com.project.service;

import java.util.List;

import com.project.entity.PassengerInfo;
import com.project.entity.TicketDetail;

public interface IRCTCService {
	
	public TicketDetail insertDetails(PassengerInfo passengerInfo);
	
	public List<TicketDetail> getAllTickets();
	
	public TicketDetail getByPNR(String pnr);
	
	public TicketDetail updateDetails(String pnr,PassengerInfo passengerInfo);
	
	public void deleteTicket(String pnr);

	

}
