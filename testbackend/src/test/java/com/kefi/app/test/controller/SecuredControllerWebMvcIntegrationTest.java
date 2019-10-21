package com.kefi.app.test.controller;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.kefi.app.DemoTestApplication;
import com.kefi.app.model.Student;
import com.kefi.app.repo.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoTestApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SecuredControllerWebMvcIntegrationTest {
 
	@Autowired
    private MockMvc mockMvc; //null?
	
	@Autowired
	private StudentRepository studentRepository;
	@Before
	public void initDB()
	{
		Student student = new Student();
		student.setId(1);
		student.setName("Student");
		studentRepository.save(student);
	}
    @Test
    public void findOne() throws Exception {
        mockMvc.perform(get("/students/1").header("Origin","*"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name",is("Student")));
    }

   
}