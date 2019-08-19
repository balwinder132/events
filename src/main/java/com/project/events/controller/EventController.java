package com.project.events.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.project.events.dto.request.CardRequestDTO;
import com.project.events.dto.request.EventRequestDTO;
import com.project.events.entity.Card;
import com.project.events.entity.Events;
import com.project.events.entity.Events.STATUS;
import com.project.events.entity.Events.TYPE;
import com.project.events.mapper.CardMapper;
import com.project.events.mapper.EventMapper;
import com.project.events.service.CardService;
import com.project.events.service.EventsService;
import com.project.events.service.UserService;
import com.project.events.service.VenueService;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventsService eventService;

	@Autowired
	private EventMapper eventMapper;

	@Autowired
	private UserService userService;

	@Autowired
	private VenueService venueService;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private CardMapper cardMapper;

	@RequestMapping(method = RequestMethod.GET)
	public String view(ModelMap map) {
		map.addAttribute("type", TYPE.values());
		map.addAttribute("venue", venueService.findAll());
		
		return "event";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addEvent(HttpServletRequest request, ModelMap map, RedirectAttributes redirect) throws ParseException {
		EventRequestDTO eventRequest = new EventRequestDTO(request);
		eventRequest.setEventStatus(STATUS.PAYMENT_PENDING);
		Events event = eventMapper.toEntity(eventRequest);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		event.setUser(userService.findByEmail(user.getUsername()));
		event.setVenue(venueService.findById(eventRequest.getVenueId()));
		eventService.save(event);
		map.addAttribute("success", "Event added successfuly");
		map.addAttribute("event", event.getId());
		return new ModelAndView("redirect:/event/payment", map);
	}
	
	@RequestMapping(value="/payment", method = RequestMethod.GET)
	public String paymentView(HttpServletRequest request, ModelMap map) {
		map.addAttribute("event", request.getParameter("event"));
		return "card";
	}
	
	@RequestMapping( value="/payment", method = RequestMethod.POST)
	public ModelAndView addCard(HttpServletRequest request, ModelMap map) throws ParseException {
		CardRequestDTO cardRequest = new CardRequestDTO(request);
		String saveCard = request.getParameter("saveCard");
		boolean save = saveCard != null ? (saveCard.equals("on") ? true : false) : false;
		if(save) {
			Card card = cardMapper.toEntity(cardRequest);
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			card.setUser(userService.findByEmail(user.getUsername()));
			cardService.save(card);
		}

		Events event = eventService.findById(Long.valueOf(request.getParameter("eventId")));
		event.setEventStatus(STATUS.PAYMENT_SUCCESSFUL);
		eventService.save(event);
		map.addAttribute("success", "Event added successfuly");
		return new ModelAndView("redirect:/event", map);	
	}
	
	@RequestMapping( value="/view-events", method = RequestMethod.GET)
	public String viewEvents(ModelMap map) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getUsername());
		
		List<Events> events = eventService.findByUserEmail(user.getUsername());
		System.out.println(events.size());
		map.addAttribute("events", events);
		return "view-events";
	}
	
	@RequestMapping( value="/delete/{eventId}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("eventId") Long eventId, ModelMap map) {
		Events event = eventService.findById(eventId);
		if(event != null) {
			eventService.delete(event);
		}
		return new ModelAndView("redirect:/event");
	}
}
