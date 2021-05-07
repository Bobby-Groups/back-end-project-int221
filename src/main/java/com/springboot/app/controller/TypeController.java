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

import com.springboot.app.exception.ApiRequestException;
import com.springboot.app.model.Color;
import com.springboot.app.model.Type;
import com.springboot.app.repository.TypeRepository;
import com.springboot.app.service.ImageService;
import com.springboot.app.service.IsImageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@CrossOrigin(origins = "*")
public class TypeController {


	@GetMapping("/type")
	public Collection<Type> type() {
	return this.typeRepository.findAll();
		}

	@PostMapping("type")
	public Type addtype(@RequestBody Type types){
		try {
			return this.typeRepository.save(types);
		} catch (Exception e) {
		throw new ApiRequestException("can't insert type "+ types);
		}
		
	}
	
	  @PutMapping("/type/{id}")
	  public Type update(@RequestBody Type newType, @PathVariable Long id) {
     try {
    	 return this.typeRepository.findById(id)
    		      .map(types -> {
    		    
    		    	  types.setTypename(newType.getTypename());
    		    	  types.setDescription(newType.getDescription());
    		    	  types.setPrice(newType.getPrice());
    		    	
    		        return typeRepository.save(types);
    		      })
    		      .orElseGet(() -> {
    		    	  newType.setId(id);
    		        return typeRepository.save(newType);
    		      });
	} catch (Exception e) {
		throw new ApiRequestException("not have type to edit at id :"+ id);
	}
     }
	
	  @DeleteMapping("/type/{id}")
	  public String deleteType(@PathVariable Long id) {
		 
		  try {
		 typeRepository.deleteById(id);
		 
		  }catch (Exception e) {
		   throw new ApiRequestException("not have type to delete at id: " +id);
		  }
		return "delete type success";
		 }	  
	  
	
	 
	@Autowired TypeRepository typeRepository;
}
