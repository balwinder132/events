package com.project.events.service;

import java.util.List;

import com.project.events.entity.EventsUser;

public interface UserService {

	public void delete(EventsUser user);
	
	public List<EventsUser> findAll();
	
	EventsUser findById(Long id);
	
	public EventsUser save(EventsUser user);
	
	EventsUser findByEmail(String email);
}
