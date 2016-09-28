package com.easyshop.order.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.easyshop.order.clientlib.customer.CustomerClient;
import com.easyshop.order.clientlib.product.ProductClient;
import com.easyshop.order.dao.OrderRepository;
import com.easyshop.order.entity.ProductOrder;

@Service
//@ConfigurationProperties("myyml")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class OrderService {

    @Value("${myproperty}")
	String value;
	
    @Value("${myyml2.sub}")
    String value2;
    
    private List<String> servers = new ArrayList<String>();

    @Autowired
    private OrderRepository orderRepository;
    
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public ProductOrder createOrder(){
	    /*System.out.println(value2);
		for (String string : servers) {
			System.out.println("@@"+string);
		}*/
    	ProductOrder order=new ProductOrder();
    	orderRepository.save(order);
		
    	if (order.getId() == 4L) {
            throw new RuntimeException("Roll me back!");
        }
    	
    	return order;
	}
    
    public String testConfig1(Integer type){
    	switch (type) {
		case 1:
			return  value;
		case 2:
			return  value2;

		default:
			break;
		}
    	
    	return "null";
    }

	public List<String> getServers() {
		return servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}
	
	
}
