package com.project.events.mapper;

import org.mapstruct.Mapper;

import com.project.events.dto.request.VenueRequestDTO;
import com.project.events.dto.response.VenueResponseDTO;
import com.project.events.entity.Venue;

@Mapper(componentModel="spring")
public interface VenueMapper {
	
	Venue toEntity(VenueRequestDTO request);
	
	VenueResponseDTO toDTO(Venue venue);
}
