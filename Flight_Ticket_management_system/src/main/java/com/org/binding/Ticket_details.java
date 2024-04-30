package com.org.binding;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Ticket_details {

	private Integer ticketId;

	private String flightTicketNumber;

	private String flightName;

	private String flightNumber;

	private String nameOfPassenger;

	private String from;

	private String to;

	private Date journeyDate;

	private Integer gateNumber;

	private String BoardingTime;

	private String seatNumber;

	private String ticketStatus;

	private Double ticketPrice;

}
