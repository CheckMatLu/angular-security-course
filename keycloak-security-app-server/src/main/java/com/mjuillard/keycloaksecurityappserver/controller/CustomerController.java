package com.mjuillard.keycloaksecurityappserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjuillard.keycloaksecurityappserver.model.Cart;
import com.mjuillard.keycloaksecurityappserver.model.Product;
import com.mjuillard.keycloaksecurityappserver.service.CartService;
import com.mjuillard.keycloaksecurityappserver.service.KeycloakUtilService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CartService cartService;
	@Autowired
	KeycloakUtilService keyclaokUtils;
	
	@GetMapping(value = "/{id}/carts", produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("#id == principal.name")
	public List<Cart> getCarts(@PathVariable("id") String id){

		return cartService.getCustomerCarts(id);
	}
	
	@GetMapping(value = "/{userId}/carts/{cartId}/products", produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("#userId == principal.name")
	public List<Product> getCartProducts(@PathVariable("userId") String userId, @PathVariable("cartId") Long cartId){

		return cartService.getProducts(cartId);
	}
	
}
