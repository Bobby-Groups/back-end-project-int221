package com.springboot.app.controller;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Brand;
import com.springboot.app.model.Product;
import com.springboot.app.repository.BrandRepository;


@RestController
public class BrandController {
	@CrossOrigin(origins = "*")

	@GetMapping("/brand")
	public Collection<Brand> brand(){
		return this.brandRepository.findAll();
	}
	
	 @PostMapping(path = "/brand")
	    public Brand addBrand(@RequestBody Brand brands) {
		   return this.brandRepository.save(brands);
	    }	
	 
	 @PutMapping(path = "/brand/{id}")
	 public Brand update(@RequestBody Brand newbrands,@PathVariable Long id) {
		 return this.brandRepository.findById(id)
				   .map(brands -> {
					brands.setBrandname(newbrands.getBrandName());
					brands.setTypes(newbrands.getTypes());
					return brandRepository.save(brands);
		 }).orElseGet(() -> {
			 newbrands.setId(id);
		        return brandRepository.save(newbrands);
		      });
	 }
	@Autowired BrandRepository brandRepository;
}
