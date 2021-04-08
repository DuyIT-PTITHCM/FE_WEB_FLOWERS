package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Flower;

public interface FlowerRepository extends JpaRepository<Flower, Integer>{

	public Flower findOneByIdflower(int idflower);
}
