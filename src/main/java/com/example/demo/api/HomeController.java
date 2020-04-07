package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repositories.CustomerRepo;
import com.example.demo.services.CustomerService;

@RestController("/")
public class HomeController {
	
	@Autowired
	CustomerService mCustomerService;
	
	@GetMapping
	public String homeTest() {
		return "Home controller reached";
	}
	
	@GetMapping("/dos")
	public String testDos() {
		return "reached dos";
	}
	
	@PostMapping("/newcust")
	public String testcreateNewCustomer() {
		Customer cust = new Customer("jj@email", "password", "21 whitehouse avenue", "12345678");
		return mCustomerService.createNewCustomerEntity(cust);
		 
	}

}
