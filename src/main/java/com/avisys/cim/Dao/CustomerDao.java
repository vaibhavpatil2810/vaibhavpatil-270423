package com.avisys.cim.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avisys.cim.beans.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

	
//	 @Query("SELECT c FROM Customer c JOIN FETCH c.mobileNumbers")
//	 List<Customer> findAllWithMobileNumbers();
}
