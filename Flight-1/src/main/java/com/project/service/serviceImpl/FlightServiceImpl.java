 package com.project.service.serviceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.PassengerInfo;
import com.project.entity.TicketDetails;

import com.project.repository.PassengerInfoRepository;
import com.project.repository.TicketDetailsRepository;
import com.project.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	@Autowired
	private TicketDetailsRepository ticketDetailsRepository;
	
	@Override
	public TicketDetails insertDetails(PassengerInfo passengerInfo) {
		
		passengerInfoRepository.save(passengerInfo);
		
		TicketDetails ticketDetails = new TicketDetails();
		ticketDetails.setFullname(passengerInfo.getFname()+" "+passengerInfo.getLname());
		ticketDetails.setTripType(passengerInfo.getTripType());
		ticketDetails.setSrcCity(passengerInfo.getSrcCity());
		ticketDetails.setDestCity(passengerInfo.getDestCity());
		ticketDetails.setClassType(passengerInfo.getClassType());
		ticketDetails.setDate(passengerInfo.getDate());
		ticketDetails.setFlightNumber(passengerInfo.getFlightNumber());
		ticketDetails.setSeatNumber(passengerInfo.getSeatNumber());
		ticketDetails.setGate("G");
		ticketDetails.setBoardingGroup("Group B");
		
		TicketDetails savedTicketDetails = ticketDetailsRepository.save(ticketDetails);

		// Retrieve the generated PNR number from the saved entity
		Integer generatedPnrNo = savedTicketDetails.getPnrNo();

		// Set the generated PNR number in the response body
		savedTicketDetails.setPnrNo(generatedPnrNo);
		
		return ticketDetails;
	}

	@Override
	public TicketDetails getById(Integer pnrNo) {
		Optional<TicketDetails> findById = ticketDetailsRepository.findById(pnrNo);
		return findById.get();
	}

	@Override
	public TicketDetails updateDetails(Integer pnrNo,PassengerInfo passengerInfo) {
		Optional<TicketDetails> findById = ticketDetailsRepository.findById(pnrNo);
		TicketDetails ticketDetails = findById.get();
		
		 ticketDetails.setSrcCity(passengerInfo.getSrcCity());
		 ticketDetails.setDestCity(passengerInfo.getDestCity());
		 ticketDetails.setClassType(passengerInfo.getClassType());
		 ticketDetails.setDate(passengerInfo.getDate());
		
		 TicketDetails updatedTicketDetails = ticketDetailsRepository.save(ticketDetails);

	    return updatedTicketDetails;

		
	}

	@Override
	public void deleteDetails(Integer pnrNo) {
		ticketDetailsRepository.deleteById(pnrNo);
	}

	

	

	
	
	
	

}
