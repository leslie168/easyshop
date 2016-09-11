package com.easyshop.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    
    private String userId;
    
    private String name;

    private String gender;

    private String birthday;
    
    private String address;
    
    private String phoneNumber;

    public Customer(){
    	
    }
    
    
	public Customer(String userId, String name, String gender, String birthday, String address, String phoneNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    
    
}
