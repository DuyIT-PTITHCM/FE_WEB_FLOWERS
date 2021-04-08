package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserByFlower;

public interface UserByFlowerRepository  extends JpaRepository<UserByFlower, Integer>{

	public List<UserByFlower> findAllByStatus(boolean status);
}
