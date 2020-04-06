package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repositories.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepository;
	
	public String createNewCustomerEntity(Customer c){
		if (customerRepository.existsCustomerByEmailIgnoreCase(c.getEmail())) {
			return "User with same email exists";
		}else {
			customerRepository.save(c);
			return "success";
		}
	}
	

}
