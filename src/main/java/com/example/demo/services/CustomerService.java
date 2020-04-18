package com.example.demo.services;

import java.util.ArrayList;

import javax.sound.sampled.Line;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.LineItem;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.model.StockItem;
import com.example.demo.repositories.CustomerRepo;

import net.bytebuddy.asm.Advice.Return;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepository;
	
	@Autowired
	ProductService productService;
	
	public boolean createNewCustomerEntity(Customer c){
		if (customerRepository.existsCustomerByEmailIgnoreCase(c.getEmail())) {
			return false;
		}else {
			customerRepository.save(c);
			return true;
		}
	}
	
	
	public String createOrder(ArrayList<LineItem> lineItems, String custEmail) {
		
		
		
		
		for(LineItem li: lineItems) {
			System.out.println("Line Item qty : " + li.getQuantity());
			StockItem  st = productService.findStockItemByProductTitle(li.getProduct().getTitle());
			System.out.println("stock of this item held " + st.getQtyHeld());
			if (st.tryAdjustStock(li.getQuantity()) == false) {
				return "Couldnt create order not enough stock";
			}
		}
		
		//return "DUH";
		Customer c = customerRepository.findByEmail(custEmail).get();
//		
		PurchaseOrder custOrder = new PurchaseOrder(lineItems);
//		
		c.addOrder(custOrder);
	customerRepository.save(c);
//		
		return "Order created";
	}
	

}
