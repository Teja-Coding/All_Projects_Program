package com.org.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.entity.Ticket_details;

@Repository
public interface TicketRepository extends JpaRepository<Ticket_details,Serializable> {

}
