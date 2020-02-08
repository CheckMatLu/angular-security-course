package com.mjuillard.keycloaksecurityappserver.service;

import java.util.List;

import org.keycloak.representations.AccessToken;

import com.mjuillard.keycloaksecurityappserver.model.dto.UserDto;

public interface KeycloakUtilService {

	AccessToken getAccessToken();
	
	List<UserDto> getAllUsers();
	
	String getUserId();
}
