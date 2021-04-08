package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StoryFlower;

public interface StoryFlowerRepository extends JpaRepository<StoryFlower, Integer> {
	public StoryFlower findOneByIdstory(int idStory);
}
