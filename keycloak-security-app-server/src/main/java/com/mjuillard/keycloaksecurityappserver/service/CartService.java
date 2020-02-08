package com.mjuillard.keycloaksecurityappserver.service;

import java.util.List;

import com.mjuillard.keycloaksecurityappserver.model.Cart;
import com.mjuillard.keycloaksecurityappserver.model.Product;

public interface CartService {

	List<Cart> getCustomerCarts(final String customerId);
	
	List<Product> getProducts(final Long cartId);
}
