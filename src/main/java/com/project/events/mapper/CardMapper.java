package com.project.events.mapper;

import org.mapstruct.Mapper;

import com.project.events.dto.request.CardRequestDTO;
import com.project.events.entity.Card;

@Mapper(componentModel="spring")
public interface CardMapper {

	Card toEntity(CardRequestDTO request);
	
}
