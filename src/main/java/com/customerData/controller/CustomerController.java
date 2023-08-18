package com.customerData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerData.model.Customer;
import com.customerData.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository csr;
	
	@GetMapping("/create-user")
	public String createCustomer() {
		Customer c= new Customer();
		c.setName("Prince");
		c.setEmail("prince@gmail.com");
		
		csr.save(c);
		return "records created";
	}
	
}
