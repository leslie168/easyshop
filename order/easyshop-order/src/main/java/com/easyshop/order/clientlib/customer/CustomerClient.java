package com.easyshop.order.clientlib.customer;


import com.netflix.hystrix.HystrixObservable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rx.Observable;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("customer-service")
public interface CustomerClient {



	 @RequestMapping(value = "/customer/{userId}", method = RequestMethod.GET)
	 CustomerView getCustomerViewByUserId(@PathVariable("userId") String userId) ;
	    

}
