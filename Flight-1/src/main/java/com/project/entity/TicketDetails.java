package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TicketDetails")
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnrNoGenerator")
	@SequenceGenerator(name = "pnrNoGenerator", sequenceName = "pnr_sequence", initialValue = 500001, allocationSize = 1)
	@Column(name = "PNR_no")
	private Integer pnrNo = 500001;
	@Column(name = "Gate")
	private String gate;
	@Column(name = "Boarding_group")
	private String boardingGroup;
	@Column(name = "Full_Name")
	private String fullname;
	@Column(name = "Trip_type")
	private String tripType;
	@Column(name = "Src_city")
	private String srcCity;
	@Column(name = "Dest_city")
	private String destCity;
	@Column(name = "Flight_number")
	private String flightNumber;
	@Column(name = "Seat_number")
	private String seatNumber;
	@Column(name = "Class_type")
	private String classType;
	@Column(name = "date")
	private String date;
	public Integer getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(Integer pnrNo) {
		this.pnrNo = pnrNo;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	public String getBoardingGroup() {
		return boardingGroup;
	}
	public void setBoardingGroup(String boardingGroup) {
		this.boardingGroup = boardingGroup;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public String getSrcCity() {
		return srcCity;
	}
	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}
	public String getDestCity() {
		return destCity;
	}
	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "TicketDetails [pnrNo=" + pnrNo + ", gate=" + gate + ", boardingGroup=" + boardingGroup + ", fullname="
				+ fullname + ", tripType=" + tripType + ", srcCity=" + srcCity + ", destCity=" + destCity
				+ ", flightNumber=" + flightNumber + ", seatNumber=" + seatNumber + ", classType=" + classType
				+ ", date=" + date + "]";
	}
	
	

	
	
	
	

}
