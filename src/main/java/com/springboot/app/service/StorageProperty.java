package com.springboot.app.service;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "springbootbackend.storage")
public class StorageProperty {

 private String location ;

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}
 
}
