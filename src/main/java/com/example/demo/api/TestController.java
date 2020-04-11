package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LineItem;
import com.example.demo.model.Product;
import com.example.demo.repositories.LineItemRepo;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	ProductService mProductService;
	
	@Autowired
	LineItemRepo mLineItemRepo;
	
	
	
	
	
	@GetMapping("/yup")
	public String yup() {
		System.out.println("yup reached");
		return "Danone";
	}
	
	
	//TEST PASSED
	@PostMapping("/createItem")
	public String testCreateProduct(@RequestBody LineItem lineItem) {
		
		//Product p = new Product("fakeTitle", "fakeManufacturer", 99.99, "CategoryZ", "imageLinkHere");
		//mProductService.createProduct(newProd);
		
		if(mLineItemRepo.existsLineItemByProductTitleIgnoreCase(lineItem.getProduct().getTitle())) {
			return "Product with same title exists" ;
		}else {
			mLineItemRepo.save(lineItem);
		}
		
		
		
		return lineItem.toString();
		
	}
	
	
	
}
