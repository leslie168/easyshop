package com.easyshop.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableResourceServer
@EnableTransactionManagement
//@EnableDiscoveryClient
public class EasyshopOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyshopOrderApplication.class, args);
	}
}
