package com.project.events.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.events.dto.request.UserRequestDTO;
import com.project.events.mapper.UserMapper;
import com.project.events.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(method = RequestMethod.GET)
	public String view(HttpServletRequest request, ModelMap map) {
		map.addAttribute("success", request.getParameter("success"));
		return "user";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView signUp(HttpServletRequest request, ModelMap map) {
		UserRequestDTO dto = new UserRequestDTO(request);
		dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		map.addAttribute("user", userMapper.toDTO(userService.save(userMapper.toEntity(dto))));
		map.addAttribute("success", "Registered Successfuly");
		return new ModelAndView("redirect:/user", map);
	}
}
