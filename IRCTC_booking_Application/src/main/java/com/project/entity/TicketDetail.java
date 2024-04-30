package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tickets")
public class TicketDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TicketId")
	private Integer ticketID;
	@Column(name = "PnrNo")
	private String pnrNo;
	@Column(name = "PassengerName")
	private String pName;
	@Column(name = "SourceStation")
	private String srcStation;
	@Column(name = "DestinationStation")
	private String destStation;
	public Integer getTicketID() {
		return ticketID;
	}
	public void setTicketID(Integer ticketID) {
		this.ticketID = ticketID;
	}
	public String getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getSrcStation() {
		return srcStation;
	}
	public void setSrcStation(String srcStation) {
		this.srcStation = srcStation;
	}
	public String getDestStation() {
		return destStation;
	}
	public void setDestStation(String destStation) {
		this.destStation = destStation;
	}
	@Override
	public String toString() {
		return "TicketDetail [ticketID=" + ticketID + ", pnrNo=" + pnrNo + ", pName=" + pName + ", srcStation="
				+ srcStation + ", destStation=" + destStation + "]";
	}
	
	
	

}
