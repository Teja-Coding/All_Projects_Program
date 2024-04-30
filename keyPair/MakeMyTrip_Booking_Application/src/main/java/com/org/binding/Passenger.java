package com.org.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

	private Integer pid;
	
	private String name;
	
	private String journeyDate;
	
	private Integer trainNum;
	private String source;
	private String destination;
}
