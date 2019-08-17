package com.project.events.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.events.entity.Card;
import com.project.events.repository.CardRepository;
import com.project.events.service.CardService;

@Service
public class CardServiceImpl implements CardService {

	
	@Autowired
	private CardRepository cardRepository;
	
	
	@Override
	public Card findById(Long id) {
		return cardRepository.findById(id).get();
	}

	@Override
	public void delete(Card card) {
		cardRepository.delete(card);
	}

	@Override
	public List<Card> findAll() {
		return cardRepository.findAll();
	}

	@Override
	public Card save(Card card) {
		return cardRepository.save(card);
	}
	
	
}
