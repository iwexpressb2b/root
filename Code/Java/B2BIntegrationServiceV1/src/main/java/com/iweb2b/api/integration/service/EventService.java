package com.iweb2b.api.integration.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iweb2b.api.integration.model.tracking.AddEvent;
import com.iweb2b.api.integration.model.tracking.Event;
import com.iweb2b.api.integration.model.tracking.UpdateEvent;
import com.iweb2b.api.integration.repository.EventRepository;
import com.iweb2b.api.integration.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	public List<Event> getEvent () {
		List<Event> eventList =  eventRepository.findAll();
		eventList = eventList.stream().filter(n -> n.getDeletionIndicator() == 0).collect(Collectors.toList());
		return eventList;
	}
	
	/**
	 * getEvent
	 * @param id
	 * @return
	 */
	public Event getEvent (Long id) {
//		Optional<Event> event = eventRepository.findByIdAndDeletionIndicator(id, 0L);
//		if (event.isEmpty()) {
//			return null;
//		}
//		return event.get();
		return null;
	}
	
	/**
	 * createEvent
	 * @param newEvent
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Event createEvent (AddEvent newEvent, String loginUserId) 
			throws IllegalAccessException, InvocationTargetException, Exception {

		Event dbEvent = new Event();
		BeanUtils.copyProperties(newEvent, dbEvent, CommonUtils.getNullPropertyNames(newEvent));
		dbEvent.setDeletionIndicator(0L);
		dbEvent.setCreatedBy(loginUserId);
		dbEvent.setUpdatedBy(loginUserId);
		dbEvent.setCreatedOn(new Date());
		dbEvent.setUpdatedOn(new Date());
		return eventRepository.save(dbEvent);
	}
	
	/**
	 * updateEvent
	 * @param id
	 * @param loginUserId 
	 * @param updateEvent
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Event updateEvent (Long id, String loginUserId, UpdateEvent updateEvent)
			throws IllegalAccessException, InvocationTargetException {
		Event dbEvent = getEvent(id);
		BeanUtils.copyProperties(updateEvent, dbEvent, CommonUtils.getNullPropertyNames(updateEvent));
		dbEvent.setUpdatedBy(loginUserId);
		dbEvent.setUpdatedOn(new Date());
		return eventRepository.save(dbEvent);
	}
	
	/**
	 * deleteEvent
	 * @param loginUserID 
	 * @param id
	 */
	public void deleteEvent (Long id, String loginUserID) {
		Event event = getEvent(id);
		if (event != null) {
			event.setDeletionIndicator(1L);
			event.setUpdatedBy(loginUserID);
			event.setUpdatedOn(new Date());
			eventRepository.save(event);
		} else {
			throw new EntityNotFoundException("Error in deleting Id: " + id);
		}
	}
}
