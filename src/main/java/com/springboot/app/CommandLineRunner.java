package com.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.app.model.Brand;
import com.springboot.app.model.Color;
import com.springboot.app.model.Product;
import com.springboot.app.model.Type;
import com.springboot.app.repository.BrandRepository;
import com.springboot.app.repository.ColorRepository;
import com.springboot.app.repository.ProductRepository;
import com.springboot.app.repository.TypeRepository;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
	
		for(Product p : this.productRepository.findAll()) {
			System.out.println(p.toString());
			}
		System.out.println("--------------------------------------");
		for (Color c : this.colorRepository.findAll()) {
			System.out.println(c.toString());
		}
//		System.out.println("--------------------------------------");
//		for (Brand b : this.brandRepository.findAll()) {
//			System.out.println(b.toString());
//		}
//		System.out.println("--------------------------------------");
//		for (Type t : this.typeRepository.findAll()) {
//			System.out.println(t.toString());
//		}System.out.println("--------------------------------------");
	}
 @Autowired ProductRepository productRepository;
 @Autowired ColorRepository colorRepository;
 @Autowired BrandRepository brandRepository;
 @Autowired TypeRepository typeRepository;
}
