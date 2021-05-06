package com.springboot.app.controller;

import java.io.Serializable;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Brand;
import com.springboot.app.model.Product;
import com.springboot.app.repository.BrandRepository;
import com.springboot.app.service.ImageService;
import com.springboot.app.service.IsImageService;

	@CrossOrigin(origins = "*")
@RestController
public class BrandController {
		
		private Logger log = LoggerFactory.getLogger(this.getClass());

		@Autowired
		private IsImageService ImageService;

	@GetMapping("/brand")
	public Collection<Brand> brand(){
		return this.brandRepository.findAll();
	}
	 @GetMapping("/brandimg/{id}")
	  public ResponseEntity<byte[]> getImage(@PathVariable("id") long id) {
		  
		  Brand  brand = brandRepository.findById(id).orElse(null);
		  String img_name  = brand.getImages(); 
		  
		  try {
			  byte[] image = ImageService.getImageFile(img_name);
	            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
		} catch (Exception e) {
			log.error("error get image",e);
		}
		return null;
	  
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
	 
	 @DeleteMapping("/brand/{id}")
	  public String deleteBrand(@PathVariable Long id) {
		 brandRepository.deleteById(id);
		return "delete brand success";
	  }
	@Autowired BrandRepository brandRepository;
}
