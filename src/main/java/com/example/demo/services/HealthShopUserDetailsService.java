package com.example.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.HealthShopUserDetails;

@Service
public class HealthShopUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// call the jpa method for retrieving user
		return new HealthShopUserDetails(email);
	}

	
	
}
