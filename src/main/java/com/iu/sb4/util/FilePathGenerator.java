package com.iu.sb4.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FilePathGenerator {

	@Autowired
	private ResourceLoader resourceLoader;
	// 1. ResourceLoader 사용하기 
	public File getUseResourceLoader(String filePath) throws Exception {
		// filePath : /static/ 하위 경로명
		
		String path = "classpath:/static/";
		
		//resourceLoader.getResource(path);
		
		File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		System.out.println(file.getAbsolutePath());
	
		if(!file.exists()) {
			file.mkdirs();
		}
	
			return file;
	}
	
}
