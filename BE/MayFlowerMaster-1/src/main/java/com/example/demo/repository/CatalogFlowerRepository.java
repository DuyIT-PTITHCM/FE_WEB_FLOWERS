package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CatalogFlower;

public interface CatalogFlowerRepository extends JpaRepository<CatalogFlower, Integer> {
	public CatalogFlower findOneByIdcatalog(int idcatalog);
}
