package com.org.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Passenger_Information")
public class Passenger_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passenger_Id")
	private Integer passengerId;
	
	@Column(name = "passenger_name")
	private String passengerName;
	
	@Column(name = "email_id")
	private String passengerEmail;
	
	@Column(name = "phone_number")
	private String passengerPhoneNumber;
	
	@Column(name="passenger_Age")
	private Integer passengerAge;
	
	@Column(name = "Aadher_number")
	private Long passengerAadherNumber;
	
	@Column(name="passenger_from")
	private String from;
	
	@Column(name="passenger_to")
	private String to;
	
	@Column(name="Selected_Class")
	private String SelectClass;
	
	@Column(name="journey_Date")
	private String journeyDate;
	
	
}
