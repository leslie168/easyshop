package com.easyshop.order.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.easyshop.order.clientlib.customer.CustomerClient;
import com.easyshop.order.clientlib.product.ProductClient;

public class OrderService {
    @Autowired
    private CustomerClient customerClient;
    
    @Autowired
    private ProductClient productClient;
	
	public void createOrder(String userId,String pid){
		customerClient.getCustomerViewByUserId(userId);
		productClient.getProductViewByUserId(pid);
		//....do create order
		
	}
}
