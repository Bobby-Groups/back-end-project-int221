package com.springboot.app.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="brands")
public class Brand implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	private String images;
	
	private String brandname;
    

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name ="have_type",joinColumns = @JoinColumn(name = "brands_id"),inverseJoinColumns = @JoinColumn (name ="types_id"))
	Set<Type> types;
	 
	 public Brand() {
			
		}
	 
	public Brand(String brandName) {
		super();
		this.brandname = brandName;
	}

	
	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public long getId() {
		return id;
	}

	public void setId(long brandId) {
		this.id = brandId;
	}

	public String getBrandName() {
		return brandname;
	}

	

	

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	

	public Set<Type> getTypes() {
		return types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Brand [Id=" + id + ", images=" + images + ", brandname=" + brandname + ", types=" + types + "]";
	}

	
	
	

	 
}
