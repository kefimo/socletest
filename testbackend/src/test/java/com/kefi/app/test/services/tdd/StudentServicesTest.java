package com.kefi.app.test.services.tdd;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.kefi.app.model.Student;
import com.kefi.app.repo.StudentRepository;
import com.kefi.app.services.StudentService;
import com.kefi.app.services.StudentServiceImpl;

public class StudentServicesTest {

	 @Mock
	 private StudentRepository repository;
	@InjectMocks
	private StudentServiceImpl studentService;
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		this.initMocks();
	}
	
	@Test
	public void should_get_list_students_as_null()
	{
		// PostConstruct can not be executed automatically with Mock
		List<Student>students = studentService.getItrStudents();
		Assert.assertNull(students);
	}
	@Test
	public void should_get_list_students()
	{
		studentService.createStudent();
		List<Student>students = studentService.getItrStudents();
		Assert.assertNotNull(students);
	}
	
	
	private void initMocks()
	{
		  List<Student> students = new ArrayList<Student>();
	        students.add(new Student(1,"Rajesh Bhojwani", "Class 10"));
	        students.add(new Student(2,"Sumit Sharma", "Class 9"));
	        students.add(new Student(3,"Rohit Chauhan", "Class 10"));
	        Mockito.when(repository.saveAll(Mockito.anyCollection())).thenReturn(students);
	}
	
}
