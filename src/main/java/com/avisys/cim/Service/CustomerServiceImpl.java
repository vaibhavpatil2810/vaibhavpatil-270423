package com.avisys.cim.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Dao.CustomerDao;
import com.avisys.cim.beans.Customer;
import com.avisys.cim.beans.CustomerDTO;
import com.avisys.cim.beans.MobileNumber;

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

	@Override
	public boolean insertCustomer(CustomerDTO cDto) {
		
		List<String> newCustomerMobileNumberList = cDto.getMobileNumbers();
		List<Customer> CustomerList = customerDao.findAll();
		List<MobileNumber> MobileNumbersList = new ArrayList<>();
		for(Customer existingCustomer : CustomerList)
		{
			
			MobileNumbersList.addAll(existingCustomer.getMobileNumbers()); 
		}
				
		for(String newNumber : newCustomerMobileNumberList)
		{
			for(MobileNumber existingNumber : MobileNumbersList)
			{
				
				if(newNumber.equals(existingNumber.toString()))
				{
					
					return false;
				}
			}
		}
		
		Customer newCustomer = new Customer(cDto.getFirstName(), cDto.getLastName());
		List<MobileNumber> newMobile = new ArrayList<>();


		
		for(String mobileNumber : cDto.getMobileNumbers())
		{
			newMobile.add(new MobileNumber(mobileNumber, newCustomer));
		}


		
		newCustomer.setMobileNumbers(newMobile);
		customerDao.save(newCustomer);
		return true;
	}

	@Override
	public boolean deleteCustomer(String mobileNo) {
		List<CustomerDTO> cDto =  getCustomers(null, null, mobileNo);
		if(cDto != null)
		{
			Customer newCustomer = new Customer(cDto.get(0).getFirstName(), cDto.get(0).getLastName());
			List<MobileNumber> newMobileNumbers = new ArrayList<>();
			
			
			
			for(String mobilenumber : cDto.get(0).getMobileNumbers())
			{
				newMobileNumbers.add(new MobileNumber(mobilenumber, newCustomer));
			}
			
			newCustomer.setMobileNumbers(newMobileNumbers);
			customerDao.delete(newCustomer);
			return true;
		}
		else
		{			
			return false;
		}
		
	}

	


	

}
