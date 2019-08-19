package com.project.events.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value= {""}, method=RequestMethod.GET)
	public String login(Principal principal) {
		if(principal != null ) {
			{
				if(((Authentication)principal).isAuthenticated()) {
					return "redirect:/event";
				}
			}
		}
		return "login";
	}
}
