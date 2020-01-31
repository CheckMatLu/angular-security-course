package com.mjuillard.keycloaksecurityappserver.service;

import org.keycloak.representations.AccessToken;

public interface KeycloakUtilService {

	AccessToken getAccessToken();
}
