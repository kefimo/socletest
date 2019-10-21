package com.kefi.app.controller;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kefi.app.services.FileService;


@RestController
@RequestMapping("/uploadServices")
public class UploadWebServices {
	
	private final FileService fileService;
	
	@Autowired
	public UploadWebServices(FileService fileService) {
		this.fileService = fileService;
	}
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<String> hello() {
			try {
				return new ResponseEntity<String>("hello",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);				
    }
	
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value="/uploadFile")
	@ResponseBody
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
			try {
				fileService.storeFile(file);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);				
    }
	
	@Transactional
	@CrossOrigin
	@RequestMapping(value="/uploadFileStream")
	@ResponseBody
	public ResponseEntity<Object> uploadFileStream(InputStream uploadedInputStream)
	{
		try {
			fileService.storeFileStream(uploadedInputStream);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);		
		
	}
	
}