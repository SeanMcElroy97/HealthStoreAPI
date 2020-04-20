package com.example.demo.api;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.model.StockItem;
import com.example.demo.services.CustomerService;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	CustomerService mCustomerService;
	
	@Autowired
	ProductService mProductService;

	@GetMapping
	public String test() {
		System.out.println("cust method hit");
		return "test customer";
	}
	
	@GetMapping("/viewALLProducts")
	public List<StockItem> getAllStock(){
		return mProductService.retrieveAllStock();
	}
	

}
