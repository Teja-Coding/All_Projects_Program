package com.org.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.entity.Passenger_Details;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger_Details, Serializable> {

}
