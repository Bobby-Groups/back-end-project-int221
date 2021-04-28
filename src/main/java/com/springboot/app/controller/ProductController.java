package com.springboot.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	 @PostMapping(path = "/product")
	    public Product addProduct(@RequestBody Product products) {
		   return this.productRepository.save(products);
	    }	
	 
	@PutMapping(path ="product/{id}")
	public Product update(@RequestBody Product newproduct,@PathVariable Long id) {
		return this.productRepository.findById(id)
				.map(products -> {
					products.setBrand(newproduct.getBrand());
					products.setColor(newproduct.getColor());
					products.setDate(newproduct.getDate());
				
					return productRepository.save(products);
				}).orElseGet(() -> {
					newproduct.setId(id);
					return productRepository.save(newproduct);
				});
	}
	  
	
	@Autowired ProductRepository productRepository;
	
}
