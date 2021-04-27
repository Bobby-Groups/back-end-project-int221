package com.springboot.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Color;
import com.springboot.app.repository.ColorRepository;

@RestController
public class ColorController {
	@CrossOrigin(origins = "*")

	@GetMapping("/color")
	public Collection<Color> color(){
		return this.colorRepository.findAll();
	}
	
	 @PostMapping(path = "/color")
    public Color addcolor(@RequestBody Color colors) {
   return this.colorRepository.save(colors);
 }	
	@Autowired ColorRepository colorRepository;
}
