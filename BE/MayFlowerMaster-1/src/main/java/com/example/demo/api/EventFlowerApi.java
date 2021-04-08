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

import com.example.demo.dto.EventFlowerDTO;
import com.example.demo.service.EventFlowerService;

@RestController
@RequestMapping("/api/event")
public class EventFlowerApi {

	@Autowired
	private EventFlowerService eventFlowerService;
	
	@PostMapping
	public boolean addEventFlower(@RequestBody EventFlowerDTO eventFlowerDTO) {
		if(eventFlowerService.addEventFlower(eventFlowerDTO)) {
			return true;
		}
		return false;
	}
	@GetMapping
	public List<EventFlowerDTO> getAllEvent(){
		return eventFlowerService.getAllEvent();
	}
	@PutMapping
	public boolean editEventFlower(@RequestBody EventFlowerDTO eventFlowerDTO) {
		if(eventFlowerService.editEventFlower(eventFlowerDTO)) {
			return true;
		}
		return false;
	}
	@DeleteMapping
	public boolean deleteEventFlower(@RequestBody List<EventFlowerDTO> listEventFlowerDTO) {
		int count = 0;
		for (EventFlowerDTO eventFlowerDTO : listEventFlowerDTO) {
			if(eventFlowerService.deleteEventFlower(eventFlowerDTO)) {
				count++;
			}
		}
		if(count==0) {
			return false;
		}
		return true;
	}
	
}
