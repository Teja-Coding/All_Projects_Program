package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.entity.TicketDetails;

public interface TicketRepository extends JpaRepository<TicketDetails, Integer>{
	
	TicketDetails findByPnrNo(String pnrNo);
	

}
