package com.springboot.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Type;
import com.springboot.app.repository.TypeRepository;
@RestController
public class TypeController {

	@CrossOrigin(origins = "*")
	
	@GetMapping("/type")
	public Collection<Type> type(){
		return this.typeRepository.findAll();
				
	}
	@PostMapping("type")
	public Type addtype(@RequestBody Type types){
		return this.typeRepository.save(types);
	}
	@Autowired TypeRepository typeRepository;
}
