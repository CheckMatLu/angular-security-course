package com.mjuillard.keycloaksecurityappserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjuillard.keycloaksecurityappserver.model.dto.UserDto;
import com.mjuillard.keycloaksecurityappserver.service.KeycloakUtilService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	KeycloakUtilService keycloakService;
	
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> getAllUsers() {
		return keycloakService.getAllUsers();
	}
}
