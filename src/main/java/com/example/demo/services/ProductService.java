package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LineItem;
import com.example.demo.model.Product;
import com.example.demo.model.StockItem;
import com.example.demo.repositories.LineItemRepo;
import com.example.demo.repositories.ProductRepo;
import com.example.demo.repositories.StockItemRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepository;
	
	@Autowired
	StockItemRepo mStockRepo;
	
	public String createStockItem(Product p, int initialQty) {
		
		System.out.println(p.toString());
		System.out.println(initialQty);
		//
		StockItem newItem = new StockItem(p, initialQty);
		if(stockItemAlreadyExists(newItem)==false) {
			mStockRepo.save(newItem);
			return "Successfully created product ";
		}
		
		return "Couldnt create product. Product already exists";
	}
	
	public boolean stockItemAlreadyExists(StockItem StockItem) {
		if(mStockRepo.existsStockItemByProductTitleIgnoreCase(StockItem.getProduct().getTitle())){
			return true;
		}
		return false;
	}
	
	public void updateProductDetails(Product p) {
		productRepository.save(p);
	}
	
	public StockItem findStockItemByProductTitle(String pTitle) {
		return mStockRepo.findStockItemByProductTitle(pTitle);
	}
	
	public Optional<Product> findProductByID(int pid) {
		return productRepository.findById(pid);
	}
	
	public String AdjustProductStock(int stockItemID, int qtyToAdjustBy) {
		
	
		if(mStockRepo.existsById(stockItemID)) {
			StockItem stItem = mStockRepo.findById(stockItemID).get();
			
			boolean enoughStock = stItem.tryAdjustStock(qtyToAdjustBy);
			
			if(enoughStock == false) {
				return "Dont'have enough stock to make adjustment";
			}else {
				//StockItem reduces stock itself
				mStockRepo.save(stItem);
				return "Successfully adjusted stock";
			}
	}
		return "failed to adjust stock";
	
	}
	
	
	public List<StockItem> retrieveAllSTock(){
		return mStockRepo.findAll();
		
	}
}
