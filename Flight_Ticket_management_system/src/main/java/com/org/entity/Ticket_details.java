package com.org.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ticket_Information")
public class Ticket_details {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticketIdGenerator")
	@SequenceGenerator(name = "ticketIdGenerator", sequenceName = "ticketIdsequence", initialValue = 700001, allocationSize = 1)
	@Column(name = "Ticket_Id")
	private Integer ticketId = 700001;
	
	@Column(name = "ticket_number")
	private String flightTicketNumber;
	
	@Column(name="Flight_name")
	private String flightName;
	
	@Column(name="Flight_Number")
	private String flightNumber;
	
	@Column(name="Passenger_name")
	private String nameOfPassenger;
	
	@Column(name="passenger_from")
	private String from;
	
	@Column(name="passenger_to")
	private String to;
	
	@Column(name = "journey_date") 
	private String journeyDate;
	
	@Column(name="gate_number")
	private Integer gateNumber;
	
	@Column(name="boarding_time")
	private String BoardingTime;
	
	@Column(name="Seat_number")
	private String seatNumber;
	
	@Column(name = "Ticket_status")
	private String ticketStatus;
	
	@Column(name="ticket_price")
	private Double ticketPrice;
	
	
}
