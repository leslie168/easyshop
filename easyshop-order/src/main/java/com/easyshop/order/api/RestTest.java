package com.easyshop.order.api;


import com.easyshop.order.clientlib.customer.CustomerClient;
import com.easyshop.order.clientlib.customer.CustomerView;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Collection;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RestTest {

    @Autowired
    private CustomerClient customerClient;

   
    @RequestMapping(value = "/custview/{userId}", method = RequestMethod.GET)
    CustomerView getCustomerViewByUserId(@PathVariable String userId) {
        return this.customerClient.getCustomerViewByUserId(userId);
    }

    
}
