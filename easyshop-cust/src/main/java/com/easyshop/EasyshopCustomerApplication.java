package com.easyshop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.easyshop.customer.dao.ContactRepository;
import com.easyshop.customer.dao.CustomerRepository;
import com.easyshop.customer.entity.Contact;
import com.easyshop.customer.entity.Customer;



@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
public class EasyshopCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyshopCustomerApplication.class, args);
		
	}
	@Bean
    CommandLineRunner init(CustomerRepository customerRepository,ContactRepository contactRepository) {
        return args -> {
        	customerRepository.deleteAll();

        	Customer leslie=new Customer("leslie","Leslie Lain","男","1988/5/5","桃園中壢","0911222333");
        	customerRepository.save(leslie);
        	
        	Contact cat=new Contact();
        	cat.name="test";
        	Map<String, String> data=new HashMap<String, String>();
        	data.put("1", "leslie");
        	data.put("2", "hello");
        	//cat.contactMethods=data;
        	contactRepository.save(cat);
           
        };
    }
}
