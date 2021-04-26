package com.springboot.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Color;
import com.springboot.app.model.Product;
import com.springboot.app.repository.ColorRepository;
import com.springboot.app.repository.ProductRepository;

@RestController
public class ProductController {
	@CrossOrigin(origins = "*")

	@GetMapping("/product")
	public Collection<Product> product() {
		return this.productRepository.findAll();
		
	}

	
	@Autowired ProductRepository productRepository;
	
}
