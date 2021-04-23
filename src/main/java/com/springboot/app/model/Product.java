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
public class Product implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Date date;
	
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
	
	
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Product [id=" + this.id + ", date=" + date + "]";
	}


	

	
	
	

	
}
