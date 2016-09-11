package com.easyshop.customer.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easyshop.customer.dao.CustomerRepository;
import com.easyshop.customer.entity.Customer;


@RestController
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    Customer getCustomerByUserId(@PathVariable String userId) {
    	
        return this.customerRepository.findByUserId(userId);
    }
	
}
