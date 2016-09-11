package com.easyshop.product.entity;

import org.springframework.data.annotation.Id;

public class Product {
	@Id
    public String id;

	public String productId;
	
	public String productName;
	
	public Integer price;
  
    public Product(String productId,String productName,Integer price){
    	this.productId=productId;
    	this.productName=productName;
    	this.price=price;
    }
    
}
