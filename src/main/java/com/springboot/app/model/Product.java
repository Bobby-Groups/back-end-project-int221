package com.springboot.app.model;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product  {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String images ;
	private Date date;
	private long type_id;
	@ManyToOne
	@JoinColumn(name = "colors_Id")
    private Color color;
	@ManyToOne
	@JoinColumn(name="brands_id")
	private Brand brand;
    
	public Product(Long id,Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	public Product() {
		
	}
	
	public Long getId() {
		return id;
	}
	public Date getDate() {
		return date;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public long getType_id() {
		return type_id;
	}
	public void setType_id(long type_id) {
		this.type_id = type_id;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", images=" + images + ", date=" + date + ", type_id=" + type_id + ", color="
				+ color + ", brand=" + brand + "]";
	}

	

	
	
	

	
}
