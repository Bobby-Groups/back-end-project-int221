package com.springboot.app.controller;

import java.util.Collection;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
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

import com.springboot.app.exception.ApiException;
import com.springboot.app.exception.ApiRequestException;
import com.springboot.app.model.Color;
import com.springboot.app.model.Product;

import com.springboot.app.repository.ColorRepository;
import com.springboot.app.repository.ProductRepository;
import com.springboot.app.service.ImageService;
import com.springboot.app.service.IsImageService;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {


	@Autowired
	private IsImageService ImageService;

	
	@GetMapping("/product")
	public Collection<Product> product() {
		return productRepository.findAll();
		}
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable Long id) throws Exception {
	return productRepository.findById(id).orElseThrow(() -> new ApiRequestException("product not found" ));
		}

	  
	  
	 @PostMapping(path = "/product")
	    public Product addProduct(@RequestBody Product products) {
		 try {
			   return this.productRepository.save(products);
		} catch (Exception e) {
			throw new ApiRequestException("can't insert product :" + products +"cause : " + e);// TODO: handle exception
		}
		
	    }	
	  @PostMapping("/uploadImage")
	  public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
	
		  try {
			ImageService.saveImage(imageFile);
	       	} catch (Exception e) {
			e.printStackTrace();
         throw new ApiRequestException("cannot upload this imagefile cause :" + e);
		}
		return null;

	  }
	 
	@PutMapping(path ="product/{id}")
	public Product update(@RequestBody Product newproduct,@PathVariable Long id) throws Exception{
		try {
			return this.productRepository.findById(id)
				.map(products -> {
					products.setBrand(newproduct.getBrand());
					products.setColor(newproduct.getColor());
					products.setDate(newproduct.getDate());
					  products.setImages(newproduct.getImages());
					  products.setType_id(newproduct.getType_id());
					return productRepository.save(products);
				}).orElseGet(() -> {
					newproduct.setId(id);
					return productRepository.save(newproduct);
				});
		} catch (Exception e) {
			throw new ApiRequestException("can't edit product cause : " + e );
 				}
	}
	  @DeleteMapping("/product/{id}")
	  public String deleteProduct(@PathVariable Long id) {
		  try {
			 productRepository.deleteById(id);
		} catch (Exception e) {
			throw new ApiRequestException("not have product to delete at  id : " + id + "cause : " + e);		}
		
		return "delete product success";
	  }	  
	  
		
	
	@Autowired ProductRepository productRepository;
	
}
