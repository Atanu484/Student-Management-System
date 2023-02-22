package com.example.Student.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.Student.model.Student;
import com.example.Student.services.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StudentController.class})
@ExtendWith(SpringExtension.class)
class StudentControllerTest {
    @Autowired
    private StudentController StudentController;

    @MockBean
    private StudentService StudentService;

    /**
     * Method under test: {@link StudentController#createStudent(Student)}
     */
    @Test
    void testCreateStudent() throws Exception {
        when(StudentService.createStudent((Student) any())).thenReturn(new Student(123L, "Jane", "Doe", "42"));

        Student Student = new Student();
        Student.setEmailId("42");
        Student.setFirstName("Jane");
        Student.setId(123L);
        Student.setLastName("Doe");
        String content = (new ObjectMapper()).writeValueAsString(Student);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/Students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(StudentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\"}"));
    }

    /**
     * Method under test: {@link StudentController#getAllStudents()}
     */
    @Test
    void testGetAllStudents() throws Exception {
        when(StudentService.getAllStudents()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/Students");
        MockMvcBuilders.standaloneSetup(StudentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentController#getAllStudents()}
     */
    @Test
    void testGetAllStudents2() throws Exception {
        when(StudentService.getAllStudents()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/Students");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(StudentController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentController#deleteStudent(Long)}
     */
    @Test
    void testDeleteStudent() throws Exception {
        when(StudentService.deleteStudent((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/Students/{id}", 123L);
        MockMvcBuilders.standaloneSetup(StudentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"deleted\":true}"));
    }

    /**
     * Method under test: {@link StudentController#deleteStudent(Long)}
     */
    @Test
    void testDeleteStudent2() throws Exception {
        when(StudentService.deleteStudent((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/v1/Students/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(StudentController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"deleted\":true}"));
    }

    /**
     * Method under test: {@link StudentController#getStudentById(Long)}
     */
    @Test
    void testGetStudentById() throws Exception {
        when(StudentService.getStudentById((Long) any())).thenReturn(new Student(123L, "Jane", "Doe", "42"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/Students/{id}", 123L);
        MockMvcBuilders.standaloneSetup(StudentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\"}"));
    }

    /**
     * Method under test: {@link StudentController#updateStudent(Long, Student)}
     */
    @Test
    void testUpdateStudent() throws Exception {
        when(StudentService.updateStudent((Long) any(), (Student) any()))
                .thenReturn(new Student(123L, "Jane", "Doe", "42"));

        Student Student = new Student();
        Student.setEmailId("42");
        Student.setFirstName("Jane");
        Student.setId(123L);
        Student.setLastName("Doe");
        String content = (new ObjectMapper()).writeValueAsString(Student);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/Students/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(StudentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\"}"));
    }
}

