package com.project.events.service;

import java.util.List;

import com.project.events.entity.Events;

public interface EventsService {

	public void delete(Events event);

	public List<Events> findAll();

	Events findById(Long id);

	public Events save(Events event);

	List<Events> findByUserId(Long userId);

	List<Events> findByVenueId(Long venueId);

}
