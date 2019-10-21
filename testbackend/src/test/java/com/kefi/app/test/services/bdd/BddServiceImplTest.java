package com.kefi.app.test.services.bdd;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.kefi.app.DemoTestApplication;
import com.kefi.app.model.Student;
import com.kefi.app.services.StudentService;
import com.kefi.app.services.StudentServiceImpl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

@SpringBootTest(classes=DemoTestApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class BddServiceImplTest {
	List<Student> students = null; 

	@Autowired
	StudentService studentService;
	
@Given("^Client has an empty list of student$")
public void client_has_an_empty_list_of_student() throws Throwable {
	students = new ArrayList<Student>();
}

@When("^client create a list of students$")
public void client_create_a_list_of_students() throws Throwable {
	students = studentService.createStudent();
}

@Then("^list can not be empty$")
public void list_can_not_be_empty() throws Throwable {
   Assert.assertTrue(students.size()>0);
}

@Given("^Client has a list of students$")
public void client_has_a_list_of_students() throws Throwable {
   
}

@When("^Client add a student with (\\d+)  \"([^\"]*)\" and \"([^\"]*)\" to list$")
public void client_add_a_student_with_and_to_list(int id, String name, String classeName) throws Throwable {
	studentService.addStudent(id, name, classeName);
}
@Then("^I verify that student with (\\d+) exist$")
public void i_verify_that_student_with_exist(int id) throws Throwable {
   Assert.assertNotNull(studentService.getItrStudents().stream().filter(student->student.getId().equals(id)).findAny().get());
}


}
