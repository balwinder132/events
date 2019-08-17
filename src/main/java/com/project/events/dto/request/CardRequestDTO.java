package com.project.events.dto.request;

import javax.servlet.http.HttpServletRequest;

public class CardRequestDTO {

	private String number;

	private String name;

	private String expiry;
	
	public CardRequestDTO(HttpServletRequest request) {
		this.number = request.getParameter("number");
		this.name = request.getParameter("name");
		this.expiry = request.getParameter("expiry");
		
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	
}
