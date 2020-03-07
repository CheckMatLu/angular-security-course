package com.mjuillard.keycloaksecurityappserver.service;

import java.util.List;
import java.util.Optional;

import com.mjuillard.keycloaksecurityappserver.model.Cart;
import com.mjuillard.keycloaksecurityappserver.model.Product;

public interface CartService {

	List<Cart> getCustomerCarts(final String customerId);
	
	Optional<Cart> getCart(final Long cartId);
	
	List<Product> getProducts(final Long cartId);
}
