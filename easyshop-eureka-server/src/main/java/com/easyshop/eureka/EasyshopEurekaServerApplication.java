package com.easyshop.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EasyshopEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyshopEurekaServerApplication.class, args);
	}
}
