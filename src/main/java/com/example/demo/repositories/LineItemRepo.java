package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LineItem;
import com.example.demo.model.StockItem;

public interface LineItemRepo extends JpaRepository<LineItem, Integer>{
	
	boolean existsLineItemByProductTitleIgnoreCase(String titleName);
	
	List<LineItem> findLineItemsByCustomerEmail(String email);

}
