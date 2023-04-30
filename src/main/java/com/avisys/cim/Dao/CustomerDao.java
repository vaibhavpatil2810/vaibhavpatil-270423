package com.avisys.cim.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.avisys.cim.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

	
	

}
