package com.springboot.app.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class ImageService implements IsImageService{

	public void saveImage(MultipartFile imageFile) throws Exception {
		// TODO Auto-generated method stub
		String folder = "./public/productimage/";
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(folder+ imageFile.getOriginalFilename());
		Files.write(path, bytes);
	}

}
