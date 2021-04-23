package com.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.springboot.app.model.Product;
import com.springboot.app.repository.ProductRepository;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
	
		for(Product p : this.productRepository.findAll())
			System.out.println(p.toString());
	}
 @Autowired ProductRepository productRepository;
}
