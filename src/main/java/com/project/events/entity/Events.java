package com.project.events.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "events")
public class Events {

	public enum TYPE {
		CONFERENCE, MEETING, SEMINAR, PARTY
	}

	public enum STATUS {
		PAYMENT_PENDING, PAYMENT_SUCCESSFUL
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String customerName;

	@NotBlank
	private TYPE eventType;

	@NotBlank
	private Date eventTime;

	@NotBlank
	private STATUS eventStatus;

	@NotBlank
	private BigDecimal totalAmount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="events_user_id")
	private EventsUser user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="venue_id")
	private Venue venue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public EventsUser getUser() {
		return user;
	}

	public void setUser(EventsUser user) {
		this.user = user;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	
	

}
