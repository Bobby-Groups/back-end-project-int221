package com.springboot.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.model.Color;


public interface ColorRepository  extends JpaRepository<Color, Long>{

	Collection<Color> findById(long Id);
}
