package com.project.events.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.events.dto.request.VenueRequestDTO;
import com.project.events.mapper.VenueMapper;
import com.project.events.service.VenueService;

@Controller
@RequestMapping("/venue")
public class VenueController {

	@Autowired
	private VenueService venueService;

	@Autowired
	private VenueMapper venueMapper;

	@RequestMapping(method = RequestMethod.GET)
	private String view() {
		return "venue";
	}

	@RequestMapping(method = RequestMethod.POST)
	private String addVenue(HttpServletRequest request, ModelMap map) {
		System.out.println(request.getParameter("pricePerDay"));
		map.addAttribute("venue",
				venueMapper.toDTO(venueService.save(venueMapper.toEntity(new VenueRequestDTO(request)))));
		map.addAttribute("success", "Venue Added Successfuly");
		return "venue";
	}

}
