package com.easyshop.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.easyshop.product.dao.ProductRepository;
import com.easyshop.product.entity.Product;


@SpringBootApplication
@EnableEurekaClient
public class EasyshopProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyshopProductApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(ProductRepository productRepository) {
        return args -> {
        	productRepository.deleteAll();

        	Product p1=new Product("LV01","LV包包",3000);
        	productRepository.save(p1);
           
        };
    }
}
