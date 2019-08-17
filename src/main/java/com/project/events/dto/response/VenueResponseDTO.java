package com.project.events.dto.response;

import java.math.BigDecimal;
import java.util.List;


public class VenueResponseDTO {

	private Long id;

	private String name;

	private BigDecimal pricePerDay;

	private String address;

	private List<EventResponseDTO> events;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(BigDecimal pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<EventResponseDTO> getEvents() {
		return events;
	}

	public void setEvents(List<EventResponseDTO> events) {
		this.events = events;
	}
	
	
}
