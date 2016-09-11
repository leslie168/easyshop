package com.easyshop.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.easyshop.order.entity.ProductOrder;




public interface OrderRepository extends JpaRepository<ProductOrder, Long>{
	 
	  //  Customer findById(Long id);
	  //  Customer findByUserId(String userId);
}
