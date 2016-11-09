package com.easyshop.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.easyshop.auth.dao.UserRepository;
import com.easyshop.auth.model.ShopRole;
import com.easyshop.auth.model.ShopUser;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component
public class CustomUserDetailService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailService.class);  
	
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {  
            ShopUser user = userRepository.findByUsername(username);  
            if (user == null) {  
                LOGGER.debug("user not found with the provided username");  
                return null;  
            }  
            LOGGER.debug(" user from username " + user.toString());  
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));  
        }  
        catch (Exception e){  
            throw new UsernameNotFoundException("User not found");  
        }  
	}
	
	 private Set<GrantedAuthority> getAuthorities(ShopUser user){  
	        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();  
	        for(ShopRole role : user.getRoles()) {  
	            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());  
	            authorities.add(grantedAuthority);  
	        }  
	        LOGGER.debug("user authorities are " + authorities.toString());  
	        return authorities;  
	    }  

}
