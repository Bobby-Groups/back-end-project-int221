package com.springboot.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IsImageService {
 

	void saveImage(MultipartFile imageFile) throws Exception;
    byte[] getImageFile(String fileName) throws IOException ;
}
