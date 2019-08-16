package com.project.events.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.events.entity.Events;
import com.project.events.repository.EventsRepository;
import com.project.events.service.EventsService;

@Service
public class EventsServiceImpl implements EventsService {

	@Autowired
	private EventsRepository eventsRepository;

	@Override
	public void delete(Events event) {
		eventsRepository.delete(event);
	}

	@Override
	public List<Events> findAll() {

		return eventsRepository.findAll();
	}

	@Override
	public Events findById(Long id) {
		return eventsRepository.findById(id).get();
	}

	@Override
	public Events save(Events event) {
		return eventsRepository.save(event);
	}

	@Override
	public List<Events> findByUserId(Long userId) {
		return eventsRepository.findByUserId(userId);
	}

	@Override
	public List<Events> findByVenueId(Long venueId) {
		return eventsRepository.findByVenueId(venueId);
	}
	
}
