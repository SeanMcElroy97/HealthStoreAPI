package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
 Optional<Customer> findByEmail(String email);
 
 boolean existsCustomerByEmailIgnoreCase(String email);

 

}
