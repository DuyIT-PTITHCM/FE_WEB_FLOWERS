package com.example.demo.conveters;

import org.springframework.stereotype.Component;

import com.example.demo.dto.StoryFlowerDTO;
import com.example.demo.entity.StoryFlower;

@Component
public class StoryFlowerConveter {

	public boolean storyDTOToStory(StoryFlowerDTO storyFlowerDTO , StoryFlower storyFlower) {
		boolean flag= true;
		try {
			if(storyFlowerDTO.getIdstory() !=0) {
				storyFlower.setIdstory(storyFlowerDTO.getIdstory());
				storyFlower.setName(storyFlowerDTO.getName());
				storyFlower.setStory(storyFlowerDTO.getStory());
				storyFlower.setImg(storyFlowerDTO.getImg());
				storyFlower.setDateupdate(storyFlowerDTO.getDateupdate());
			}else {
				storyFlower.setName(storyFlowerDTO.getName());
				storyFlower.setStory(storyFlowerDTO.getStory());
				storyFlower.setImg(storyFlowerDTO.getImg());
				storyFlower.setDateupdate(storyFlowerDTO.getDateupdate());
			}
			
		} catch (Exception e) {
			flag= false;
		}
		return flag;
	}
	public boolean storyToStoryDTO(StoryFlowerDTO storyFlowerDTO , StoryFlower storyFlower) {
		boolean flag= true;
		try {
			storyFlowerDTO.setIdstory(storyFlower.getIdstory());
			storyFlowerDTO.setName(storyFlower.getName());
			storyFlowerDTO.setStory(storyFlower.getStory());
			storyFlowerDTO.setImg(storyFlower.getImg());
			storyFlowerDTO.setDateupdate(storyFlower.getDateupdate());
		} catch (Exception e) {
			flag= false;
		}
		return flag;
	}
}
