package com.easyshop.product.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.easyshop.product.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

	public Product findByProductId(String productId);
	
}
