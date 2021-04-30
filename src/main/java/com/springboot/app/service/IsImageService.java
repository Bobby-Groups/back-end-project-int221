package com.springboot.app.service;

import org.springframework.web.multipart.MultipartFile;

public interface IsImageService {
 

	void saveImage(MultipartFile imageFile) throws Exception;
		
}
