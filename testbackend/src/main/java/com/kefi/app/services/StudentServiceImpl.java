package com.kefi.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kefi.app.model.Student;
import com.kefi.app.repo.StudentRepository;

@Component
public class StudentServiceImpl implements StudentService{
	   List<Student> itrStudents= null;
    @Autowired
    private StudentRepository repository;
    @PostConstruct
    @Override
    public List<Student> createStudent() {
        List<Student> students = new ArrayList<Student>();
        List<Student> savedStudents = new ArrayList<Student>();
        students.add(new Student(1,"Rajesh Bhojwani", "Class 10"));
        students.add(new Student(2,"Sumit Sharma", "Class 9"));
        students.add(new Student(3,"Rohit Chauhan", "Class 10"));
        this.itrStudents=repository.saveAll(students);
        itrStudents.forEach(savedStudents::add);
        return itrStudents;
    }
    public Student retrieveStudent(Integer studentId) {
       return repository.findById(studentId).orElse(new Student());
    }
    @Override
	public void addStudent(int id, String name, String classeName) {
		this.itrStudents.add(new Student(id,name, classeName));
	}
    @Override
	public List<Student> getItrStudents() {
		return itrStudents;
	}
	public void setItrStudents(List<Student> itrStudents) {
		this.itrStudents = itrStudents;
	}
	
    
    
    
    
    
}