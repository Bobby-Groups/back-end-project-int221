package com.springboot.app.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.exception.ApiRequestException;
import com.springboot.app.model.Color;
import com.springboot.app.repository.ColorRepository;
@CrossOrigin(origins = "*")
@RestController
public class ColorController {
	

	@GetMapping("/color")
	public Collection<Color> color(){
		
		return this.colorRepository.findAll();
	}
	
	 @PostMapping(path = "/color")
    public Color addcolor(@RequestBody Color colors) {
		 try {
			 return this.colorRepository.save(colors);
		} catch (Exception e) {
		throw new ApiRequestException("can't insert color :"+ colors + "cause :" +e);
		}
  
 }	
	 @PutMapping("/color/{id}")
	  public Color update(@RequestBody Color newColor, @PathVariable Long id) {
		 try {
			return this.colorRepository.findById(id)
	      .map(colors -> {
	    	  colors.setColorName(newColor.getColorName());
	    	  colors.setColorcode(newColor.getColorcode());
	        return colorRepository.save(colors);
	      })
	      .orElseGet(() -> {
	    	  newColor.setId(id);
	        return colorRepository.save(newColor);
	      });
		} catch (Exception e) {
		 throw new ApiRequestException("can't edit color cause : " +e );
		}
	    
	  }
	 
	  @DeleteMapping("/color/{id}")
	  public String deleteColor(@PathVariable Long id) {
		  try {
				 colorRepository.deleteById(id);
		} catch (Exception e) {
			throw new ApiRequestException("not have color to delete at id :" + id + "cause :" +e);
		}
	
		return "delete color success";
	  }

	 
	@Autowired ColorRepository colorRepository;
}
