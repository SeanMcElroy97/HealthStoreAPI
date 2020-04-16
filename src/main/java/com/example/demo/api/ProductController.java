package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.Review;
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
	
	@PostMapping("/createProductTest")
	public String testCreateProduct() {
		
		Product p = new Product("fakeTitle", "fakeManufacturer", 99.99, "CategoryZ", "imageLinkHere");
		//mProductService.createProduct(p);
		return p.toString();
		
	}
	
	@PostMapping("/createReviewTest")
	public String testAddComment() {
		//find Product
		Product foundProduct = mProductService.findProductByID(2).get();
		foundProduct.addReview(new Review("What a great product", 4));
		//mProductService.updateProduct(foundProduct);
		return foundProduct.toString();
	}
}
