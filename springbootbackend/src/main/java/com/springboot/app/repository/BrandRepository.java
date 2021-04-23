package com.springboot.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long>{
 
	Collection<Brand>findById(long brandId);
}
