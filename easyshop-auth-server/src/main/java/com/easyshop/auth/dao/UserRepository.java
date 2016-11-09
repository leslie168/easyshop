package com.easyshop.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyshop.auth.model.ShopUser;



public interface UserRepository extends JpaRepository<ShopUser, Long>{

	ShopUser findByUsername(String username);
}
