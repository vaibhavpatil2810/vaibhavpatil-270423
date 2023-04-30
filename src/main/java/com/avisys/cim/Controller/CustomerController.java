package com.avisys.cim.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	CustomerService CService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers(@RequestParam(required = false) String firstName,
														@RequestParam(required = false) String lastName,
														@RequestParam(required = false) String mobileNumber)
	{
		List<Customer> CList = CService.getCustomers(firstName, lastName, mobileNumber); 
		if(CList != null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(CList);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	

	

	
}
