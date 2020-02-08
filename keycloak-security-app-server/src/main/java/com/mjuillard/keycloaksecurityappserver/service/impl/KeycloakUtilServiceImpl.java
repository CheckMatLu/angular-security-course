package com.mjuillard.keycloaksecurityappserver.service.impl;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjuillard.keycloaksecurityappserver.model.dto.UserDto;
import com.mjuillard.keycloaksecurityappserver.service.KeycloakUtilService;

@Service
public class KeycloakUtilServiceImpl implements KeycloakUtilService{

	@Autowired
	private KeycloakRestTemplate restTemplate;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public AccessToken getAccessToken() {
		
		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();        
        KeycloakPrincipal<KeycloakSecurityContext> principal= (KeycloakPrincipal<KeycloakSecurityContext>) token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        return session.getToken();
	}
	
	@Override
	public List<UserDto> getAllUsers(){
		List keycloakUserList = restTemplate.getForEntity(URI.create("http://localhost:8180/auth" + "/admin/realms/myshop-realm/users"), List.class)
				.getBody();
		List<UserDto> results;
		
		Type listType = new TypeToken<List<UserDto>>() {}.getType();
		results = new ModelMapper().map(keycloakUserList, listType);

		return results;
	}
	
}
