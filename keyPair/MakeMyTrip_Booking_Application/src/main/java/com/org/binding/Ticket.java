package com.org.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	private Integer ticketId;
	private String pnr;
	private String status;
	private Integer trainNum;
	private String name;
	private String JourneyDate;
	private String source;
	private String destination;
}
