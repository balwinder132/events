package com.project.events.repository;

import org.springframework.stereotype.Repository;

import com.project.events.entity.EventsUser;

@Repository
public interface EventsUserRepository extends BaseRepository<EventsUser, Long> {
	
	EventsUser findByEmail(String email);
	
}
