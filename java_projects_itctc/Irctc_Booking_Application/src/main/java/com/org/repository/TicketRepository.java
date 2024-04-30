package com.org.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entity.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Serializable>{

}
