package com.example.demo.conveters;

import org.springframework.stereotype.Component;

import com.example.demo.dto.EventFlowerDTO;
import com.example.demo.entity.EventFlower;

@Component
public class EventFlowerConveters {

	public boolean eventDTOToEvent(EventFlowerDTO eventFlowerDTO , EventFlower eventFlower) {
		boolean flag= true;
		try {
			if(eventFlowerDTO.getIdevent() != 0) {
				eventFlower.setPercentdow(eventFlowerDTO.getPercentdow());
				eventFlower.setIdevent(eventFlowerDTO.getIdevent());
			}else {
				eventFlower.setPercentdow(eventFlowerDTO.getPercentdow());
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean eventToEventDTO(EventFlowerDTO eventFlowerDTO , EventFlower eventFlower) {
		boolean flag= true;
		try {
			eventFlowerDTO.setPercentdow(eventFlower.getPercentdow());
			eventFlowerDTO.setIdevent(eventFlower.getIdevent());
			
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
