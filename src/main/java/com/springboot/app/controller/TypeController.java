package com.springboot.app.controller;

import java.util.Collection;
import java.util.Optional;

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
import com.springboot.app.model.Type;
import com.springboot.app.repository.TypeRepository;
import com.springboot.app.service.ImageService;
import com.springboot.app.service.IsImageService;

import exception.ApiRequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class TypeController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
		private IsImageService ImageService;
		

	@CrossOrigin(origins = "*")
	
	@GetMapping("/type")
	public Collection<Type> type() {
		ApiRequestException except = new ApiRequestException("oops this is custom exception");
	
		try {
			return this.typeRepository.findAll();
		} catch (Exception e) {
					throw except;
   }
	}
	 @GetMapping("/img/{id}")
	  public ResponseEntity<byte[]> getImage(@PathVariable("id") long id) {
		  
		 Type  type = typeRepository.findById(id).orElse(null);
		  String img_name  = type.getImages(); 
		  
		  try {
			  byte[] image = ImageService.getImageFile(img_name);
	            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
		} catch (Exception e) {
			log.error("error get image",e);
		}
		return null;
	  
	  }
	@PostMapping("type")
	public Type addtype(@RequestBody Type types){
		return this.typeRepository.save(types);
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
	  
	@PutMapping("/type/{id}")
	  public Type update(@RequestBody Type newType, @PathVariable Long id) {
       String returnValue = "success";
   
	    return this.typeRepository.findById(id)
	      .map(types -> {
	    
	    	  types.setTypename(newType.getTypename());
	    	  types.setDescription(newType.getDescription());
	    	  types.setPrice(newType.getPrice());
	    	  types.setImages(newType.getImages());
	        return typeRepository.save(types);
	      })
	      .orElseGet(() -> {
	    	  newType.setId(id);
	        return typeRepository.save(newType);
	      });
	  }
	
	  @DeleteMapping("/type/{id}")
	  public String deleteType(@PathVariable Long id) {
		  String returnValue = "success" ;
		  try {
		 typeRepository.deleteById(id);
		 
		  }catch (Exception e) {
			  e.printStackTrace();
			  log.error("Error delete type",e);
			  returnValue = "error";
		  }
		return returnValue;
	  }	  
	  
	
	 
	@Autowired TypeRepository typeRepository;
}
