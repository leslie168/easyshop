package com.easyshop.customer.api;

import java.net.InetAddress;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easyshop.customer.dao.ContactRepository;
import com.easyshop.customer.dao.CustomerRepository;
import com.easyshop.customer.entity.Contact;
import com.easyshop.customer.entity.Customer;




@RestController
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private DiscoveryClient discoveryClient;
    
   // @Autowired
  //  private org.springframework.security.core.context.SecurityContextHolder SecurityContextHolder;
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    Customer getCustomerByUserId(@PathVariable String userId,Authentication authentication) {
   
    	
        return this.customerRepository.findByUserId(userId);
    }
    
 
    @RequestMapping("/uriinfo/{applicationName}")
    public String serviceInstancesByApplicationNameURI(
            @PathVariable String applicationName) {
    	List<ServiceInstance> list=this.discoveryClient.getInstances(applicationName);
    	if(list.size()>0)
         return list.get(0).getUri().toString();
    	
    	return "NA";
    }
	
}
