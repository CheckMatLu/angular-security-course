package com.mjuillard.keycloaksecurityappserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjuillard.keycloaksecurityappserver.model.Cart;
import com.mjuillard.keycloaksecurityappserver.repository.CartRepository;
import com.mjuillard.keycloaksecurityappserver.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public List<Cart> getCustomerCarts(final String customerId){
		return cartRepository.findByCustomerId(customerId);
	}
}
