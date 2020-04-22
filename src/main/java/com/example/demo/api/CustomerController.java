package com.example.demo.api;

import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.LineItem;
import com.example.demo.model.Product;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.model.StockItem;
import com.example.demo.repositories.LineItemRepo;
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
	
	@Autowired
	LineItemRepo mLineItemRepo;

	@GetMapping
	public String test() {
		System.out.println("cust method hit");
		return "test customer";
	}
	
	@GetMapping("/viewALLProducts")
	public List<StockItem> getAllStock(){
		return mProductService.retrieveAllStock();
	}
	
	
	@PostMapping("/addToBasket/{email}")
	public void addLineItemToBasket(@RequestBody LineItem item,  @PathVariable("email") String email){
		Customer c = mCustomerService.findByID(email);
		
		System.out.println(c.getEmail());
		Product p = mProductService.findProductByID(item.getProduct().getId()).get();
		c.addItemToCart(new LineItem(p, item.getQuantity()));
		mCustomerService.updateCustomer(c);
	}
	
	@RequestMapping("/customerById/{email}")
	public Customer getCustomerByID(@PathVariable("email") String email){
		return mCustomerService.findByID(email);
//		System.out.println(email);
	}
	
	
	@GetMapping("/customerShoppingCart/{email}")
	public List<LineItem> getShoppingBasket(@PathVariable("email") String email){
		Customer c = mCustomerService.findByID(email);
		
//		return mLineItemRepo.findLineItemsByCustomerEmail(email);
		return c.getShoppingCart();
	}
	
}
