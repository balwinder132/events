package com.project.events.service;

import java.util.List;

import com.project.events.entity.Venue;

public interface VenueService {

	public void delete(Venue venue);
	
	public List<Venue> findAll();
	
	Venue findById(Long id);
	
	public Venue save(Venue venue);
}
