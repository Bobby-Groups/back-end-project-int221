package com.springboot.app.model;

import java.io.Serializable;
import java.util.Formatter;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="types")
public class Type implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	private String typename;
	private double price;
	private String description;
	private String images ;
	

	
	
	public Type() {
		
	}

	public Type(String typename) {
		super();
		this.typename = typename;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", typename=" + typename + ", price=" + price + ", description=" + description
				+ ", images=" + images + "]";
	}

	
	
	
	
}
