package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService mProductService;
	
	
	@GetMapping("/test")
	public String test(){
		return "hi";
	}
	
	@PostMapping("/createTest")
	public String testCreateProduct() {
		
		Product p = new Product("fakeTitle", "fakeManufacturer", 99.99, "CategoryZ", "imageLinkHere");
		mProductService.createProduct(p);
		return p.toString();
		
	}
}
