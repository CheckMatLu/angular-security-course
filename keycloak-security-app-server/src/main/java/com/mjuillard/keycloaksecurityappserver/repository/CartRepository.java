package com.mjuillard.keycloaksecurityappserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mjuillard.keycloaksecurityappserver.model.Cart;

public interface CartRepository  extends CrudRepository<Cart, Long> {
	
	List<Cart> findByCustomerId(String id);

}
