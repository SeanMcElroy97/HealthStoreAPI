package com.example.demo.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.LineItem;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.authentication.AuthenticationRequest;
import com.example.demo.repositories.LineItemRepo;
import com.example.demo.services.CustomerService;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ProductService mProductService;
	
	@Autowired
	LineItemRepo mLineItemRepo;
	

	@GetMapping("")
	public String test() {
		return "test admin reached";
	}
	
	@PostMapping("/createProduct")
	public String createProduct(@RequestBody Product newProd) {
		
		//Product p = new Product("fakeTitle", "fakeManufacturer", 99.99, "CategoryZ", "imageLinkHere");
		mProductService.createProduct(newProd);
		return newProd.toString();
		
	}
	
	@PostMapping("/createItem")
	public LineItem createProduct(@RequestBody LineItem lineItem) {
		
		//Product p = new Product("fakeTitle", "fakeManufacturer", 99.99, "CategoryZ", "imageLinkHere");
		//mProductService.createProduct(newProd);
		
		if(mLineItemRepo.existsLineItemByProductTitleIgnoreCase(lineItem.getProduct().getTitle())) {
			
		}else {
			mLineItemRepo.save(lineItem);
		}
		return lineItem;
	}

}
