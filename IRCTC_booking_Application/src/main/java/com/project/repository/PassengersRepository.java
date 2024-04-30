package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.PassengerInfo;

public interface PassengersRepository extends JpaRepository<PassengerInfo, Integer>{
	
	PassengerInfo findByName(String pName);

}
