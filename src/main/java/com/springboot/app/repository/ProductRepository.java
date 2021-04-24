package com.springboot.app.repository;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
	Collection<Product> findByid(long id);
}
