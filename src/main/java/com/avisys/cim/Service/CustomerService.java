package com.avisys.cim.Service;

import java.util.List;

import com.avisys.cim.beans.Customer;
import com.avisys.cim.beans.CustomerDTO;

public interface CustomerService {

	List<CustomerDTO> getCustomers(String firstName,String lastName,String mobileNumber);

	//Customer addNewCustomer(Customer customer);

	//boolean addCustomer(Customer c);

	

}
