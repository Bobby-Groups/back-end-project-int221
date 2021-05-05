package com.springboot.app.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class ImageService implements IsImageService{

	private static final String FOLDER_URL = "./public/productimage/";
	public void saveImage(MultipartFile imageFile) throws Exception {
		// TODO Auto-generated method stub
		
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(FOLDER_URL+ imageFile.getOriginalFilename());
		Files.write(path, bytes);
	}
	 public byte[] getImageFile(String fileName) throws IOException {
	        Path path = Paths.get(FOLDER_URL+fileName);
	        byte[] data = Files.readAllBytes(path);
	        return data;
	     }

}
