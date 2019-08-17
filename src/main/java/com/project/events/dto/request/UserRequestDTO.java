package com.project.events.dto.request;

import javax.servlet.http.HttpServletRequest;

public class UserRequestDTO {
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String password;

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
	
	public UserRequestDTO(HttpServletRequest request) {
		this.firstName = request.getParameter("firstName");
		this.lastName = request.getParameter("lastName");
		this.email = request.getParameter("email");
		this.password = request.getParameter("password");
		
	}
	
}
