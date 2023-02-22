package com.example.student.services;

import com.example.student.model.Student;

import java.util.List;

//This is the interface where we will create all the business logic
public interface StudentService {
    Student createstudent(Student student);

    List<Student> getAllstudents();

    boolean deletestudent(Long id);

    Student getstudentById(Long id);

    Student updatestudent(Long id, Student student);
}
