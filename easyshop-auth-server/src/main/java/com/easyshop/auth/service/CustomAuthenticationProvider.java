package com.easyshop.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	
	public CustomAuthenticationProvider(){
		
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		if(authentication.getName().equals("john")  && authentication.getCredentials().equals("test123")) {
	       
			
			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
	        grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	        UsernamePasswordAuthenticationToken token=  new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), grantedAuths);
	        
	       
	        return token;
	    } else {
	    	throw new BadCredentialsException("Wrong password.");
	    }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
