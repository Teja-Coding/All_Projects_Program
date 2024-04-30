package com.org.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entity.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Serializable>{

}
