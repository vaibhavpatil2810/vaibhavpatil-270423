package com.avisys.cim.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Service.CustomerService;
import com.avisys.cim.beans.Customer;
import com.avisys.cim.beans.CustomerDTO;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	CustomerService CService;
	
	
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers(@RequestParam(required = false) String firstName,
															@RequestParam(required = false) String lastName,
															@RequestParam(required = false) String mobileNumber) {
		List<CustomerDTO> customerDTOs= CService.getCustomers(firstName,lastName,mobileNumber);
	    
	  
	    
	    return ResponseEntity.ok(customerDTOs);
	}
	
//	@PostMapping("/customers")
//	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer c)
//	{
//		boolean status=CService.addCustomer(c);
//		if(status)
//		{
//			return new ResponseEntity("Unable to create Customer. Mobile number already present.",HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		else
//		{
//			return new ResponseEntity("Customer added successfully", HttpStatus.CREATED);
//		}
//	}
	
//	@PostMapping("/addnewcustomer")
//	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer)
//	{
//		Customer c = CService.addNewCustomer(customer);
//		if(c == null)
//		{
//			return new ResponseEntity("Unable to create Customer. Mobile number already present.",HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		else 
//		{
//			return new ResponseEntity("Customer added successfully", HttpStatus.CREATED);
//		}
//	}
	
}
