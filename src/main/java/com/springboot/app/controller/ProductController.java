package com.springboot.app.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.model.Color;
import com.springboot.app.model.Product;

import com.springboot.app.repository.ColorRepository;
import com.springboot.app.repository.ProductRepository;
import com.springboot.app.service.ImageService;
import com.springboot.app.service.IsImageService;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IsImageService ImageService;

	
	@GetMapping("/product")
	public Collection<Product> product() {
		return this.productRepository.findAll();
		
	}
	 @PostMapping(path = "/product")
	    public Product addProduct(@RequestBody Product products) {
		   return this.productRepository.save(products);
	    }	
	  @PostMapping("/uploadImage")
	  public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
		  String returnValue = "success" ;
		  try {
			ImageService.saveImage(imageFile);
	       	} catch (Exception e) {
			e.printStackTrace();
			log.error("Error saving photo",e);
		    returnValue = "error";
		}
		  return returnValue;
	  }
	 
	@PutMapping(path ="product/{id}")
	public Product update(@RequestBody Product newproduct,@PathVariable Long id) {
		return this.productRepository.findById(id)
				.map(products -> {
					products.setBrand(newproduct.getBrand());
					products.setColor(newproduct.getColor());
					products.setDate(newproduct.getDate());
					  products.setImages(newproduct.getImages());
					return productRepository.save(products);
				}).orElseGet(() -> {
					newproduct.setId(id);
					return productRepository.save(newproduct);
				});
	}
	  @DeleteMapping("/product/{id}")
	  public String deleteProduct(@PathVariable Long id) {
		 productRepository.deleteById(id);
		return "delete product success";
	  }	  
	  
		 @GetMapping("/img/{id}")
		  public ResponseEntity<byte[]> getImage(@PathVariable("id") long id) {
			  
			 Product  product = productRepository.findById(id).orElse(null);
			  String img_name  = product.getImages(); 
			  
			  try {
				  byte[] image = ImageService.getImageFile(img_name);
		            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
			} catch (Exception e) {
				log.error("error get image",e);
			}
			return null;
		  
		  }
	
	@Autowired ProductRepository productRepository;
	
}
