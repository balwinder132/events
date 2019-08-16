package com.project.events.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.events.entity.Venue;
import com.project.events.repository.VenueRepository;
import com.project.events.service.VenueService;

@Service
public class VenueServiceImpl implements VenueService{

	@Autowired
	private VenueRepository venueRepository;

	@Override
	public void delete(Venue venue) {
		venueRepository.delete(venue);
	}

	@Override
	public List<Venue> findAll() {
		return venueRepository.findAll();
	}

	@Override
	public Venue findById(Long id) {
		return venueRepository.findById(id).get();
	}

	@Override
	public Venue save(Venue venue) {
		return venueRepository.save(venue);
	}
	
	
}
