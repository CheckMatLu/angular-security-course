package com.mjuillard.keycloaksecurityappserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mjuillard.keycloaksecurityappserver.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByCarts_Id(Long id);

}
