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
	@Column(name = "PassengerId")
	private Integer pId;
	@Column(name = "PassengerName")
	private String name;
	@Column(name = "SourceStation")
	private String srcStation;
	@Column(name = "DestinationStation")
	private String destStation;
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getpName() {
		return name;
	}
	public void setpName(String pName) {
		this.name = pName;
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
		return "PassengerInfo [pId=" + pId + ", pName=" + name + ", srcStation=" + srcStation + ", destStation="
				+ destStation + "]";
	}
	
	
	

}
