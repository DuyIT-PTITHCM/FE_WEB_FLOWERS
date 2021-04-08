package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.AdminFlower;

public interface AdminFlowerResository  extends JpaRepository<AdminFlower, Integer>{
	 AdminFlower findByUsername(String username);
}
