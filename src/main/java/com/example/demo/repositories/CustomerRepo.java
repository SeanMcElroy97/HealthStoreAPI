package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
// Customer findByEmail(String email);
 
 boolean existsCustomerByEmailIgnoreCase(String email);

}
