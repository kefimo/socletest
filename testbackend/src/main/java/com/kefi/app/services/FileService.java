package com.kefi.app.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileService {
 
	private static final String FILE_DIRECTORY = "/home/mkefi/Bureau/uploaded";
	
	public void storeFile(MultipartFile file) throws IOException {
		Path filePath = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());
		 File targetFile = new File(FILE_DIRECTORY + "/" + file.getOriginalFilename());
		 if(!targetFile.exists())
		    {
		    	targetFile.createNewFile();
		    }
		byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(file.getInputStream());
		Files.write(filePath, bytes, StandardOpenOption.APPEND);
	}
	
	public void storeFileStream(InputStream stream) throws IOException{	
				
			    File targetFile = new File(FILE_DIRECTORY+"/targetFile.txt");
			    if(!targetFile.exists())
			    {
			    	targetFile.createNewFile();
			    }
			    byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(stream);
			    Files.write(targetFile.toPath(), bytes, StandardOpenOption.APPEND);
			   
			 
			    IOUtils.closeQuietly(stream);
	}
}