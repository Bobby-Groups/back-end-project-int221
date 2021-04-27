package com.springboot.app.model;

import java.io.Serializable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "colors")
public class Color implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

	private long Id;
	private String colorcode;

	private String colorname;
	
	
	public Color( String colorName) {
		super();
	
		this.colorname = colorName;
	}
	
	public Color() {

	}

	public long getId() {
		return Id;
	}
	public void setId(long colorId) {
		this.Id = colorId;
	}

	public String getColorcode() {
		return colorcode;
	}

	public void setColorcode(String colorcode) {
		this.colorcode = colorcode;
	}

	public String getColorName() {
		return colorname;
	}

	public void setColorName(String colorName) {
		this.colorname = colorName;
	}

	@Override
	public String toString() {
		return "Color [Id=" + Id + ", colorcode=" + colorcode + ", colorname=" + colorname + "]";
	}


	

	 
	 
}
