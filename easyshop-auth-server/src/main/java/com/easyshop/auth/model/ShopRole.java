package com.easyshop.auth.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class ShopRole {

    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private long id;  
  
    private String role;  
  
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)  
    private Set<ShopUser> users=new HashSet<ShopUser>();

    
    
    
	public ShopRole(String role) {
		super();
		this.role = role;
	}

	public ShopRole() {
		super();
		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<ShopUser> getUsers() {
		return users;
	}

	public void setUsers(Set<ShopUser> users) {
		this.users = users;
	}  
    
    
}
