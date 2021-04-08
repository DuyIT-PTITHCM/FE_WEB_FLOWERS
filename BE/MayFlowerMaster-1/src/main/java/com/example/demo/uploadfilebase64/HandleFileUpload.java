package com.example.demo.uploadfilebase64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class HandleFileUpload {
	
	private String UPLOAD_DIR = "upload";
	public String uploadFile(String nameFile , String base64 ,HttpServletRequest request) {
		
		try {
			byte[] imgByte = Base64.getDecoder().decode(base64.getBytes());
			
			String directory=request.getServletContext().getRealPath("") +UPLOAD_DIR +File.separator+ nameFile;
			
			FileOutputStream fileOutputStream =	new FileOutputStream( new File(directory));
			fileOutputStream.write(imgByte);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	
		return nameFile;
	
}
}
