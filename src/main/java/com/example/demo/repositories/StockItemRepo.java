package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LineItem;
import com.example.demo.model.StockItem;

public interface StockItemRepo extends JpaRepository<StockItem, Integer>{
	
	boolean existsStockItemByProductTitleIgnoreCase(String productTitle);
	
	StockItem findStockItemByProductTitle(String productTitle);

}
