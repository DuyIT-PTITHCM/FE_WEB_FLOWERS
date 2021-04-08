package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conveters.EventFlowerConveters;
import com.example.demo.conveters.FlowerConveters;
import com.example.demo.dto.EventFlowerDTO;
import com.example.demo.dto.FlowerDTO;
import com.example.demo.entity.EventFlower;
import com.example.demo.entity.Flower;
import com.example.demo.repository.EventFlowerRepository;
import com.example.demo.repository.FlowerRepository;
import com.example.demo.serviceImp.EventFlowerServiceImp;

@Service
public class EventFlowerService implements EventFlowerServiceImp{
	@Autowired
	private EventFlowerRepository eventFlowerRepository;
	@Autowired
	private EventFlowerConveters eventFlowerConveters;
	@Autowired
	private FlowerConveters flowerConveters;
	@Autowired
	private FlowerRepository flowerRepository;
	
	@Override
	public boolean addEventFlower(EventFlowerDTO eventFlowerDTO) {
		EventFlower eventFlower = new EventFlower();
		if(eventFlowerConveters.eventDTOToEvent(eventFlowerDTO, eventFlower)) {
			Set<Flower> listFlower = new HashSet<Flower>();
			for (FlowerDTO flowerDTO : eventFlowerDTO.getList()) {
				Flower flower = flowerRepository.findOneByIdflower(flowerDTO.getIdflower());
				listFlower.add(flower);
			}
			eventFlower.setFlowers(listFlower);
			eventFlowerRepository.save(eventFlower);
			return true;
		}
		return false;
	}

	@Override
	public boolean editEventFlower(EventFlowerDTO eventFlowerDTO) {
		EventFlower eventFlower = new EventFlower();
		if(eventFlowerConveters.eventDTOToEvent(eventFlowerDTO, eventFlower)) {
			Set<Flower> listFlower = new HashSet<Flower>();
			for (FlowerDTO flowerDTO : eventFlowerDTO.getList()) {
				Flower flower = flowerRepository.findOneByIdflower(flowerDTO.getIdflower());
				listFlower.add(flower);
			}
			eventFlower.setFlowers(listFlower);
			eventFlowerRepository.save(eventFlower);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEventFlower(EventFlowerDTO eventFlowerDTO) {
		try {
			eventFlowerRepository.deleteById(eventFlowerDTO.getIdevent());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<EventFlowerDTO> getAllEvent() {
		
		List<EventFlowerDTO> listEventDTO = new ArrayList<EventFlowerDTO>();
		List<EventFlower> listEvent = eventFlowerRepository.findAll();
		for (EventFlower eventFlower : listEvent) {
			EventFlowerDTO eventFlowerDTO = new EventFlowerDTO();
			eventFlowerConveters.eventToEventDTO(eventFlowerDTO, eventFlower);
			List<FlowerDTO> listFlowerDTO = new ArrayList<FlowerDTO>();
			for (Flower flower : eventFlower.getFlowers()) {
				FlowerDTO flowerDTO = new FlowerDTO();
				flowerConveters.flowerToFlowerDTO(flowerDTO, flower);
				listFlowerDTO.add(flowerDTO);
			}
			eventFlowerDTO.setList(listFlowerDTO);
			listEventDTO.add(eventFlowerDTO);
		}
		
		return listEventDTO;
	}

	@Override
	public EventFlowerDTO getEventFlowerDTO(int idEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
