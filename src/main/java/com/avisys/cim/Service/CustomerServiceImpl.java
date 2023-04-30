package com.avisys.cim.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Dao.CustomerDao;
import com.avisys.cim.beans.Customer;
import com.avisys.cim.beans.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public List<CustomerDTO> getCustomers(String firstName,String lastName,String mobileNumber) {
		
		List<Customer> CList = customerDao.findAll();
		List<CustomerDTO> CustomerDTOList = CList.stream().map(CustomerDTO::new).collect(Collectors.toList());
		if(firstName == null && lastName == null && mobileNumber == null)
		{
			return CustomerDTOList;
		}
		if(firstName != null)
		{
			CustomerDTOList = CustomerDTOList.stream().filter(c -> c.getFirstName().toLowerCase().contains(firstName.toLowerCase()))
					.collect(Collectors.toList());
		}
		if(lastName != null)
		{
			CustomerDTOList = CustomerDTOList.stream().filter(c -> c.getLastName().toLowerCase().contains(lastName.toLowerCase()))
					.collect(Collectors.toList());
		}
		if(mobileNumber != null)
		{
			CustomerDTO matchedCustomer = null;
			for(CustomerDTO customerDto : CustomerDTOList)
			{
				List<String> IndividualCustomerMobileNumberList = customerDto.getMobileNumbers();
				for(String number : IndividualCustomerMobileNumberList)
				{
					
					if(number.equals(mobileNumber))
					{
						System.out.println("in if");
						matchedCustomer = customerDto;
						break;
					}
				}
			}
			CustomerDTOList.clear();
			CustomerDTOList.add(matchedCustomer);
		}
		return CustomerDTOList;
		
		
	}

//	@Override
//	public Customer addNewCustomer(Customer customer) {
//		Customer c = customerDao.findByMobileNumber("jhhg");//customer.getMobileNumber()
//		if(c != null)
//		{
//			return null;
//		}
//		else
//		{
//			return customerDao.save(customer);
//		}
//	}



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
