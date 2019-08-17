package com.project.events.dto.request;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.project.events.entity.Events.STATUS;
import com.project.events.entity.Events.TYPE;

public class EventRequestDTO {

	private String customerName;

	private TYPE eventType;

	private Date eventTime;

	private STATUS eventStatus;

	private BigDecimal totalAmount;

	private Long userId;

	private Long venueId;
	
	public EventRequestDTO(HttpServletRequest request) throws ParseException {
		this.customerName = request.getParameter("customerName");
		this.eventType = TYPE.valueOf(request.getParameter("eventType"));
		this.eventTime = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("eventTime")); 
	//	this.eventStatus = STATUS.valueOf(request.getParameter("eventStatus"));
		this.venueId = Long.valueOf(request.getParameter("venueId"));
		this.totalAmount = new BigDecimal(request.getParameter("totalAmount"));
		
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public TYPE getEventType() {
		return eventType;
	}

	public void setEventType(TYPE eventType) {
		this.eventType = eventType;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public STATUS getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(STATUS eventStatus) {
		this.eventStatus = eventStatus;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getVenueId() {
		return venueId;
	}

	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}
	
}
