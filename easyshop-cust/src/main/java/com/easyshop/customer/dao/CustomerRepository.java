package com.easyshop.customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyshop.customer.entity.Customer;




public interface CustomerRepository extends JpaRepository<Customer, Long>{
	 
	    Customer findById(Long id);
	    Customer findByUserId(String userId);
}
