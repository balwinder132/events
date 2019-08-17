package com.project.events.service;

import java.util.List;
import java.util.Optional;

import com.project.events.entity.Card;

public interface CardService {
	
	public void delete(Card card);

	public List<Card> findAll();

	Card findById(Long id);

	public Card save(Card card);

}
