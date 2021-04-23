package com.springboot.app.controller;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.app.model.Brand;
import com.springboot.app.repository.BrandRepository;



public class BrandController {
 
	@GetMapping("/brand")
	public Collection<Brand> brand(){
		return this.brandRepository.findAll();
	}
	@Autowired BrandRepository brandRepository;
}
