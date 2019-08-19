package com.project.events.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.events.entity.Events;

@Repository
public interface EventsRepository extends BaseRepository<Events, Long>{

	List<Events> findByUserId(Long userId);
	
	List<Events> findByUserEmail(String email);
		
	List<Events> findByVenueId(Long venueId);

}
