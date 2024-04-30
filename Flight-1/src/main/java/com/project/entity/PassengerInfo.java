package com.project.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Passengers")
public class PassengerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Passenger_Id")
	private Integer pId;
	@Column(name = "Passenger_first_name")
	private String fname;
	@Column(name = "Passenger_last_name")
	private String lname;
	@Column(name = "Passenger_gender")
	private String gender;
	@Column(name = "Passenger_mobile_no")
	private Long phNo;
	@Column(name = "Passenger_email")
	private String email;
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
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getPhNo() {
		return phNo;
	}
	public void setPhNo(Long phNo) {
		this.phNo = phNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return "PassengerInfo [pId=" + pId + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", phNo="
				+ phNo + ", email=" + email + ", tripType=" + tripType + ", srcCity=" + srcCity + ", destCity="
				+ destCity + ", flightNumber=" + flightNumber + ", seatNumber=" + seatNumber + ", classType="
				+ classType + ", date=" + date + "]";
	}
	
	
	
	
}
