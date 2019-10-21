package com.kefi.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kefi.app.model.Student;
import com.kefi.app.services.StudentServiceImpl;

@RestController
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @PostMapping("/students")
    public ResponseEntity<Void> createStudent() {
        List<Student>students  =  studentService.createStudent();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
            "/{id}").buildAndExpand(students.get(0).getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> retrieveStudent(@PathVariable Integer studentId) {
    	
       return new ResponseEntity<>(studentService.retrieveStudent(studentId),HttpStatus.OK);
     //   return new ResponseEntity<>(student,HttpStatus.OK);
    }
    
    @GetMapping("/hello2")
    public ResponseEntity<String> hello() {
			try {
				return new ResponseEntity<String>("hello",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);				
    }
}