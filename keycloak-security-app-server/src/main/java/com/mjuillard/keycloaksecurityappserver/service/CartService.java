package com.mjuillard.keycloaksecurityappserver.service;

import java.util.List;

import com.mjuillard.keycloaksecurityappserver.model.Cart;

public interface CartService {

	List<Cart> getCustomerCarts(final String customerId);
}
