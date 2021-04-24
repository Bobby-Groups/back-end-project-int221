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
	private long Id;
	
	
	private String brandname;
    

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name ="have_type",joinColumns = @JoinColumn(name = "brand_brandid"),inverseJoinColumns = @JoinColumn (name ="type_typeid"))
	Set<Type> types;
	 
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
		return "Brand [Id=" + Id + ", brandname=" + brandname + ", types=" + types + "]";
	}

	
	
	

	 
}
