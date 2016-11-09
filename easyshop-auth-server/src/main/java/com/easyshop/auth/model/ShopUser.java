package com.easyshop.auth.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class ShopUser {

	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private long id;  
  
    private String username;  
  
    private String password;  
  
    private boolean enabled=true;  
  
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)  
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))  
    private Set<ShopRole> roles=new HashSet<ShopRole>();

    public ShopUser(){
    	
    }
    
    
	public ShopUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Set<ShopRole> getRoles() {
		return roles;
	}


	public void setRoles(Set<ShopRole> roles) {
		this.roles = roles;
	}



  
}
