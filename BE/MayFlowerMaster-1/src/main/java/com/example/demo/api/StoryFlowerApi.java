package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StoryFlowerDTO;
import com.example.demo.service.StoryFlowerService;

@RestController
@RequestMapping("/api/storyflower")
public class StoryFlowerApi {

	@Autowired
	private StoryFlowerService storyFlowerService;
	
	@PostMapping
	public boolean addStory(@RequestBody StoryFlowerDTO storyFlowerDTO) {
		if(storyFlowerService.addStoryFlower(storyFlowerDTO)) {
			return true;
		}
		return false;
	}
	@DeleteMapping
	public boolean deleteStory(@RequestBody StoryFlowerDTO storyFlowerDTO) {
		if(storyFlowerService.deleteStoryFlower(storyFlowerDTO.getIdstory())) {
			return true;
		}
		return false;
	}
	@PutMapping
	public boolean editStory(@RequestBody StoryFlowerDTO storyFlowerDTO) {
		if(storyFlowerService.editStoryFlower(storyFlowerDTO)) {
			return true;
		}
		return false;
	}
	@GetMapping
	public List<StoryFlowerDTO> getAllStory() {
		return storyFlowerService.getAllStoryFLower();
	}
	
}
