package com.org.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Passenger_Details;
import com.org.entity.Ticket_details;
import com.org.otp.OTPGenerator;
import com.org.repository.PassengerRepository;
import com.org.repository.TicketRepository;
import com.org.service.FlightService;



@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private PassengerRepository passengerRepository;
	
	private Map<String, Ticket_details> flightTicket=new HashMap<>();

	@Override
	public Ticket_details bookTicket(Passenger_Details passenger) {
		// TODO Auto-generated method stub
		
		Ticket_details ticketDetails=new Ticket_details();
		ticketDetails.setFlightTicketNumber(OTPGenerator.generateOTP());
		ticketDetails.setFlightName("Sky Airlines");
		ticketDetails.setFlightNumber(OTPGenerator.generateOTP());
		ticketDetails.setNameOfPassenger(passenger.getPassengerName());
		ticketDetails.setTicketPrice(4500.00);
		ticketDetails.setFrom(passenger.getFrom());
		ticketDetails.setTo(passenger.getTo());
		ticketDetails.setGateNumber(45);
		ticketDetails.setTicketStatus("confrimed");
		ticketDetails.setSeatNumber("A55");
		ticketDetails.setBoardingTime("18:55");
		ticketDetails.setJourneyDate(passenger.getJourneyDate());
		
		flightTicket.put(OTPGenerator.generateOTP(), ticketDetails);
		
		

		
		Ticket_details saveTicket = ticketRepository.save(ticketDetails);
		// Retrieve the generated PNR number from the saved entity
		Integer ticketId = saveTicket.getTicketId();
		

		// Set the generated PNR number in the response body
		saveTicket.setTicketId(ticketId);
		
		Passenger_Details save2 = passengerRepository.save(passenger);
		
		System.out.println(ticketDetails);
		
		
		return ticketDetails;
	}

	@Override
	public Ticket_details getTicket(Integer ticketId) {
		Optional<Ticket_details> findById = ticketRepository.findById(ticketId);
		return findById.get();
		
	}


	@Override
	public String deleteTicket(Integer  ticketId) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(ticketId);
		return "Ticket is Succesfully Deleleted...";
	}

	@Override
	public List<Ticket_details> getAllTickets() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public Ticket_details updateDetails(Integer ticketId,Passenger_Details passenger) {
		 Optional<Ticket_details> findById = ticketRepository.findById(ticketId);
		Ticket_details ticketDetails = findById.get();
		
		 ticketDetails.setFrom(passenger.getFrom());
		 ticketDetails.setJourneyDate(passenger.getJourneyDate());
		
		 Ticket_details updatedTicketDetails = ticketRepository.save(ticketDetails);

	    return updatedTicketDetails;
	}

}
