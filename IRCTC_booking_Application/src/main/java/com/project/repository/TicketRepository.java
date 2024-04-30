package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.TicketDetail;

public interface TicketRepository extends JpaRepository<TicketDetail, Integer>{
	
	@Query(value = "SELECT MAX(pnrNo) FROM TicketDetail")
    String getLastGeneratedPNR();
	
	TicketDetail findByPnrNo(String pnrNo);

}
