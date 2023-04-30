package com.avisys.cim.Service;

import java.util.List;

import com.avisys.cim.Customer;

public interface CustomerService {

	List<Customer> getCustomers(String fname, String lname, String mobileNo);

	

	//boolean addCustomer(Customer c);

	

}
