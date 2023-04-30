package com.avisys.cim.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Customer;
import com.avisys.cim.Dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Customer> getCustomers(String firstName, String lastName, String mobileNumber) {
		
		List<Customer> CList = customerDao.findAll();
		if(firstName == null && lastName == null && mobileNumber == null)
		{
			return CList;
		}
		if(firstName != null)
		{
			CList = CList.stream().filter(c -> c.getFirstName().toLowerCase().contains(firstName.toLowerCase()))
					.collect(Collectors.toList());
		}
		if(lastName != null)
		{
			CList = CList.stream().filter(c -> c.getLastName().toLowerCase().contains(lastName.toLowerCase()))
					.collect(Collectors.toList());
		}
		if(mobileNumber != null)
		{
			CList = CList.stream().filter(c -> c.getMobileNumber().equals(mobileNumber))
					.collect(Collectors.toList());
		}
		return CList;
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		Customer c = customerDao.findByMobileNumber(customer.getMobileNumber());
		if(c != null)
		{
			return null;
		}
		else
		{
			return customerDao.save(customer);
		}
	}


//	@Override
//	public boolean addCustomer(Customer c) {
//
//		Customer customer=customerDao.findByMobileNumber(c.getMobileNumber());
//		if(customer!=null)
//		{
//			return false;
//		}
//		else
//		{
//			customerDao.save(c);
//			return true;
//		}
//		
//	}
	

}
