package com.example.demo.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService mCustomerService;

	@GetMapping("/test")
	public String test() {
		return "test customer";
	}
	
	@GetMapping("/newtestcustomer/{email}")
	public String testcreateNewCustomer(@PathVariable("email") String email) {
		Customer cust = new Customer(email, "password", "21 whitehouse avenue", "12345678");
		return mCustomerService.createNewCustomerEntity(cust);
		 
	}
}
