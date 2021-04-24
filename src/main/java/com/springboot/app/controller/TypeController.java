package com.springboot.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Type;
import com.springboot.app.repository.TypeRepository;
@RestController
public class TypeController {

	
	@GetMapping("/type")
	public Collection<Type> type(){
		return this.typeRepository.findAll();
				
	}
	@Autowired TypeRepository typeRepository;
}
