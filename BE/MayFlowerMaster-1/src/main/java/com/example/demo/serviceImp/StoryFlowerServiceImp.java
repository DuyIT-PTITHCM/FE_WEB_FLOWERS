package com.example.demo.serviceImp;

import java.util.List;

import com.example.demo.dto.StoryFlowerDTO;

public interface StoryFlowerServiceImp {

	public boolean addStoryFlower(StoryFlowerDTO storyFlowerDTO);
	public boolean deleteStoryFlower(int idStory);
	public boolean editStoryFlower(StoryFlowerDTO storyFlowerDTO);
	public List<StoryFlowerDTO> getAllStoryFLower();
	public StoryFlowerDTO getStoryFlower(int idStory);
}
