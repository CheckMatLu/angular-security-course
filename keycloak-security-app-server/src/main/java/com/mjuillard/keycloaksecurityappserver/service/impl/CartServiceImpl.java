package com.mjuillard.keycloaksecurityappserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjuillard.keycloaksecurityappserver.model.Cart;
import com.mjuillard.keycloaksecurityappserver.model.Product;
import com.mjuillard.keycloaksecurityappserver.repository.CartRepository;
import com.mjuillard.keycloaksecurityappserver.repository.ProductRepository;
import com.mjuillard.keycloaksecurityappserver.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Cart> getCustomerCarts(final String customerId){
		return cartRepository.findByCustomerId(customerId);
	}
	
	@Override
	public List<Product> getProducts(final Long cartId){
		return productRepository.findByCarts_Id(cartId);
	}
}
