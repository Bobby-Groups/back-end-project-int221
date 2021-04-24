package com.springboot.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.model.Type;



public interface TypeRepository extends JpaRepository<Type, Long>{

	
	Collection<Type> findByid(long id);
}
