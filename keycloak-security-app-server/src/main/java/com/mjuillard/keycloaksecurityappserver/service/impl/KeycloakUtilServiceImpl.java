package com.mjuillard.keycloaksecurityappserver.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjuillard.keycloaksecurityappserver.service.KeycloakUtilService;

@Service
public class KeycloakUtilServiceImpl implements KeycloakUtilService{

	@Autowired
	private HttpServletRequest request;
	
	@Override
	public AccessToken getAccessToken() {
		
		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();        
        KeycloakPrincipal<KeycloakSecurityContext> principal= (KeycloakPrincipal<KeycloakSecurityContext>) token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        return session.getToken();
	}
	
}
