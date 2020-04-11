package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LineItem;

public interface LineItemRepo extends JpaRepository<LineItem, Integer>{
	
	boolean existsLineItemByProductTitleIgnoreCase(String titleName);

}
