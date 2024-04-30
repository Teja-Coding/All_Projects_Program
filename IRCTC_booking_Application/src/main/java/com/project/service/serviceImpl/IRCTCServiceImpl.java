package com.project.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.PassengerInfo;
import com.project.entity.TicketDetail;
import com.project.repository.PassengersRepository;
import com.project.repository.TicketRepository;
import com.project.service.IRCTCService;

@Service
public class IRCTCServiceImpl implements IRCTCService{
	
	@Autowired
	private PassengersRepository passengersRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	private String generatePNR() {
	    String lastPNR = ticketRepository.getLastGeneratedPNR();

	    String nextPNR;
	    if (lastPNR == null) {
	        nextPNR = "500000000"; 
	    } else {
	        int lastPNRValue = Integer.parseInt(lastPNR);
	        int nextPNRValue = lastPNRValue + 1;
	        nextPNR = String.format("%08d", nextPNRValue);  
	    }
	    
	    return nextPNR;
	}

	@Override
	public TicketDetail insertDetails(PassengerInfo passengerInfo) {
		passengersRepository.save(passengerInfo);
		
		TicketDetail ticketDetail = new TicketDetail();
		ticketDetail.setpName(passengerInfo.getpName());
		ticketDetail.setSrcStation(passengerInfo.getSrcStation());
		ticketDetail.setDestStation(passengerInfo.getDestStation());
		ticketDetail.setPnrNo(generatePNR());
		
		ticketRepository.save(ticketDetail);
		
		return ticketDetail;
		

	}

	@Override
	public List<TicketDetail> getAllTickets() {
		List<TicketDetail> ticketDetails = ticketRepository.findAll();
		return ticketDetails;
	}

	@Override
	public TicketDetail getByPNR(String pnr) {
		return ticketRepository.findByPnrNo(pnr);
	}

	@Override
	public TicketDetail updateDetails(String pnr, PassengerInfo passengerInfo) {
		TicketDetail ticketDetail = ticketRepository.findByPnrNo(pnr);
		String name = ticketDetail.getpName();
		PassengerInfo passenger = passengersRepository.findByName(name);
		passenger.setDestStation(passengerInfo.getDestStation());
		passenger.setSrcStation(passengerInfo.getSrcStation());
		ticketDetail.setDestStation(passengerInfo.getDestStation());
		ticketDetail.setSrcStation(passengerInfo.getSrcStation());
		ticketRepository.save(ticketDetail);
		passengersRepository.save(passenger);
		
		return ticketDetail;	
	}

	@Override
	public void deleteTicket(String pnr) {
		TicketDetail ticketDetail = ticketRepository.findByPnrNo(pnr);
		String name = ticketDetail.getpName();
		PassengerInfo passengerInfo = passengersRepository.findByName(name);
		ticketRepository.deleteById(ticketDetail.getTicketID());
		passengersRepository.deleteById(passengerInfo.getpId());
		
	}
	
	
	
	
	
	

	

}
