package com.project.events.dto.request;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

public class VenueRequestDTO {

	private String name;

	private BigDecimal pricePerDay;

	private String address;
	
	public VenueRequestDTO(HttpServletRequest request) {
		this.name = request.getParameter("name");
		this.pricePerDay = new BigDecimal(request.getParameter("pricePerDay"));
		this.address = request.getParameter("address");
		
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

}
