package com.avisys.cim.Service;

import java.util.List;

import com.avisys.cim.beans.Customer;
import com.avisys.cim.beans.CustomerDTO;

public interface CustomerService {

	List<CustomerDTO> getCustomers(String firstName,String lastName,String mobileNumber);

	boolean insertCustomer(CustomerDTO customerDto);

	boolean deleteCustomer(String mobileNo);

	//Customer addNewCustomer(Customer customer);

	//boolean addCustomer(Customer c);

	

}
