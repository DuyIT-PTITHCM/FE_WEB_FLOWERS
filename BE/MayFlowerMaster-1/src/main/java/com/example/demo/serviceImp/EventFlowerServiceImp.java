package com.example.demo.serviceImp;

import java.util.List;

import com.example.demo.dto.EventFlowerDTO;

public interface EventFlowerServiceImp {

	public boolean addEventFlower(EventFlowerDTO eventFlowerDTO);
	public boolean editEventFlower(EventFlowerDTO eventFlowerDTO);
	public boolean deleteEventFlower(EventFlowerDTO eventFlowerDTO);
	public List<EventFlowerDTO> getAllEvent();
	public EventFlowerDTO getEventFlowerDTO(int idEvent);
}
