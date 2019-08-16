package com.project.events.repository;

import org.springframework.stereotype.Repository;

import com.project.events.entity.Venue;

@Repository
public interface VenueRepository extends BaseRepository<Venue, Long> {

}
