package com.easyshop.order.clientlib.product;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient("product-service")
public interface ProductClient {

	 @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	 ProductView getProductViewByUserId(@PathVariable("productId") String productId) ;
	
}
