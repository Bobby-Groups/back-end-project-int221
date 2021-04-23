package com.springboot.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Color;
import com.springboot.app.repository.ColorRepository;

@RestController
public class ColorController {
    
	@GetMapping("/color")
	public Collection<Color> color(){
		return this.colorRepository.findAll();
	}
	@Autowired ColorRepository colorRepository;
}
