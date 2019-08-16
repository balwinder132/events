package com.project.events.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.events.entity.EventsUser;
import com.project.events.repository.EventsUserRepository;
import com.project.events.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private EventsUserRepository userRepository;
	
	@Override
	public void delete(EventsUser user) {
		userRepository.delete(user);
	}

	@Override
	public List<EventsUser> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public EventsUser findById(Long id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public EventsUser save(EventsUser user) {
		return userRepository.save(user);
	}

	@Override
	public EventsUser findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
