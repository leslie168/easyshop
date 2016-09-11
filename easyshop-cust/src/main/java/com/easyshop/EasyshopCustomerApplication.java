package com.easyshop;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.easyshop.customer.dao.CustomerRepository;
import com.easyshop.customer.entity.Customer;



@SpringBootApplication
@EnableEurekaClient
public class EasyshopCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyshopCustomerApplication.class, args);
		
	}
	@Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
        	customerRepository.deleteAll();

        	Customer leslie=new Customer("leslie","Leslie Lain","男","1988/5/5","桃園中壢","0911222333");
        	customerRepository.save(leslie);
           
        };
    }
}
