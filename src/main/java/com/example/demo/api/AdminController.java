package com.example.demo.api;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.LineItem;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.model.StockItem;
import com.example.demo.model.Product;
import com.example.demo.model.authentication.AuthenticationRequest;
import com.example.demo.repositories.LineItemRepo;
import com.example.demo.repositories.StockItemRepo;
import com.example.demo.services.CustomerService;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	ProductService mProductService;
	
	@Autowired
	StockItemRepo mStockItemRepo;
	

	@GetMapping("")
	public String test() {
		return "test admin reached";
	}
	
	
	@GetMapping("/test2")
	public String testsecund(){
		return "secund test reached";
	}
	
	
	@PostMapping("/add")
	public String createProduct(@RequestBody StockItem stItem) {
		
//		System.out.println(stItem.toString());
		
		
		
		if (!mStockItemRepo.existsStockItemByProductTitleIgnoreCase(stItem.getProduct().getTitle())) {
			return mProductService.createStockItem(stItem.getProduct(), stItem.getQtyHeld());	
		}
		
		return null;
		
		
	}
	
	@PostMapping("/updateStock")
	public List<StockItem> createProducty(@RequestBody List<StockItem> updatedStock) {
			
		mStockItemRepo.saveAll(updatedStock);
	return updatedStock;
			
	}
	
	
	@GetMapping("/all")
	public List<StockItem> retrieveAll(){
		return mProductService.retrieveAllStock();
	}

}
