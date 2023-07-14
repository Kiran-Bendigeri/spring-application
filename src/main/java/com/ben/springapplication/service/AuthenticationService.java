package com.ben.springapplication.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean isUserAuthorized(String name, String password) {
		
		boolean check = false;
		if(name.equalsIgnoreCase("kiran") && password.equals("12345")) {
			return true;
		}
		
		return check;
	}

}
