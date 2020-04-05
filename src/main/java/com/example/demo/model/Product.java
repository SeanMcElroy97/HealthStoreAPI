package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String manufacturer;
	private double price;
	private String category;
	private String productImageLink;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Review> productReviews;
	
	
	//Constructors
	public Product() {
		super();
	}
	
	public Product(String title, String manufacturer, double price, String category, String productImageLink) {
		super();
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.productImageLink = productImageLink;
	}








	//Utility Methods for adding + removing reviews. synchronizes both sides
    public void addReview(Review review) {
    	productReviews.add(review);
    	review.setProduct(this);
    }
    

	public void removeReview(Review review) {
       productReviews.remove(review);
       review.setProduct(null);
    }
		
	
	//Getters + Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductImageLink() {
		return productImageLink;
	}
	public void setProductImageLink(String productImageLink) {
		this.productImageLink = productImageLink;
	}
	public Set<Review> getProductReviews() {
		return productReviews;
	}
	public void setProductReviews(Set<Review> productReviews) {
		this.productReviews = productReviews;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", manufacturer=" + manufacturer + ", price=" + price
				+ ", category=" + category + ", productImageLink=" + productImageLink + ", productReviews="
				+ productReviews + "]";
	}
	
	
	
}
