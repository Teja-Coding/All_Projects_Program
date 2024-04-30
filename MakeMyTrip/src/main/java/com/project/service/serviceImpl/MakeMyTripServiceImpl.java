package com.project.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.PassengerInfo;
import com.project.entity.TicketDetails;
import com.project.repository.PassengerRespository;
import com.project.repository.TicketRepository;
import com.project.service.MakeMyTripRepository;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripRepository{
	
	@Autowired
	private PassengerRespository passengerRespository;
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void savePassenger(PassengerInfo passengerInfo) {
		passengerRespository.save(passengerInfo);
		
	}

	@Override
	public void saveTicket(TicketDetails ticketDetails) {
		ticketRepository.save(ticketDetails);
		
	}

	@Override
	public TicketDetails updateDetails(String pnr, PassengerInfo passengerInfo) {
		TicketDetails ticketDetail = ticketRepository.findByPnrNo(pnr);
		String name = ticketDetail.getpName();
		PassengerInfo passenger = passengerRespository.findByName(name);
		passenger.setDestStation(passengerInfo.getDestStation());
		passenger.setSrcStation(passengerInfo.getSrcStation());
		ticketDetail.setDestStation(passengerInfo.getDestStation());
		ticketDetail.setSrcStation(passengerInfo.getSrcStation());
		ticketRepository.save(ticketDetail);
		passengerRespository.save(passenger);
		
		return ticketDetail;
	}

	@Override
	public void deleteTicket(String pnr) {
		TicketDetails ticketDetails = ticketRepository.findByPnrNo(pnr);
		String name = ticketDetails.getpName();
		PassengerInfo passengerInfo = passengerRespository.findByName(name);
		ticketRepository.deleteById(ticketDetails.getTicketID());
		passengerRespository.deleteById(passengerInfo.getpId());
		
	}
	
}
