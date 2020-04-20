package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
//import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import com.example.demo.model.HealthShopUserDetails;
import com.example.demo.repositories.CustomerRepo;

@Service
public class HealthShopUserDetailsService implements UserDetailsService{
	
	@Autowired
	CustomerRepo customerRepo;

	
	//Method to get user details from jpa
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// call the jpa method for retrieving user
		
		if(email.equalsIgnoreCase("adminHealth")) {
//			System.out.println("AdminUser email hit");
			return new HealthShopUserDetails(new Admin());
		}
		
		if(customerRepo.existsCustomerByEmailIgnoreCase(email)) {
		Optional<Customer> userCustomer = customerRepo.findByEmail(email);
		return new HealthShopUserDetails(userCustomer.get());
		}else {
			throw new UsernameNotFoundException("Not found: " + email);
		}
	}

	
	
}
