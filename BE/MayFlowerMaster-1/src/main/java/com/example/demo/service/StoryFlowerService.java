package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conveters.StoryFlowerConveter;
import com.example.demo.dto.StoryFlowerDTO;
import com.example.demo.entity.StoryFlower;
import com.example.demo.repository.StoryFlowerRepository;
import com.example.demo.serviceImp.StoryFlowerServiceImp;

@Service
public class StoryFlowerService implements StoryFlowerServiceImp{
	@Autowired
	private StoryFlowerRepository storyFlowerRepository;
	@Autowired
	private StoryFlowerConveter storyFlowerConveter;
	@Override
	public boolean addStoryFlower(StoryFlowerDTO storyFlowerDTO) {
		StoryFlower storyFlower = new StoryFlower();
		if(storyFlowerConveter.storyDTOToStory(storyFlowerDTO, storyFlower)) {
			storyFlowerRepository.save(storyFlower);
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteStoryFlower(int idStory) {
		storyFlowerRepository.deleteById(idStory);
		return true;
	}
	@Override
	public boolean editStoryFlower(StoryFlowerDTO storyFlowerDTO) {
		StoryFlower storyFlower = new StoryFlower();
		if(storyFlowerConveter.storyDTOToStory(storyFlowerDTO, storyFlower)) {
			storyFlowerRepository.save(storyFlower);
			return true;
		}
		return false;
	}
	@Override
	public List<StoryFlowerDTO> getAllStoryFLower() {
		List<StoryFlower> list ;
		list = storyFlowerRepository.findAll();
		List<StoryFlowerDTO> listDTO = new ArrayList<StoryFlowerDTO>();
		for (StoryFlower storyFlower : list) {
			StoryFlowerDTO storyFlowerDTO = new StoryFlowerDTO();
			if(storyFlowerConveter.storyToStoryDTO(storyFlowerDTO, storyFlower)) {
				listDTO.add(storyFlowerDTO);
			}
		}
		return listDTO;
	}
	@Override
	public StoryFlowerDTO getStoryFlower(int idStory) {
		StoryFlower storyFlower = storyFlowerRepository.findOneByIdstory(idStory);
		StoryFlowerDTO storyFlowerDTO = new StoryFlowerDTO();
		storyFlowerConveter.storyToStoryDTO(storyFlowerDTO, storyFlower);
		return storyFlowerDTO;
	}
	
	
	
	

}
