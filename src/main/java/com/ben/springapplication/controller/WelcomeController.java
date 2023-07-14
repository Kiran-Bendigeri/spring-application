package com.ben.springapplication.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ben.springapplication.service.AuthenticationService;

@Controller
@RequestMapping("/apiv1/todo")
@SessionAttributes({"name", "password"})
public class WelcomeController {

	private AuthenticationService authenticationService;

	public WelcomeController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	
	@RequestMapping("/")
	public String welcome(ModelMap model) {
		model.put("name", "Kiran");
		return "welcome";
	}
	
	

}
