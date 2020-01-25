package com.mjuillard.keycloaksecurityappserver.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeycloakSecurityAppController {

	
	@GetMapping(path= {"/","/unsecured"})
	public String notSecuredEndPoint() {
		return "This is a public endpoint";
	}
	
	@GetMapping(path = "/admin", produces= MediaType.APPLICATION_JSON_VALUE)
	public String adminSecuredEndPoint(){
		return "You should be the admin if you're here, welcome mister admin!";
	}
	
	@GetMapping(path="/user")
	public String userSecuredEndPoint() {
		return "Welcome mister user";
	}
	
}
