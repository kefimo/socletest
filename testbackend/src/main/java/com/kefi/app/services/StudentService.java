package com.kefi.app.services;

import java.util.List;

import com.kefi.app.model.Student;

public interface StudentService {

	void addStudent(int id, String name, String classeName);

	List<Student> createStudent();

	List<Student> getItrStudents();

}
