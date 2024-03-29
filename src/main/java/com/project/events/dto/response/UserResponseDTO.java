package com.project.events.dto.response;

import java.util.List;


public class UserResponseDTO {

	private Long id;

	private String email;

	private String firstName;

	private String lastName;

	private String password;

	private List<EventResponseDTO> events;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<EventResponseDTO> getEvents() {
		return events;
	}

	public void setEvents(List<EventResponseDTO> events) {
		this.events = events;
	}
	
}
