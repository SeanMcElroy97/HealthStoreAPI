package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepository;
	
	
	public void createProduct(Product p) {
		productRepository.save(p);
	}
	
	public void updateProduct(Product p) {
		productRepository.save(p);
	}
	
}
