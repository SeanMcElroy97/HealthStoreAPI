package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LineItem;
import com.example.demo.model.Product;
import com.example.demo.model.StockItem;
import com.example.demo.repositories.LineItemRepo;
import com.example.demo.services.CustomerService;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	ProductService mProductService;
	
	@Autowired
	CustomerService mCustomerService;
	
	@Autowired
	LineItemRepo mLineItemRepo;
	
	
	
	
	
	@GetMapping("/yup")
	public String yup() {
		System.out.println("yup reached");
		return "Danone";
	}
	
	
	@GetMapping("/Stock")
	public List<StockItem> getAllStock(){
		return mProductService.retrieveAllStock();
				
	}
	
	
	@GetMapping("/Stock/{title}")
	public StockItem getStockByProductTitle(@PathVariable("title") String pTitle){
		return mProductService.findStockItemByProductTitle(pTitle);
				
	}
	
	//TEST PASSED
	@PostMapping("/createItem")
	public String testCreateLineItem() {
		
		 Product p = new Product("fakeTitle", "fakeManufacturer", 99.99, "CategoryZ", "imageLinkHere");
		 Product p2 = new Product("tititle2", "fakerer", 69.99, "Cultery", "imageLinkHere");
		 StockItem stItem = new StockItem(p, 12);
		 StockItem stItem2 = new StockItem(p2, 13);
		 
		//mProductService.createProduct(newProd);
		 mProductService.createStockItem(stItem2.getProduct(), stItem2.getQtyHeld());
		return mProductService.createStockItem(stItem.getProduct(), 8);
		
		
		//System.out.println("HI");
		//return "hi 2";
		
		
	}
	
	@PutMapping("/stock/{StockItemID}/adjustStock{qty}")
	public void testAdjustProductStock(@PathVariable("StockItemID") int id , @PathVariable("qty") int qty) {
		
		//Product p = new Product("fakeTitle", "fakeManufacturer", 99.99, "CategoryZ", "imageLinkHere");
		//mProductService.createProduct(newProd);
		
		String result = mProductService.AdjustProductStock(id, qty);
				
	}
	
	@GetMapping("/placeOrder")
	public String getStockByProductTitle(){
		String custEmail = "jj@email";
		
		ArrayList<LineItem> lineItems = new ArrayList<>();
		
		lineItems.add(new LineItem(mProductService.findProductByID(2).get(), -3));
		lineItems.add(new LineItem(mProductService.findProductByID(1).get(), -4));
		return mCustomerService.createOrder(lineItems, custEmail);
				
	}
	
	
	
}
