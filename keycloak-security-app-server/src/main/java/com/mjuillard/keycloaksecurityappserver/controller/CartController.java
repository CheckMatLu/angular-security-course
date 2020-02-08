package com.mjuillard.keycloaksecurityappserver.controller;

import java.util.List;

import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjuillard.keycloaksecurityappserver.model.Cart;
import com.mjuillard.keycloaksecurityappserver.service.CartService;
import com.mjuillard.keycloaksecurityappserver.service.KeycloakUtilService;

@RestController
@RequestMapping(value = "/customers")
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	KeycloakUtilService keyclaokUtils;
	
	@GetMapping(value = "/carts", produces = MediaType.APPLICATION_JSON_VALUE)
//	@PreAuthorize("hasRole('USER')")
	public List<Cart> getCarts(){
		
		AccessToken accessToken = keyclaokUtils.getAccessToken();
		String customerId = accessToken.getSubject();
		return cartService.getCustomerCarts(customerId);
	}
	
}
