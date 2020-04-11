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
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CustomerService mCustomerService;

	@GetMapping("")
	public String test() {
		return "test admin reached";
	}
	

}
