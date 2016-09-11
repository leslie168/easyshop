package com.easyshop.order.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easyshop.order.service.OrderService;



@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

  
	
}
