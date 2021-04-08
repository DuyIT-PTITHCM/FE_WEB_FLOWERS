package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProductTopic;

public interface ProductTopicRepository extends JpaRepository<ProductTopic, Integer>{

	public ProductTopic findOneByIdtopic(int idTopic);
}
