package com.springboot.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="brands")
public class Brand implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	 @Column(name="Brandid")
	private long Id;
	
	
	private String brandname;

	 
	 public Brand() {
			
		}
	 
	public Brand(String brandName) {
		super();
		this.brandname = brandName;
	}

	public long getId() {
		return Id;
	}

	public void setId(long brandId) {
		this.Id = brandId;
	}

	public String getBrandName() {
		return brandname;
	}

	

	public void setBrandName(String brandName) {
		this.brandname = brandName;
	}
	@Override
	public String toString() {
		return "Brand [brandId=" + Id + ", brandName=" + brandname + "]";
	}
	 
}
