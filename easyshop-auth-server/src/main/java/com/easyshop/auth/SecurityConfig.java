package com.easyshop.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.easyshop.auth.service.CustomAuthenticationProvider;
import com.easyshop.auth.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	//@Autowired
   // private CustomAuthenticationProvider customAuthenticationProvider;
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	 @Autowired
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	       // auth.authenticationProvider(this.customAuthenticationProvider);
		 auth.userDetailsService(customUserDetailService);
	    }
}
