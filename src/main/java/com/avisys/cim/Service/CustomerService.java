package com.avisys.cim.Service;

import java.util.List;

import com.avisys.cim.Customer;

public interface CustomerService {

	List<Customer> getCustomers(String fname, String lname, String mobileNo);

	Customer addNewCustomer(Customer customer);

	//boolean addCustomer(Customer c);

	

}
