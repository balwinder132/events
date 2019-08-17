package com.project.events.mapper;

import org.mapstruct.Mapper;

import com.project.events.dto.request.UserRequestDTO;
import com.project.events.dto.response.UserResponseDTO;
import com.project.events.entity.EventsUser;

@Mapper(componentModel="spring")
public interface UserMapper {

	EventsUser toEntity(UserRequestDTO request);
	
	UserResponseDTO toDTO(EventsUser user);
}
