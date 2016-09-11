package com.easyshop.product.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.easyshop.product.dao.ProductRepository;
import com.easyshop.product.entity.Product;


@RestController
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    Product getProductByUserId(@PathVariable String productId) {
    	
        return this.productRepository.findByProductId(productId);
    }
	
}
