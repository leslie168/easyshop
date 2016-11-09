package com.easyshop.auth;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyshop.auth.dao.UserRepository;
import com.easyshop.auth.model.ShopRole;
import com.easyshop.auth.model.ShopUser;


@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class AuthserverApplication{

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthserverApplication.class, args);
	}

	
	@Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
        	userRepository.deleteAll();

        	ShopRole userRole=new ShopRole("ROLE_USER");
        	ShopRole adminRole=new ShopRole("ROLE_ADMIN");
        	
        	ShopUser john=new ShopUser("john","test123");
        	ShopUser mary=new ShopUser("mary","test123");
        	
        	
        	
        	john.getRoles().add(userRole);
        	userRole.getUsers().add(john);
        	
        	mary.getRoles().add(adminRole);
        	adminRole.getUsers().add(mary);
        	
        	userRepository.save(john);
        	userRepository.save(mary);
        	
        	
        
           
        };
    }

   
    
    

}
