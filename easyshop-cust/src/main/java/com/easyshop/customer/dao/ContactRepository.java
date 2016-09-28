package com.easyshop.customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyshop.customer.entity.Contact;
import com.easyshop.customer.entity.Customer;




public interface ContactRepository extends JpaRepository<Contact, Long>{
	 
	Contact findById(Long id);
	
}
