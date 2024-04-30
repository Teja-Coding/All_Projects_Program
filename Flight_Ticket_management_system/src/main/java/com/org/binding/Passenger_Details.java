package com.org.binding;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Passenger_Details {

	private Integer passengerId;

	private String passengerName;

	private String passengerEmail;

	private String passengerPhoneNumber;

	private Integer passengerAge;

	private Long passengerAadherNumber;

	private String from;

	private String to;

	private String SelectClass;

	private String journeyDate;

}
