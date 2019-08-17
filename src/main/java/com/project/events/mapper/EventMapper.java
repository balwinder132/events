package com.project.events.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.project.events.dto.request.EventRequestDTO;
import com.project.events.dto.response.EventResponseDTO;
import com.project.events.entity.Events;

@Mapper(componentModel="spring")
public interface EventMapper {

	Events toEntity(EventRequestDTO request);
	
	@Mappings({ 
        @Mapping(target = "userId", source = "user.id"),
        @Mapping(target = "venueId", source = "venue.id"),
   })
	EventResponseDTO toDTO(Events event);
}
